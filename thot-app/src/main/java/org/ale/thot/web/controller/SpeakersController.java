package org.ale.thot.web.controller;

import java.util.List;

import org.ale.thot.dao.SpeakerDao;
import org.ale.thot.domain.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/speakers")
public class SpeakersController {

	@Autowired
	private SpeakerDao sessionDao;

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		
		List<Speaker>speakers = sessionDao.getAllSpeakers();
		SpeakerController.setUseMailToggle(modelMap);
		modelMap.put("speakers", speakers);
	}
	
}
