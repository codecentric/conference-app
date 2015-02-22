package de.codecentric.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;
import de.codecentric.model.SearchFormData;

@Controller
@RequestMapping("/searchSessions")
public class SearchSessionsController {

    private Logger logger = LoggerFactory.getLogger(SearchSessionsController.class.getName());
    
    @Autowired
    private SessionDao sessionDao;

    @ModelAttribute("searchFormData")
    public SearchFormData getSearchFormData() {
	return new SearchFormData();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void setupForm(ModelMap modelMap) {
	modelMap.put("searchFormData", new SearchFormData());
	modelMap.put("sessionsList", new ArrayList<Session>());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView searchSessions(ModelMap modelMap, @ModelAttribute("searchFormData") SearchFormData formData) {
	logger.info("searchSessions by author " + formData.getName());

	List<Session> sessions = loadSessionsForAuthorName(formData.getName());
	modelMap.put("sessionsList", sessions);
	modelMap.put("searchFormData", formData);

	ModelAndView modelAndView = new ModelAndView("searchSessions");
	modelAndView.addObject("sessionsList", sessions);

	return modelAndView;
    }

    private List<Session> loadSessionsForAuthorName(String name) {
	List<Session> sessions = sessionDao.getAllSessionsByAuthor(name);
	for (Session session : sessions) {
	    // TODO remove after DB cleanup
	    if (session.getType() == null) {
		session.setType(SessionType.openspace);
	    }
	}
	return sessions;
    }
}
