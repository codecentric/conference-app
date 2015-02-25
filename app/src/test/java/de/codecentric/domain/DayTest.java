package de.codecentric.domain;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import de.codecentric.domain.Day;
import de.codecentric.domain.Timeslot;

public class DayTest {

    @Test
    public void testGetShortNameWithoutDots() throws Exception {
        Day day = new Day("20.08.2014", new ArrayList<Timeslot>());
        Assert.assertEquals("20082014", day.getShortNameWithoutDots());
    }

}
