package de.codecentric.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;
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
import de.codecentric.dao.FeedbackDao;
import de.codecentric.domain.Feedback;
import de.codecentric.model.FeedbackFormData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, FeedbackDao.class })
@WebAppConfiguration
public class FeedbackControllerTest {

    @InjectMocks
    FeedbackController controller;

    @Mock
    FeedbackDao feedbackDao;

    @Mock
    View mockView;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
    }

    @Test
    public void testGetFeedbackList() throws Exception {
        List<Feedback> feedbackList = Arrays.asList(new Feedback());
        when(feedbackDao.getFeedbackList()).thenReturn(feedbackList);

        mockMvc.perform(get("/feedback")).andExpect(status().isOk()).andExpect(model().attribute("feedbackList", feedbackList)).andExpect(view().name("feedback"));
    }

    @Test
    public void testPostNewFeedback() throws Exception {
        FeedbackFormData formData = new FeedbackFormData();

        mockMvc.perform(post("/feedback").requestAttr("feedbackFormData", formData)).andExpect(status().isOk()).andExpect(model().attributeExists("feedbackFormData"))
                        .andExpect(view().name(containsString("feedback")));
    }

}
