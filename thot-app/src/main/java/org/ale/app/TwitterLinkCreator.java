package org.ale.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterLinkCreator {

	private static Pattern p = Pattern.compile("@[a-zA-Z0-9_]+");
	
	public static String process(String input) {
		String result = input;
		Matcher m = p.matcher(result);
		
		while ( m.find() ) {
			final String name = m.group();
			result = result.replaceFirst(name, "<a href=\"http://twitter.com/" + name.substring(1) +"\">" + name + "</a>");
		}
		
		return result;
	}
}
