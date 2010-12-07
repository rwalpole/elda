/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) copyright Epimorphics Limited 2010
    $Id$
*/

package com.epimorphics.lda.support;

import java.util.ArrayList;
import java.util.List;

import com.epimorphics.util.CollectionUtils;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

/**
    A PropertyChain is a sequence of properties, to be used to trawl
    down a model.
    
 	@author chris
*/
public class PropertyChain {
	
	protected final List<Property> chain;
	
	public PropertyChain(List<Property> chain) {
		this.chain = chain;
	}
	
	public PropertyChain( String URI ) {
		this( CollectionUtils.list(ResourceFactory.createProperty( URI ) ) );		
	}
	
	@Override public String toString() {
		return chain.toString();
	}
	
	public List<Property> getProperties() {
		return new ArrayList<Property>( chain );
	}
}