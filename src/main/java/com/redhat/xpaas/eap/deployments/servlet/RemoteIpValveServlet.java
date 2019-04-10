package com.redhat.xpaas.eap.deployments.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remoteipvalve")
public class RemoteIpValveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoteIpValveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String remoteHost = request.getRemoteHost();
		response.getOutputStream().println(remoteHost);
	}

}
