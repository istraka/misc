package com.redhat.xpaas.eap.deployments.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Tomas Borcin | tborcin@redhat.com | created: 4/13/16.
 */
@WebServlet("/ping")
public class PingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer writer = response.getWriter();
		writer.write("pong");
	}
}
