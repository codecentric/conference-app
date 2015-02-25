package de.codecentric.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import de.codecentric.dao.CommentDao;
import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Comment;
import de.codecentric.domain.Session;
import de.codecentric.model.CommentFormData;
import de.codecentric.util.Html;

@Controller
@RequestMapping("/addComment")
public class AddCommentsController {

    private static final String USERNAME = "username";

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private SessionDao sessionDao;

    @RequestMapping(method = RequestMethod.GET)
    public void setupForm(ModelMap modelMap, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();

        String sessionId = request.getParameter("sessionId");
        Session session = sessionDao.getSessionById(sessionId);

        CommentFormData commentFormData = new CommentFormData();
        if (httpSession.getAttribute(USERNAME) != null) {
            commentFormData.setAuthor((String) httpSession.getAttribute(USERNAME));
        }

        modelMap.put("commentFormData", commentFormData);
        modelMap.put("sessionTitle", session.getTitle());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processSubmit(final HttpServletRequest request, ModelMap modelMap, final @ModelAttribute("commentFormData") CommentFormData cmd, BindingResult result) {

        String author = cmd.getAuthor();
        request.getSession().setAttribute(USERNAME, author);

        Comment comment = new Comment(new Date(), Html.escapeHtml(author), Html.escapeHtml(cmd.getText()), Long.valueOf(cmd.getSessionId()));
        commentDao.saveComment(comment);
        return new ModelAndView(new RedirectView("comments") {
            {
                this.getAttributesMap().put("sessionId", cmd.getSessionId());
            }
        });
    }

}
