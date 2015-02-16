package org.cc.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 4660972772634343837L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getSession().invalidate();
	response.sendRedirect(request.getContextPath() + "/");
    }
}
