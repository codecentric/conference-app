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
        String validTwitterName = "@foobar";
        String linkWithOneTwitterName = twitterAddress + "foobar\">@foobar</a>";

        String result = TwitterLinkCreator.process(validTwitterName);

        assertEquals(linkWithOneTwitterName, result);
	}
	
	@Test
	public void shouldProcessSeveralTwitterNames() {
        String twoValidTwitterNames = "@foo, @bar";
        String linkWithTwoTwitterNames = twitterAddress + "foo\">@foo</a>, " + twitterAddress + "bar\">@bar</a>";

        String result = TwitterLinkCreator.process(twoValidTwitterNames);

        assertEquals(linkWithTwoTwitterNames, result);
	}
	
	@Test
	public void shouldProcessNameWithUnderscore() {
        String validTwitterNameWithUnderscore = "@foo_bar";
        String linkWithOneTwitterName = twitterAddress + "foo_bar\">@foo_bar</a>";

        String result = TwitterLinkCreator.process(validTwitterNameWithUnderscore);

        assertEquals(linkWithOneTwitterName, result);
	}
}