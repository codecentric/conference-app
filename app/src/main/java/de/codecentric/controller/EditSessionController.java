package de.codecentric.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import de.codecentric.dao.SessionDao;
import de.codecentric.dao.TimeslotDao;
import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;
import de.codecentric.domain.Timeslot;
import de.codecentric.model.OpenSpaceFormData;
import de.codecentric.util.Html;

/**
 * Handles requests for the application home page.
 */
@Controller
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

    @RequestMapping(value = "/createSession", method = RequestMethod.GET)
    public ModelAndView createSession(ModelMap modelMap, HttpServletRequest request) {
        modelMap.put("timeslots", timeslotDao.getTimeslots("Fri"));
        modelMap.put("days", timeslotDao.getConferenceDays());

        OpenSpaceFormData data = new OpenSpaceFormData();
        data.setStart(request.getParameter("start"));
        data.setEnd(request.getParameter("end"));
        data.setLocation(request.getParameter("location"));
        data.setDate(request.getParameter("day"));
        modelMap.put("sessionDataFormData", data);
        modelMap.put("newSession", true);

        return new ModelAndView("editSession", modelMap);
    }

    @RequestMapping(value = "/editSession", method = RequestMethod.GET)
    public void setupForm(ModelMap modelMap, HttpServletRequest request) {

        modelMap.put("sessionDataFormData", new OpenSpaceFormData());
        modelMap.put("timeslots", timeslotDao.getTimeslots("Fri"));
        modelMap.put("days", timeslotDao.getConferenceDays());
        modelMap.put("newSession", false);

        String sessionId = request.getParameter("sessionId");

        if (sessionId != null) {
            try {
                Session session = sessionDao.getSessionById(sessionId);
                String descriptionWithoutBrTags = Html.brTagsToLineBreaks(session.getDescription());
                session.setDescription(descriptionWithoutBrTags);
                modelMap.put("session", session);
                modelMap.put("sessionDataFormData", new OpenSpaceFormData(session));
                modelMap.put("sessionId", sessionId);
            } catch (Exception e) {
                LOGGER.error("To change body of catch statement use File | Settings | File Templates.", e);
            }
        }

    }

    @RequestMapping(value = "/editSession", method = RequestMethod.POST)
    public ModelAndView processSubmit(HttpServletRequest request, ModelMap modelMap, @ModelAttribute("sessionDataFormData") OpenSpaceFormData formData, BindingResult result) {

        modelMap.put("sessionDataFormData", formData);

        if (result.hasErrors()) {
            System.out.println("Validation errors ocurred.");
            return new ModelAndView("editSession");
        }

        String sessionId = request.getParameter("sessionId");
        if (sessionId != null) {
            try {
                Session session = sessionDao.getSessionById(sessionId);
                session.setAuthor(Html.escapeHtml(formData.getSpeaker()));
                session.setTitle(Html.escapeHtml(formData.getTitle()));
                session.setDescription(Html.lineBreaksToBrTags(Html.escapeHtml(formData.getDescription())));
                sessionDao.saveSession(session);

                return new ModelAndView("redirect:allSessions");
            } catch (Exception e) {
                // do nothing!
            }
        } else {
            // save the data
            Session session = new Session(formData.getDate(), formData.getStart(), formData.getLocation(), formData.getTitle(), formData.getSpeaker(), formData.getDescription());
            session.setEnd(formData.getEnd());
            session.setType(SessionType.openspace);
            sessionDao.saveSession(session);
        }

        return new ModelAndView("redirect:allSessions");
    }

    @RequestMapping(value = "/timeslotsPerDay", method = RequestMethod.GET)
    public @ResponseBody Map<String, String> getTimeslotForDay(@RequestParam("day") String day) {

        List<Timeslot> timeslots = timeslotDao.getTimeslots(day);
        Map<String, String> timeslotsProjected = new HashMap<String, String>();

        for (Timeslot timeslot : timeslots) {
            timeslotsProjected.put(timeslot.getStart(), timeslot.toString());
        }

        return timeslotsProjected;
    }

}
