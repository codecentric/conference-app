package de.codecentric.controller;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.codecentric.domain.Location;
import de.codecentric.domain.Session;

public class AllSessionsControllerTest {

    public static String NODESC = "";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldArrangeOneSessionByLocation() {

        List<Session> sessions = new ArrayList<Session>();
        sessions.add(new Session("Wed", "15:30", "orange", "title1", "toto", "description"));

        List<Location> list = Arrays.asList(new Location("orange", NODESC));
        Map<String, Map<String, Session>> transformedSessions = AllSessionsController.groupSessionsByLocationsSlots(list, sessions);

        notEmpty(transformedSessions);
        notEmpty(transformedSessions.get("orange"));
    }

    @Test
    public void shouldArrangeTwoSessionsByLocations() {
        List<Session> sessions = new ArrayList<Session>();
        sessions.add(new Session("Wed", "15:30", "orange", "title1", "toto", "description"));
        sessions.add(new Session("Wed", "15:30", "red", "title2", "toto", "description"));

        List<Location> list = Arrays.asList(new Location("orange", NODESC), new Location("red", NODESC));
        Map<String, Map<String, Session>> transformedSessions = AllSessionsController.groupSessionsByLocationsSlots(list, sessions);

        isTrue(transformedSessions.size() == 2);
        notEmpty(transformedSessions.get("red"));
        isTrue(transformedSessions.get("red").size() == 1);
    }

    @Test
    public void shouldArrangeSessionsInSameLocationBySlot() {
        List<Session> sessions = new ArrayList<Session>();
        sessions.add(new Session("Wed", "15:30", "red", "title1", "toto", "description"));
        sessions.add(new Session("Wed", "16:15", "red", "title2", "toto", "description"));

        List<Location> list = Arrays.asList(new Location("red", NODESC));
        Map<String, Map<String, Session>> transformedSessions = AllSessionsController.groupSessionsByLocationsSlots(list, sessions);

        isTrue(transformedSessions.size() == 1);
        isTrue(transformedSessions.get("red").size() == 2);
    }

}
