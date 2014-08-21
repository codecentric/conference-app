package org.ale.thot.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.dao.SessionDao;
import org.ale.thot.dao.TimeslotDao;
import org.ale.thot.domain.Session;
import org.ale.thot.domain.Timeslot;
import org.ale.thot.model.Html;
import org.ale.thot.model.OpenSpaceFormData;
import org.ale.thot.web.validate.OpenSpaceValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/editSession")
public class EditSessionController {

	private static final Logger LOGGER = Logger.getLogger(EditSessionController.class);
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private TimeslotDao timeslotDao;

	public EditSessionController() {
		super();
	}

	public EditSessionController(SessionDao sessionDao, TimeslotDao timeslotDao) {
		this();
		this.sessionDao = sessionDao;
		this.timeslotDao = timeslotDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {

		modelMap.put("sessionDataFormData", new OpenSpaceFormData());
		modelMap.put("timeslots", timeslotDao.getTimeslots("Fri"));
		modelMap.put("days", timeslotDao.getConferenceDays());
		
		String sessionId = request.getParameter("sessionId");

		if (sessionId != null) {
			try {
				Session session = sessionDao.getSessionById(sessionId);
				String descriptionWithoutBrTags = Html.brTagsToLineBreaks(session
						.getDescription());
				session.setDescription(descriptionWithoutBrTags);
				modelMap.put("session", session);
				modelMap.put("sessionDataFormData", new OpenSpaceFormData(session));
				modelMap.put("sessionId", sessionId);
			} catch (Exception e) {
				LOGGER.error("To change body of catch statement use File | Settings | File Templates.", e);
			}
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(HttpServletRequest request,
			ModelMap modelMap,
			@ModelAttribute("sessionDataFormData") OpenSpaceFormData cmd,
			BindingResult result) {

		modelMap.put("sessionDataFormData", cmd);

		// do validation
		OpenSpaceValidator.validate(cmd, result);
		if (result.hasErrors()) {
			return new ModelAndView("editSession");
		}

		String sessionId = request.getParameter("sessionId");
		if (sessionId != null) {
			try {
				Session session = sessionDao.getSessionById(sessionId);
				session.setAuthor(Html.escapeHtml(cmd.getSpeaker()));
				session.setTitle(Html.escapeHtml(cmd.getTitle()));
				session.setDescription(Html.lineBreaksToBrTags(Html
						.escapeHtml(cmd.getDescription())));
				// session.setSlot(cmd.getStart());
				// session.setLocation(cmd.getLocation());
				sessionDao.saveSession(session);

				return new ModelAndView("redirect:allSessions");
			} catch (Exception e) {
				// do nothing!
			}
		}

		// save the data
		Session session = new Session(cmd.getDate(), cmd.getStart(),
				cmd.getLocation(), cmd.getTitle(), cmd.getSpeaker(),
				cmd.getDescription());
		sessionDao.saveSession(session);

		return new ModelAndView("redirect:allSessions");
	}

	@RequestMapping(value = "/timeslotsPerDay", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, String> getTimeslotForDay(@RequestParam("day") String day) {

		List<Timeslot> timeslots = timeslotDao.getTimeslots(day);
		Map<String, String> timeslotsProjected = new HashMap<String, String>();

		for (Timeslot timeslot : timeslots) {
			timeslotsProjected.put(timeslot.getStart(), timeslot.toString());
		}

		return timeslotsProjected;
	}

}
