package org.ale.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TwitterLinkCreatorTest {

	@Test
	public void shouldProcessSingleTwitterName() {
		String result = TwitterLinkCreator.process("@foobar");
		assertEquals("<a href=\"http://twitter.com/foobar\">@foobar</a>", result);
	}
	
	@Test
	public void shouldProcessSeveralTwitterNames() {
		String result = TwitterLinkCreator.process("@foo, @bar");
		assertEquals("<a href=\"http://twitter.com/foo\">@foo</a>, <a href=\"http://twitter.com/bar\">@bar</a>", result);
	}
	
	@Test
	public void shouldProcessNameWithDash() {
		String result = TwitterLinkCreator.process("@foo_bar");
		assertEquals("<a href=\"http://twitter.com/foo_bar\">@foo_bar</a>", result);
	}
}
