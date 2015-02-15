package org.ale.thot.web.model;

import static org.junit.Assert.assertEquals;

import org.ale.thot.model.Html;
import org.junit.Test;

public class HtmlTest {

    @Test
    public void escapeHtmlLt() throws Exception {
	assertEquals("&lt;", Html.escapeHtml("<"));
    }

    @Test
    public void escapeHtmlGt() throws Exception {
	assertEquals("&gt;", Html.escapeHtml(">"));
    }

    @Test
    public void lineBrTagWhenLineBreak() throws Exception {
	assertEquals("<br/>", Html.lineBreaksToBrTags("\n"));
    }

    @Test
    public void lineBrTagWhenLineBreakBetweenTwoParagraphs() throws Exception {
	assertEquals("a<br/>b", Html.lineBreaksToBrTags("a\nb"));
    }

    @Test
    public void brTagsToLineBreaksWhenLineBreakBetweenTwoParagraphs() throws Exception {
	assertEquals("a\nb", Html.brTagsToLineBreaks("a<br/>b"));
    }
}
