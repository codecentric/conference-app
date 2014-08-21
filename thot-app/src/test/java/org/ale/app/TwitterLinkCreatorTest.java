package org.ale.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TwitterLinkCreatorTest {

    private String twitterAddress;

    @Before
    public void setup(){
        twitterAddress = "<a href=\"http://twitter.com/";
    }

    @Test
	public void shouldProcessSingleTwitterName() {
        String result = TwitterLinkCreator.process("@foobar");

        assertEquals(twitterAddress +"foobar\">@foobar</a>", result);
	}
	
	@Test
	public void shouldProcessSeveralTwitterNames() {
		String result = TwitterLinkCreator.process("@foo, @bar");

        assertEquals(twitterAddress +"foo\">@foo</a>, "+twitterAddress+"bar\">@bar</a>", result);
	}
	
	@Test
	public void shouldProcessNameWithUnderscore() {
		String result = TwitterLinkCreator.process("@foo_bar");

        assertEquals(twitterAddress +"foo_bar\">@foo_bar</a>", result);
	}
}
