package org.ale.thot.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.ale.thot.dao.SessionDao;
import org.ale.thot.domain.Session;
import org.ale.thot.model.SearchFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/searchSessions")
public class SearchSessionsController {
	
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
	public ModelAndView searchSessions(
			ModelMap modelMap,
			@ModelAttribute("searchFormData") SearchFormData formData) {
		
		modelMap.put("searchFormData", formData);
		
		List<Session> sessions = loadSessionsForAuthorName(formData.getName());
		
		modelMap.put("sessionsList", sessions);
		
		ModelAndView modelAndView = new ModelAndView("searchSessions");
		modelAndView.addObject("sessionsList", sessions);
		
		return modelAndView;
	}
   
	private List<Session> loadSessionsForAuthorName(String name) {
	  List<Session> sessions = sessionDao.getAllSessionsByAuthor(name);
	  for(Session session:sessions){
		  // TODO remove after DB cleanup
		  if (session.getType() == null){
			  session.setType("Open Space");
		  }
	  } 
		return sessions;
	}
}
