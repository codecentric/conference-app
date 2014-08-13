package org.ale.thot.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.dao.LinkDao;
import org.ale.thot.dao.SessionDao;
import org.ale.thot.domain.Link;
import org.ale.thot.domain.Session;
import org.ale.thot.model.Html;
import org.ale.thot.model.LinkFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/addLink")
public class AddLinkController {

	@Autowired
	private LinkDao linkDao;

	@Autowired
	private SessionDao sessionDao;

	public AddLinkController() {
		super();
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		String sessionId = request.getParameter("sessionId");
		Session session = sessionDao.getSessionById(sessionId);

		LinkFormData linkFormData = new LinkFormData();

		modelMap.put("linkFormData", linkFormData);
		modelMap.put("sessionTitle", session.getTitle());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(final HttpServletRequest request,
			ModelMap modelMap,
			final @ModelAttribute("linkFormData") LinkFormData form,
			BindingResult result) {
		Link link = new Link(new Date(), Html.escapeHtml(form.getComment()),
				Html.escapeHtml(form.getUrl()), form.getSessionId());
		linkDao.saveLink(link);
		return new ModelAndView(new RedirectView("comments") {
			{
				this.getAttributesMap().put("sessionId", form.getSessionId());
				this.getAttributesMap().put("title",
						request.getParameter("title"));
			}
		});
	}

}
