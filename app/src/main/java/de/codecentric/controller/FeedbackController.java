package de.codecentric.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.codecentric.dao.FeedbackDao;
import de.codecentric.domain.Feedback;
import de.codecentric.model.FeedbackFormData;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackDao feedbackDao;

    @ModelAttribute("feedbackFormData")
    public FeedbackFormData getFeedbackFormData() {
        return new FeedbackFormData();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getFeedback(Map<String, Object> modelMap) {
        modelMap.put("feedbackList", feedbackDao.getFeedbackList());
        return "feedback";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveFeedback(ModelMap modelMap, @ModelAttribute("feedbackFormData") FeedbackFormData formData) {

        modelMap.put("feedbackFormData", formData);

        Feedback feedback = new Feedback();
        feedback.setTimestamp(new Date());
        feedback.setUserName(formData.getName());
        feedback.setFeedbackComment(formData.getFeedbackContent());

        feedbackDao.save(feedback);

        return new ModelAndView("redirect:feedback");
    }
}
