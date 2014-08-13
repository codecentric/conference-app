package org.ale.app;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class SigninServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -549123139625168044L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("EHeivZEAxPozmryXO5sH9A")
		.setOAuthConsumerSecret("u0pMp7NQjYJwPgZANwa2CFxCyliLAzqkfsr8dBs6oQ");
		
//		.setOAuthAccessToken("229629481-gdXZtyvxyMUWZe1l3qtZLit2RqYO8unxJ0j9cOmV")
//		.setOAuthAccessTokenSecret("xoOxfvr4xN4j7O3b4gVywkoYElv0SspIZlscreX4dQ");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		request.getSession().setAttribute("twitter", twitter);
		try {
			StringBuffer callbackURL = request.getRequestURL();
			int index = callbackURL.lastIndexOf("/");
			callbackURL.replace(index, callbackURL.length(), "").append(
					"/callback");

			RequestToken requestToken = twitter
					.getOAuthRequestToken(callbackURL.toString());
			request.getSession().setAttribute("requestToken", requestToken);
			response.sendRedirect(requestToken.getAuthenticationURL());

		} catch (TwitterException e) {
			throw new ServletException(e);
		}
	}
}
