/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) copyright Epimorphics Limited 2010
    $Id$
*/

/******************************************************************
    File:        Router.java
    Created by:  Dave Reynolds
    Created on:  31 Jan 2010
 * 
 * (c) Copyright 2010, Epimorphics Limited
 * $Id:  $
 *****************************************************************/

package com.epimorphics.lda.routing;

import com.epimorphics.lda.core.APIEndpoint;

/**
 * Abstraction for the dispatch part of the API. Supports dynamic
 * registration of URI templates against API instances. Could
 * be implemented directly by a servlet, via Restlet or via
 * a JAX-RS hack. Initially assume JAX-RS, just need to work out how.
 * 
 * TODO: determine how to persist the routing table when running under GAE-JDO
 * 
 * @author <a href="mailto:der@hplb.hpl.hp.com">Dave Reynolds</a>
 * @version $Revision: $
 */
public interface Router {

    /**
     * Register a new API instance.
     * @param URITemplate the path template, relative server root
     * @param api the api implementation
     */
    void register(String URITemplate, APIEndpoint api);
    
    /**
     * Remove a registered api
     */
    void unregister(String URITemplate);
    
    /**
     * Match the request path to the known endpoints and return
     * a Match object (giving the APIEndpoint and any template bindings)
     * or null if the request does not match.
     */
    public Match getMatch( String path );
    
}

