package de.codecentric.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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
import de.codecentric.dao.LinkDao;
import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Link;
import de.codecentric.domain.Session;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, SessionDao.class, LinkDao.class })
@WebAppConfiguration
public class AddLinkControllerTest {

    @InjectMocks
    AddLinkController controller;

    @Mock
    LinkDao linkDao;

    @Mock
    SessionDao sessionDao;

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
        String title = "title";
        String sessionId = "42";
        Session session = new Session("date", "startTime", "location", title, "author", "description");
        when(sessionDao.getSessionById(sessionId)).thenReturn(session);

        mockMvc.perform(get("/addLink").param("sessionId", sessionId)).andExpect(status().isOk()).andExpect(model().attributeExists("linkFormData"))
                        .andExpect(model().attribute("sessionTitle", containsString(title))).andExpect(view().name("addLink"));
    }

    @Test
    public void testPostNewFeedback() throws Exception {
        mockMvc.perform(post("/addLink").param("sessionId", "42").param("comment", "user comment").param("url", "author")).andExpect(status().is3xxRedirection());

        verify(linkDao, times(1)).saveLink(any(Link.class));
    }

}
