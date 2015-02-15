package org.ale.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

public class CallbackServlet extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID = -4658233123268350598L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
	RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
	String verifier = request.getParameter("oauth_verifier");
	try {
	    twitter.getOAuthAccessToken(requestToken, verifier);
	    request.getSession().removeAttribute("requestToken");
	} catch (TwitterException e) {
	    throw new ServletException(e);
	}
	response.sendRedirect(request.getContextPath() + "/");
    }
}