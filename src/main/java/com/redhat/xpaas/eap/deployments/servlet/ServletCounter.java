package com.redhat.xpaas.eap.deployments.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Simple Servlet-based session-scoped counter
 *
 * @author maschmid
 */
@SuppressWarnings("serial")
@WebServlet("/Counter")
public class ServletCounter extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");

		String servletId = (String) req.getServletContext().getAttribute("servletId");

		System.out.println("requestedSessionId: " + req.getRequestedSessionId() + ", queryString: " + req.getQueryString());

		HttpSession session = req.getSession();

		Long counter = (Long) session.getAttribute("counter");
		if (counter == null) {
			counter = 0L;
		}

		counter++;

		session.setAttribute("counter", counter);

		PrintWriter writer = resp.getWriter();
		writer.println(servletId + " " + counter);
		writer.close();
	}

}
