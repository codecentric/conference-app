package de.codecentric.validate.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.codecentric.validate.TimeValidator;

public class Time24HoursValidator implements TimeValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

    public Time24HoursValidator() {
        pattern = Pattern.compile(TIME24HOURS_PATTERN);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.codecentric.validate.impl.TimeValidator#validate(java.lang.String)
     */
    @Override
    public boolean validate(final String time) {
        matcher = pattern.matcher(time);
        return matcher.matches();
    }

}