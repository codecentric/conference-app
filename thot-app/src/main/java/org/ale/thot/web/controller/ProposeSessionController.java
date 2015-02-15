package org.ale.thot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.dao.LocationDao;
import org.ale.thot.dao.SessionDao;
import org.ale.thot.dao.TimeslotDao;
import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionType;
import org.ale.thot.model.OpenSpaceFormData;
import org.ale.thot.web.validate.OpenSpaceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/proposeNewSession")
public class ProposeSessionController {

    @Autowired
    private SessionDao sessionDao;
    @Autowired
    private TimeslotDao timeslotDao;
    @Autowired
    private LocationDao locationDao;

    public ProposeSessionController() {
	super();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setupForm(ModelMap modelMap, HttpServletRequest request) {

	String day = request.getParameter("day");
	OpenSpaceFormData data = new OpenSpaceFormData();
	data.setDate(day);

	modelMap.put("sessionDataFormData", data);
	modelMap.put("day", day);

	return new ModelAndView("proposeNewSession", modelMap);
    }

    @RequestMapping(value = "/proposeNewSession", method = RequestMethod.POST)
    public ModelAndView processSubmit(HttpServletRequest request, ModelMap modelMap, @ModelAttribute("sessionDataFormData") OpenSpaceFormData formData, BindingResult result) {

	modelMap.put("sessionDataFormData", formData);

	// do validation
	OpenSpaceValidator.nameValidator = new NameValidator();
	OpenSpaceValidator.validate(formData, result);

	if (result.hasErrors()) {
	    System.out.println("Validation errors ocurred.");
	    return new ModelAndView("proposeNewSession");
	}

	String start = formData.getStart();
	String end = formData.getEnd();
	Session session = new Session(formData.getDate(), start, formData.getLocation(), formData.getTitle(), formData.getSpeaker(), formData.getDescription());
	session.setEnd(end);
	session.setType(SessionType.openspaceanywhere);
	sessionDao.saveSession(session);

	return new ModelAndView("redirect:allSessions");
    }

}
