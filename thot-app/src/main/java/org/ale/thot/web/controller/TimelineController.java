package org.ale.thot.web.controller;

import org.ale.thot.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/timeline")
public class TimelineController {

	@Autowired
	private CommentDao commentDao;
	
	public TimelineController() {
		super();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("recentComments", commentDao.getRecentComments());
	}
	
}
