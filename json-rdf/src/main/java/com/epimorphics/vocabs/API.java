/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) copyright Epimorphics Limited 2010
    $Id$
*/

package com.epimorphics.vocabs; 
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*;
 
/**
 * Vocabulary definitions from src/main/vocabs/api.ttl 
 * @author Auto-generated by schemagen on 08 Sep 2010 14:46 
 */
public class API {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.RDFS_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.org/linked-data/api/vocab#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>The base URI of the API, which is distinct from the URI of the SPARQL endpoint 
     *  that it queries or the base URI of the instances that it returns. This base 
     *  URI is stripped from the request URI before any matching is done against the 
     *  endpoints defined for the API.</p>
     */
    public static final OntProperty base = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#base" );
    
    /** <p>The mechanism used within the URI to override normal content negotiation and 
     *  deliver a particular results format.</p>
     */
    public static final OntProperty contentNegotiation = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#contentNegotiation" );
    
    /** <p>The default formatter used if none is explicitly selected within the request 
     *  URI.</p>
     */
    public static final OntProperty defaultFormatter = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#defaultFormatter" );
    
    /** <p>The default size of lists that will be returned by the API or endpoint.</p> */
    public static final OntProperty defaultPageSize = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#defaultPageSize" );
    
    /** <p>The default viewer used if none is explicitly selected within the request 
     *  URI.</p>
     */
    public static final OntProperty defaultViewer = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#defaultViewer" );
    
    /** <p>An endpoint specified by the API, against which requests can be made.</p> */
    public static final OntProperty endpoint = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#endpoint" );
    
    /** <p>A set of parameter bindings in the same format as is used within the query 
     *  of a URI, used to provide a simple way of filtering the sequence of items 
     *  that the selector selects.</p>
     */
    public static final OntProperty filter = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#filter" );
    
    /** <p>A formatter that can be used with the endpoint.</p> */
    public static final OntProperty formatter = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#formatter" );
    
    /** <p>Other viewers that describe properties that should be incorporated into this 
     *  view.</p>
     */
    public static final OntProperty include = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#include" );
    
    /** <p>A template for the URI of the item that the item endpoint should return. Any 
     *  instances of {varName} within the string are replaced by the value of the 
     *  relevant variable.</p>
     */
    public static final OntProperty itemTemplate = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#itemTemplate" );
    
    /** <p>The maximum size of lists that will be returned by the API.</p> */
    public static final OntProperty maxPageSize = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#maxPageSize" );
    
    /** <p>The mime type that the formatter returns and that it should be used with.</p> */
    public static final OntProperty mimeType = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#mimeType" );
    
    /** <p>The name of the resource.</p> */
    public static final OntProperty name = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#name" );
    
    /** <p>A space separated sequence of OrderConditions suitable for using in a SPARQL 
     *  ORDER BY clause. This is used to order the sequence of items that the selector 
     *  selects.</p>
     */
    public static final OntProperty orderBy = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#orderBy" );
    
    /** <p>The parent selector, from which filters and sort specifications may be inherited.</p> */
    public static final OntProperty parent = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#parent" );
    
    /** <p>A comma-separated list of property paths that indicate the information that 
     *  should be included in the view.</p>
     */
    public static final OntProperty properties = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#properties" );
    
    /** <p>A property chain (which may be a single property) that indicates information 
     *  that should be included in the view.</p>
     */
    public static final OntProperty property = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#property" );
    
    /** <p>A SPARQL WHERE and ORDER BY clause that can be used to select an ordered list 
     *  of resources. It should include the binding of an ?item variable for the selected 
     *  items.</p>
     */
    public static final OntProperty select = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#select" );
    
    /** <p>The selector that should be used to generate the list of items.</p> */
    public static final OntProperty selector = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#selector" );
    
    /** <p>A sequence of comma-separated sort specifications indicating the sorting of 
     *  the items in the sequence that the selector selects. A leading hyphen indicates 
     *  a reverse sort.</p>
     */
    public static final OntProperty sort = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#sort" );
    
    /** <p>The endpoint used to serve up the results that are exposed by the API. This 
     *  should not include the query parameters within the URI.</p>
     */
    public static final OntProperty sparqlEndpoint = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#sparqlEndpoint" );
    
    /** <p>The XSLT stylesheet that should be used by an XSLT formatter to generate a 
     *  representation of the RDF graph</p>
     */
    public static final OntProperty stylesheet = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#stylesheet" );
    
    /** <p>SPARQL that can be used to construct a graph based on an item (identified 
     *  in the SPARQL as ?item).</p>
     */
    public static final OntProperty template = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#template" );
    
    /** <p>A template that can be used to match against request URIs. This template can 
     *  contain variable names within {}s; when the URI is matched then the substrings 
     *  that appear in these locations are bound to the named variable.</p>
     */
    public static final OntProperty uriTemplate = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#uriTemplate" );
    
    /** <p>A viewer that can be used with the endpoint.</p> */
    public static final OntProperty viewer = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#viewer" );
    
    /** <p>A vocabulary that should be used by the configuration to provide labels for 
     *  properties. To be recognised for filtering, a property must be defined either 
     *  within this vocabulary or in the configuration file itself.</p>
     */
    public static final OntProperty vocabulary = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#vocabulary" );
    
    /** <p>A GroupGraphPattern suitable for embedding within a SPARQL WHERE clause. This 
     *  is used for filtering the set of items that the selector selects.</p>
     */
    public static final OntProperty where = m_model.createOntProperty( "http://purl.org/linked-data/api/vocab#where" );
    
    public static final OntClass API = m_model.createClass( "http://purl.org/linked-data/api/vocab#API" );
    
    public static final OntClass ContentNegotiationStrategy = m_model.createClass( "http://purl.org/linked-data/api/vocab#ContentNegotiationStrategy" );
    
    /** <p>A formatter that generates a simple CSV representation of an RDF graph</p> */
    public static final OntClass CsvFormatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#CsvFormatter" );
    
    /** <p>An endpoint exposed by the API.</p> */
    public static final OntClass Endpoint = m_model.createClass( "http://purl.org/linked-data/api/vocab#Endpoint" );
    
    /** <p>A formatter that creates a representation from an RDF graph.</p> */
    public static final OntClass Formatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#Formatter" );
    
    /** <p>An endpoint that returns information about a single instance.</p> */
    public static final OntClass ItemEndpoint = m_model.createClass( "http://purl.org/linked-data/api/vocab#ItemEndpoint" );
    
    /** <p>A formatter that generates a simple JSON representation of an RDF graph</p> */
    public static final OntClass JsonFormatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#JsonFormatter" );
    
    /** <p>An endpoint that returns information about a list of instances.</p> */
    public static final OntClass ListEndpoint = m_model.createClass( "http://purl.org/linked-data/api/vocab#ListEndpoint" );
    
    /** <p>A formatter that generates an RDF/XML representation of an RDF graph</p> */
    public static final OntClass RdfXmlFormatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#RdfXmlFormatter" );
    
    /** <p>A specification of an ordered list of resources.</p> */
    public static final OntClass Selector = m_model.createClass( "http://purl.org/linked-data/api/vocab#Selector" );
    
    /** <p>A formatter that gives the default Turtle representation of an RDF graphA 
     *  formatter that generates an Turtle representation of an RDF graph</p>
     */
    public static final OntClass TurtleFormatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#TurtleFormatter" );
    
    /** <p>A specification of a view of a particular item.</p> */
    public static final OntClass Viewer = m_model.createClass( "http://purl.org/linked-data/api/vocab#Viewer" );
    
    /** <p>A formatter that generates a simple XML representation of an RDF graph</p> */
    public static final OntClass XmlFormatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#XmlFormatter" );
    
    /** <p>A formatter that uses an XSLT stylesheet to generates a representation of 
     *  an RDF graph</p>
     */
    public static final OntClass XsltFormatter = m_model.createClass( "http://purl.org/linked-data/api/vocab#XsltFormatter" );
    
    /** <p>A viewer that returns the type and label of the item.</p> */
    public static final Individual basicViewer = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#basicViewer", Viewer );
    
    /** <p>A formatter that gives the default simple CSV representation of an RDF graph</p> */
    public static final Individual csvFormatter = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#csvFormatter", m_model.createClass( "http://purl.org/linked-data/api/vocab#csvFormatter" ) );
    
    /** <p>A viewer that returns a graph created from a DESCRIBE query.</p> */
    public static final Individual describeViewer = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#describeViewer", Viewer );
    
    /** <p>A formatter that gives the default simple JSON representation of an RDF graph</p> */
    public static final Individual jsonFormatter = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#jsonFormatter", m_model.createClass( "http://purl.org/linked-data/api/vocab#jsonFormatter" ) );
    
    /** <p>A viewer that returns the graph created from a DESCRIBE query, supplemented 
     *  by labels for linked resources.</p>
     */
    public static final Individual labelledDescribeViewer = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#labelledDescribeViewer", Viewer );
    
    /** <p>This content negotiation strategy uses the _format parameter within the URI 
     *  to indicate the formatter that should be used to format the results of the 
     *  request.</p>
     */
    public static final Individual parameterBased = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#parameterBased", ContentNegotiationStrategy );
    
    /** <p>A formatter that gives the default RDF/XML representation of an RDF graph</p> */
    public static final Individual rdfXmlFormatter = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#rdfXmlFormatter", RdfXmlFormatter );
    
    /** <p>This content negotiation strategy uses the suffix used on the last segment 
     *  within the request URI to indicate the formatter that should be used to format 
     *  the results of the request.</p>
     */
    public static final Individual suffixBased = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#suffixBased", ContentNegotiationStrategy );
    
    /** <p>A formatter that gives the default simple XML representation of an RDF graph</p> */
    public static final Individual xmlFormatter = m_model.createIndividual( "http://purl.org/linked-data/api/vocab#xmlFormatter", m_model.createClass( "http://purl.org/linked-data/api/vocab#xmlFormatter" ) );
    
}
