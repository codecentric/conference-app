package de.codecentric.validate;

public interface TimeValidator {

    /**
     * Validate time in 24 hours format with regular expression
     * 
     * @param time
     *            time address for validation
     * @return true valid time format, false invalid time format
     */
    public abstract boolean validate(String time);

}