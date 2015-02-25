package de.codecentric.util;

import org.springframework.web.util.HtmlUtils;

public class Html {

    public static String escapeHtml(String html) {
        return HtmlUtils.htmlEscape(html);
    }

    public static String unEscapeHtml(String html) {
        return HtmlUtils.htmlUnescape(html);
    }

    public static String lineBreaksToBrTags(String string) {
        return string == null ? null : string.replace("\n", "<br/>");
    }

    public static String brTagsToLineBreaks(String string) {
        return string == null ? null : string.replace("<br/>", "\n");
    }

}
