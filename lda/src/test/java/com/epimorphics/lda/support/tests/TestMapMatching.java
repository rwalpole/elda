/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) copyright Epimorphics Limited 2010
    $Id$
*/
package com.epimorphics.lda.support.tests;


import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.hp.hpl.jena.test.JenaTestBase.setOfStrings;

import com.epimorphics.lda.support.MapMatching;
import com.epimorphics.lda.tests_support.MakeData;

public class TestMapMatching 
	{
	@Test public void ensureEmptyMapProducesEmptySet()
		{
		Properties p = MakeData.properties( "" );
		Set<String> all = MapMatching.allValuesWithMatchingKey( "none.whatsoever", p );
		assertEquals( new HashSet<String>(), all );
		}

	@Test public void ensureAbsentKeysProduceEmptySetA()
		{
		Properties p = MakeData.properties( "present.key=17" );
		Set<String> all = MapMatching.allValuesWithMatchingKey( "none.whatsoever", p );
		assertEquals( new HashSet<String>(), all );
		}
	
	@Test public void ensurePresentKeyProducesSingletonSet()
		{
		Properties p = MakeData.properties( "this.key=silver" );
		Set<String> all = MapMatching.allValuesWithMatchingKey( "this.key", p );
		assertEquals( setOfStrings( "silver" ), all );
		}
	
	@Test public void ensurePresentKeyListProducesMultipleSet()
		{
		Properties p = MakeData.properties( "listy.key=silver,gold" );
		Set<String> all = MapMatching.allValuesWithMatchingKey( "listy.key", p );
		assertEquals( setOfStrings( "silver gold" ), all );
		}
	
	@Test public void ensureMultipleRelatedKeysProduceResults()
		{
		Properties p = MakeData.properties( "this.key.A=hay this.key.B=bee this.ke=NO" );
		Set<String> all = MapMatching.allValuesWithMatchingKey( "this.key.*", p );
		assertEquals( setOfStrings( "hay bee" ), all );
		}
	
	@Test public void ensureMultipleListyKeysAllAppear()
		{
		Properties p = MakeData.properties( "this.key.A=apple,acorn this.key.B.C=bee,badger" );
		Set<String> all = MapMatching.allValuesWithMatchingKey( "this.key.*", p );
		assertEquals( setOfStrings( "apple acorn bee badger"), all );
		}
	}
