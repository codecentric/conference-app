package org.ale.thot.web.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ale.thot.dao.CommentDao;
import org.ale.thot.dao.SessionDao;
import org.ale.thot.domain.Comment;
import org.ale.thot.domain.Session;
import org.ale.thot.model.CommentFormData;
import org.ale.thot.model.Html;
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
@RequestMapping("/addComment")
public class AddCommentsController {

	private static final String THOT_USERNAME = "THOT_username";
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	public AddCommentsController() {
		super();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		
		String sessionId = request.getParameter("sessionId");
		Session session = null;
		session = sessionDao.getSessionById(sessionId);

		CommentFormData commentFormData = new CommentFormData();
		if ( httpSession.getAttribute(THOT_USERNAME) != null ) {
			commentFormData.setAuthor((String) httpSession.getAttribute(THOT_USERNAME));
		}

		List<Integer> ratingList = Arrays.asList(1,2,3,4,5);
        modelMap.put("ratingList", ratingList);
        modelMap.put("commentFormData", commentFormData);
        modelMap.put("sessionTitle", session.getTitle());
	}
   
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(
			final HttpServletRequest request, 
			ModelMap modelMap,
			final @ModelAttribute("commentFormData") CommentFormData cmd, 
			BindingResult result) {
		
		String author = cmd.getAuthor();
		request.getSession().setAttribute(THOT_USERNAME, author);
		
		Comment comment = new Comment(new Date(), Html.escapeHtml(author), Html.escapeHtml(cmd.getText()),  Long.valueOf(cmd.getSessionId()), cmd.getRating()  );
		commentDao.saveComment(comment);
		return new ModelAndView(new RedirectView("comments"){{
			this.getAttributesMap().put("sessionId", cmd.getSessionId());
			this.getAttributesMap().put("title", request.getParameter("title"));
		}});
	}
	
}
