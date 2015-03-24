package de.codecentric.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;
import java.util.Collections;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, SessionDao.class })
@WebAppConfiguration
public class SearchSessionsControllerTest {

    @InjectMocks
    SearchSessionsController controller;

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
        mockMvc.perform(get("/searchSessions")).andExpect(status().isOk()).andExpect(model().attributeExists("searchFormData")).andExpect(model().attributeExists("sessionsList"))
                        .andExpect(model().attribute("sessionsList", is(empty()))).andExpect(view().name("searchSessions"));
    }

    @Test
    public void testSearchSessionByAuthor() throws Exception {
        String title = "title";
        String author = "author";
        Session session = new Session("date", "startTime", "location", title, author, "description");
       // Session session2 = new Session("date", "startTime", "location", title, author, "description");
        List<Session> sessions = Arrays.asList(session);

        when(sessionDao.getAllSessionsByAuthorOrTitleOrDescription(author)).thenReturn(sessions);
        when(newsDao.getAllNews()).thenReturn(Collections.<News>emptyList());

        mockMvc.perform(post("/searchSessions").param("name", author)).andExpect(status().isOk()).andExpect(model().attributeExists("sessionsList"))
                        .andExpect(model().attribute("sessionsList", hasSize(1))).andExpect(view().name(containsString("searchSessions")));
    }

    @Test
    public void testSearchSessionWithInMemoryDBShouldReturnEmptyList() throws Exception {
        mockMvc.perform(post("/searchSessions").param("name", "author")).andExpect(status().isOk()).andExpect(model().attributeExists("sessionsList"))
                        .andExpect(model().attribute("sessionsList", hasSize(0))).andExpect(view().name(containsString("searchSessions")));
    }

}