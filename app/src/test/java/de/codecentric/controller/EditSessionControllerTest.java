package de.codecentric.controller;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.codecentric.controller.EditSessionController;
import de.codecentric.dao.SessionDao;

public class EditSessionControllerTest {

    @Mock
    private SessionDao sessionDao;

    private EditSessionController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new EditSessionController(sessionDao, new StaticTimeslotDao());
    }

    @Test
    public void shouldGetTimeslotListFromDay() {
        Map<String, String> timeslots = controller.getTimeslotForDay("Wed");
        assertEquals(3, timeslots.size());
    }

}
