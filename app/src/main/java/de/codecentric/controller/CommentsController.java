package de.codecentric.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.dao.CommentDao;
import de.codecentric.dao.LinkDao;
import de.codecentric.dao.SessionDao;
import de.codecentric.domain.Session;
import de.codecentric.util.TwitterLinkCreator;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    private static final String SESSION_TYPE_SESSION = "session";

    @Autowired
    private LinkDao linkDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private SessionDao sessionDao;

    @RequestMapping(method = RequestMethod.GET)
    public void setupForm(ModelMap modelMap, HttpServletRequest request) {
        String sessionId = request.getParameter("sessionId");
        try {
            long lSessionId = Long.valueOf(sessionId);
            Session session = sessionDao.getSessionById(sessionId);

            modelMap.put("sessionId", sessionId);
            modelMap.put("comments", commentDao.getCommentsBySessionId(lSessionId));
            modelMap.put("session", session);
            modelMap.put("links", linkDao.getLinksBySessionId(lSessionId));
            modelMap.put("sessionEditable", getSessionIsEditable(session.getType().getLabel()));

            String location = session.getLocation() != null ? session.getLocation() : "Unknown";
            String author = session.getAuthor() != null ? session.getAuthor() : "Unknown";
            modelMap.put("location", location);
            modelMap.put("sessionSpeaker", TwitterLinkCreator.process(author));

        } catch (Exception e) {
            modelMap.put("comments", "");
            modelMap.put("sessionTitle", "Nice try :)");
            modelMap.put("sessionDescription", "Do you think this is something a normal user would do?");
        }
    }

    private Boolean getSessionIsEditable(String type) {
        if (type != null && type.equalsIgnoreCase(SESSION_TYPE_SESSION)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
