package de.codecentric.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.codecentric.util.TwitterLinkCreator;

public class TwitterLinkCreatorTest {

    String twitterLink;

    @Before
    public void setup() {

        twitterLink = "http://twitter.com/";
    }

    @Test
    public void shouldProcessSingleTwitterName() {
        String validTwitterName = "@foobar";
        String linkWithOneTwitterName = "<a href=\"" + twitterLink + "foobar\">@foobar</a>";

        String result = TwitterLinkCreator.process(validTwitterName);

        assertEquals(linkWithOneTwitterName, result);
    }

    @Test
    public void shouldProcessSeveralTwitterNames() {
        String twoValidTwitterNames = "@foo, @bar";
        String linkWithTwoTwitterNames = "<a href=\"" + twitterLink + "foo\">@foo</a>, " + "<a href=\"" + twitterLink + "bar\">@bar</a>";

        String result = TwitterLinkCreator.process(twoValidTwitterNames);

        assertEquals(linkWithTwoTwitterNames, result);
    }

    @Test
    public void shouldProcessNameWithUnderscore() {
        String validTwitterNameWithUnderscore = "@foo_bar";
        String linkWithOneTwitterName = "<a href=\"" + twitterLink + "foo_bar\">@foo_bar</a>";

        String result = TwitterLinkCreator.process(validTwitterNameWithUnderscore);

        assertEquals(linkWithOneTwitterName, result);
    }
}
