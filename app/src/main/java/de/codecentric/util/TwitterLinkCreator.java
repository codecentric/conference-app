package de.codecentric.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterLinkCreator {

    public static final Pattern TWITTER_NAME_PATTERN = Pattern.compile("@[a-zA-Z0-9_]+");

    public static String process(String result) {
        Matcher m = TWITTER_NAME_PATTERN.matcher(result);

        while (m.find()) {
            final String name = m.group();
            result = result.replaceFirst(name, "<a href=\"http://twitter.com/" + name.substring(1) + "\">" + name + "</a>");
        }

        return result;
    }
}
