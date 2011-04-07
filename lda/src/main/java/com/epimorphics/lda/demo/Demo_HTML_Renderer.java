package com.epimorphics.lda.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.epimorphics.lda.core.APIEndpoint;
import com.epimorphics.lda.core.APIResultSet;
import com.epimorphics.lda.renderers.Renderer;
import com.epimorphics.lda.renderers.RendererContext;
import com.epimorphics.lda.shortnames.ShortnameService;
import com.epimorphics.lda.vocabularies.XHV;
import com.epimorphics.util.Couple;
import com.epimorphics.util.Util;
import com.epimorphics.vocabs.FIXUP;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.vocabulary.RDFS;

public class Demo_HTML_Renderer implements Renderer {

	protected final APIEndpoint endpoint;
	protected final ShortnameService sns;
	
    public Demo_HTML_Renderer( APIEndpoint ep, ShortnameService sns ) {
    	this.sns = sns;
    	this.endpoint = ep;
    }

	@Override public String getMediaType() {
        return "text/html";
    }

    @Override public String render( RendererContext ignored, APIResultSet results ) {
    	boolean isItemRendering = results.listStatements( null, FIXUP.items, (RDFNode) null ).hasNext() == false;
        return isItemRendering ? renderItem(results) : renderList(results);
    }

	private String renderItem( APIResultSet results ) {
		StringBuilder textBody = new StringBuilder();
        Resource root = results.getRoot();
        h1( textBody, "properties of " + root.getURI() );
        renderResourceDetails( textBody, root );
		return Util.withBody( "description of " + root, textBody.toString() );
	}

	public String renderList(APIResultSet results) {
		StringBuilder textBody = new StringBuilder();
        Resource root = results.getRoot();
        String main = root.getURI();
        String title = main.replace( "http://localhost:8080/elda/api/", "").replaceAll( "[?&]", " ");
        h1( textBody, "Elda: " + title );
        Resource anchor = results.listStatements( null, FIXUP.items, (RDFNode) null ).next().getSubject();
        for (RDFNode elem: anchor.getProperty( FIXUP.items ).getResource().as( RDFList.class ).asJavaList())
            {
        	textBody.append( "\n<div class='one-item'>\n" );
            Resource e = (Resource) elem;
            String name = getSubjectName( e );
            h2( textBody, name );
            renderResourceDetails(textBody, e);
            textBody.append( "\n</div>" );
            }
        linkyBits( textBody, anchor );
        return Util.withBody( "Elda result set", textBody.toString() );
	}

	private String getSubjectName( Resource e ) 
		{
		return 
			e.hasProperty( SCHOOL.establishmentName) ? e.getProperty(SCHOOL.establishmentName).getString() 
			: e.hasProperty(RDFS.label) ? e.getProperty(RDFS.label).getString() 
			: "School #" + e.getURI().replaceFirst( ".*[/#]", "" )
			;
		}

	Comparator<Couple<String, String>> compareStringCouple = new Comparator<Couple<String, String>>() 
		{
		@Override public int compare(Couple<String, String> x, Couple<String, String> y) 
			{
			int a = x.a.compareTo(y.a);
			return a == 0 ? y.a.compareTo(y.b) : a;
			}
		};
	
	public void renderResourceDetails(StringBuilder textBody, Resource e) 
		{
		List<Couple<String, String>> props = new ArrayList<Couple<String, String>>();
		String x = "http://localhost:8080/elda/api/education/schools";
		for (Statement s: e.listProperties().toList()) { 
		    boolean isAnon = s.getObject().isAnon();
		    // String primaryText = brief( "font-weight: bold", s.getPredicate() ) + " " + (isAnon ? "" : brief( s.getObject()) );
		    Property p = s.getPredicate();
		    String property = briefName( p );
		    String value = brief( s.getObject() );
		    if (s.getObject().isResource())
		    	{
		    	Resource o = s.getObject().asResource();
		    	Statement label = o.getProperty(RDFS.label);
		    	if (label != null) value = label.getString(); 
		    	value = value + " " + resRequest( x, p, o );
		    	}
		    else if (s.getObject().isLiteral()) 
		    	{
		    	String u = s.getObject().asLiteral().getDatatypeURI();
		    	if (u != null)
			    	{
			    	if (u.endsWith("#integer")) //  || u.endsWith("#date"))
			    		{
			    		value = intRequest(x, "max", p, value) + " " + value + " " + intRequest( x, "min", p, value );
			    		}
			    	}
		    	}
//		    StringBuilder secondary = new StringBuilder();
//		    if (isAnon)
//		        {
//		        List<String> details = new ArrayList<String>();
//		        for (Statement ss: s.getResource().listProperties().toList())
//		            details.add( brief( "font-weight: bold", ss.getPredicate() ) + " " + brief( ss.getObject() ) );
//		        Collections.sort( details );
//		        for (String detail: details)
//		        	{
//		        	div( secondary, "property-details", "\n" + detail );
//		        	}
//		        }
		    props.add( new Couple<String, String>( property, value ) );
		}
		Collections.sort(props, compareStringCouple);
	//
		textBody.append( "<table class='zebra' style='margin-left: 2ex'>" );
		int count = 0;
		for (Couple<String, String> prop : props) 
			{
			count += 1;
			textBody.append( "<tr>" )
				.append( "<td align='right'>" ).append( prop.a ).append( "</td>" )
				.append( "<td>" ).append( prop.b ).append( "</td>" )
				.append( "</tr>" )
				.append( "\n" )
				;
			}
		textBody.append( "</table>" );
	}

    private String resRequest(String base, Property p, Resource o )
    	{
    	String shortP = sns.shorten( p.getURI() );
    	String os = briefName(o);
    	String shortO = sns.shorten( o.getURI() );
    	if (shortO == null) shortO = o.getURI();
    	String uri = base + ".html" + "?" + shortP + "=" + shortO;
    	String image = "[similar]";
    	String title = "click to see other items with the same property-value";
    	return "<a href='" + uri + "' title='" + protect(title) + "'>" + image + "</a>";
    	}

	private String intRequest(String base, String minormax, Property p, String value ) 
    	{
    	String shortP = sns.shorten( p.getURI() );
    	String uri = base + ".html" + "?" + minormax + "-" + shortP + "=" + value;
    	String image = minormax.equals("max") ? "&#0171;" : "&#0187;";
    	return "<a href='" + uri + "' title='" + protect( rangeTitle(minormax, value) ) + "'>" + image + "</a>";
    	}

	private String rangeTitle(String minormax, String value) {
		String x = minormax.equals("min") ? "more than" : "less than";
		return "click to show only items with values " + x + " " + value;
	}

	private void linkyBits( StringBuilder textBody, Resource anchor )
        {
        Statement first = anchor.getProperty( XHV.first );
        Statement next = anchor.getProperty( XHV.next );
        Statement prev = anchor.getProperty( XHV.prev );        
        textBody
        	.append( "\n" )
        	.append( "<table class='paging-links' width='100%'>" )
        	.append( "<tr>" )
        	.append( paging_link( "first", "left", first ) )
        	.append( paging_link( "prev", "center", prev ) )
        	.append( paging_link( "next", "right", next ) )
        	.append("</tr>" )
        	.append( "</table>" )
        	;      
        }
    
    private String paging_link( String label, String align, Statement s ) 
    	{
    	if (s == null) return "";
    	Resource r = s.getResource();
        return "<td text-align='" + align + "'><a href='" + r.getURI() + "'>" + safe(label) + "</a></td>";
    	}

    private String link_to( String label, String uri )
        {
        return " <a href='" + uri + "'>" + safe(label) + "</a>";
        }

    private void div( StringBuilder x, String classes, String content )
        {
        x.append( "\n<div class='"  ).append( classes ).append( "'>" ).append( content ).append( "</div>" );
        }

    private String brief( String styles, RDFNode x )
    	{
    	return "<span style='" + styles + "'>" + brief( x ) + "</span>";
    	}
    
    private String briefName( RDFNode x )
        {
        return
            x.isAnon() ? x.asNode().getBlankNodeLabel()
            : x.isResource() ? qname( (Resource) x ) 
            : protect( x.asNode().getLiteralLexicalForm() )
            ;
        }
    
    private String brief( RDFNode x )
        {
        return
            x.isAnon() ? x.asNode().getBlankNodeLabel()
            : x.isResource() ? activeQname( (Resource) x ) 
            : protect( x.asNode().getLiteralLexicalForm() )
            ;
        }

    private String activeQname( Resource x ) 
    	{
    	return "<a href='" + x.getURI() + "'>" + qname(x) + "</a>";
    	}

	private String protect(String s ) 
    	{
    	return s.replaceAll("&", "&amp;").replaceAll("<", "&lt;" );
    	}

	private String qname( Resource x )
        { 
    	String s = sns.shorten( x.getURI() );
    	return s == null ? x.getModel().shortForm( x.getURI() ) : s;
        }

    private void h1( StringBuilder textBody, String s ) {  
        textBody.append( "\n<h1>" ).append( safe( s ) ).append( "</h1>" );        
    }

    private void h2( StringBuilder textBody, String s ) {  
        textBody.append( "\n<h2>" ).append( safe( s ) ).append( "</h2>" );        
    }

    private String safe( String s ) {
        return s.replace( "&", "&amp;" ).replace( "<", "&lt;" );
    }
}