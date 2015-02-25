package de.codecentric.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import de.codecentric.dao.CommentDao;
import de.codecentric.dao.LinkDao;
import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Comment;
import de.codecentric.domain.Link;
import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, SessionDao.class, CommentDao.class, LinkDao.class })
@WebAppConfiguration
public class CommentsControllerTest {

    @InjectMocks
    CommentsController controller;

    @Mock
    CommentDao commentDao;

    @Mock
    SessionDao sessionDao;

    @Mock
    LinkDao linkDao;

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
        Long sessionIdLong = Long.valueOf(sessionId);
        String location = "location";
        Session session = new Session("date", "startTime", location, title, "author", "description");
        session.setType(SessionType.session);
        Comment comment = new Comment(new Date(), "author", "text", sessionIdLong);
        List<Comment> comments = Arrays.asList(comment);
        Link link = new Link(new Date(), "comment", "http://testlink", sessionIdLong);
        List<Link> links = Arrays.asList(link);
        when(sessionDao.getSessionById(sessionId)).thenReturn(session);
        when(commentDao.getCommentsBySessionId(sessionIdLong)).thenReturn(comments);
        when(linkDao.getLinksBySessionId(sessionIdLong)).thenReturn(links);

        mockMvc.perform(get("/comments").param("sessionId", sessionId)).andExpect(status().isOk()).andExpect(model().attributeExists("comments")).andExpect(model().attribute("session", session))
                        .andExpect(model().attribute("location", containsString(location))).andExpect(view().name("comments"));
    }

    @Test
    public void testExceptionSetupForm() throws Exception {
        mockMvc.perform(get("/comments")).andExpect(status().isOk()).andExpect(model().attribute("comments", containsString("")))
                        .andExpect(model().attribute("sessionTitle", containsString("Nice try :)"))).andExpect(model().attributeExists("sessionDescription")).andExpect(view().name("comments"));
    }

}