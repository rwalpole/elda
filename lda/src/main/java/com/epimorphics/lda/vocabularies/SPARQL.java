/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/
package com.epimorphics.lda.vocabularies;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

/**
    A stub for the necessary SPARQL vocabulary.
    
 	@author eh
*/
public class SPARQL {

	private static Property property( String ns, String local )
        { return ResourceFactory.createProperty( ns + local ); }

    private static Resource resource( String ns, String local )
        { return ResourceFactory.createResource( ns + local ); }

	public static final String NS = "http://purl.org/net/opmv/types/sparql#";
	
	public static final Resource QueryResult = resource( NS, "QueryResult" );
	public static final Property query = property( NS, "query" );

}