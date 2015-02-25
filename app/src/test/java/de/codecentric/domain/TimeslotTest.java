package de.codecentric.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.codecentric.domain.Timeslot;

public class TimeslotTest {

    @Test
    public void shouldFormatStringForTimeslotWithStartAndEnd() {
        Timeslot timeslot = new Timeslot("15:30", "16:15");

        String formatedTimeslot = timeslot.toString();

        assertEquals("15:30 - 16:15", formatedTimeslot);
    }

    @Test
    public void shouldFormatStringForTimeslotWithOnlyStart() {
        Timeslot timeslot = new Timeslot("15:30");

        String formatedTimeslot = timeslot.toString();

        assertEquals("15:30", formatedTimeslot);
    }

}
