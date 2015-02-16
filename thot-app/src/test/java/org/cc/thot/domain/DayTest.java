package org.cc.thot.domain;

import java.util.ArrayList;

import junit.framework.Assert;

import org.cc.thot.domain.Day;
import org.cc.thot.domain.Timeslot;
import org.junit.Test;

public class DayTest {

    @Test
    public void testGetShortNameWithoutDots() throws Exception {
	Day day = new Day("20.08.2014", new ArrayList<Timeslot>());
	Assert.assertEquals("20082014", day.getShortNameWithoutDots());
    }

}
