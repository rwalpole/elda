/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/

package com.epimorphics.lda.renderers;

import java.io.OutputStream;

import com.epimorphics.lda.bindings.Bindings;
import com.epimorphics.lda.core.APIResultSet;
import com.epimorphics.lda.support.Times;
import com.epimorphics.util.MediaType;

/**
    Renderers -- turning result sets into byte streams.
 	@author chris, dave
*/
public interface Renderer {

	/**
	    Renderers produce BytesOut objects which will then
	    stream the rendering to a provided output stream
	    later.
	 
	 	@author chris
	*/
	public interface BytesOut {
		public void writeAll(Times t, OutputStream os);
	}
	
	/**
     	@return the mimetype which this renderer returns
     		in the given renderer context.
    */
    public MediaType getMediaType( Bindings rc );
    
    /**
     	Render a result set. Use t to log times if required.
    */
    public BytesOut render( Times t, Bindings rc, APIResultSet results );

    /**
     	Answer the format suffix associated with this renderer.
    */
	public String getPreferredSuffix();
}

