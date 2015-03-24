package de.codecentric.controller;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import de.codecentric.dao.NewsDao;
import de.codecentric.domain.News;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import de.codecentric.Application;
import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, SessionDao.class })
@WebAppConfiguration
public class CurrentSessionsControllerTest {

    @InjectMocks
    CurrentSessionsController controller;

    @Mock
    SessionDao sessionDao;

    @Mock
    NewsDao newsDao;

    @Mock
    View mockView;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
    }

    @Test
    public void testSetupForm() throws Exception {
        mockMvc.perform(get("/currentSessions")).andExpect(status().isOk()).andExpect(model().attribute("currentSessions", is(empty()))).andExpect(model().attributeExists("sessionDays"))
                        .andExpect(model().attributeExists("sessionMap")).andExpect(view().name("currentSessions"));
    }

    @Test
    public void testSetupFormWithCurrentSession() throws Exception {
        String title = "title";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        String today = dateFormatter.format(new Date());
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        String startTime = timeFormatter.format(new Date());
        Session session = new Session(today, startTime, "location", title, "author", "description");
        List<Session> sessions = Arrays.asList(session);
        when(sessionDao.getAllSessionsByDateAndType(today, SessionType.openspace, SessionType.session)).thenReturn(sessions);
        when(sessionDao.getAllSessions()).thenReturn(sessions);
        when(newsDao.getAllNews()).thenReturn(Collections.<News>emptyList());

        mockMvc.perform(get("/currentSessions")).andExpect(status().isOk()).andExpect(model().attribute("currentSessions", hasSize(1))).andExpect(model().attributeExists("sessionDays"))
                        .andExpect(model().attributeExists("sessionMap")).andExpect(view().name("currentSessions"));
    }

}