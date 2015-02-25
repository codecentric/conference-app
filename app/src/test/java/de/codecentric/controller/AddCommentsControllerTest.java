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
import de.codecentric.dao.CommentDao;
import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Comment;
import de.codecentric.domain.Session;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, SessionDao.class, CommentDao.class })
@WebAppConfiguration
public class AddCommentsControllerTest {

    @InjectMocks
    AddCommentsController controller;

    @Mock
    CommentDao commentDao;

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

        mockMvc.perform(get("/addComment").param("sessionId", sessionId)).andExpect(status().isOk()).andExpect(model().attributeExists("commentFormData"))
                        .andExpect(model().attribute("sessionTitle", containsString(title))).andExpect(view().name("addComment"));
    }

    @Test
    public void testPostNewFeedback() throws Exception {
        mockMvc.perform(post("/addComment").param("sessionId", "42").param("text", "text").param("author", "author").param("sessionTitle", "sessionTitle")).andExpect(status().is3xxRedirection());

        verify(commentDao, times(1)).saveComment(any(Comment.class));
    }

}
