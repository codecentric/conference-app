package org.ale.thot.web.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.dao.SpeakerDao;
import org.ale.thot.domain.Speaker;
import org.ale.thot.model.SpeakerFormData;
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
@RequestMapping("/speaker")
public class SpeakerController {

	private static final Boolean USE_MAIL = new Boolean(true);
	private static final String MAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	@Autowired
	private SpeakerDao speakerDao;

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		String stringId = request.getParameter("id");
		SpeakerFormData speakerFormData = new SpeakerFormData();
		if (stringId != null) {
			Long id = new Long(stringId);
			Speaker speaker = speakerDao.findById(id);
			speakerFormData = new SpeakerFormData(speaker);
		}
		setUseMailToggle(modelMap);
		modelMap.put("speakerFormData", speakerFormData);
	}

	static void setUseMailToggle(ModelMap modelMap) {
		modelMap.put("useMail", USE_MAIL);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(final HttpServletRequest request,
			ModelMap modelMap,
			final @ModelAttribute("speakerFormData") SpeakerFormData smd,
			BindingResult result) {

		Speaker speaker = smd.toSpeaker();
		String mail = speaker.getMail();
		if (!mailIsValid(mail)) {
			setUseMailToggle(modelMap);
			result.rejectValue("mail", "invalid.mail.format");
			return new ModelAndView();
		}
		speakerDao.createOrUpdate(speaker);
		return new ModelAndView(new RedirectView("speakers"));
	}

	private boolean mailIsValid(String mail) {
		Pattern pattern = Pattern.compile(MAIL_PATTERN,
				Pattern.CASE_INSENSITIVE);
		return mail == null || mail.equals("")
				|| pattern.matcher(mail).matches();
	}

}
