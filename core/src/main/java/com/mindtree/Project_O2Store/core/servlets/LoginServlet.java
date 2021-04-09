package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.mindtree.Project_O2Store.core.dao.LoginDao;
import com.mindtree.Project_O2Store.core.entity.Login;


@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Login/LoginServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class LoginServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDao logindao;

	public void init() {
		logindao = new LoginDao();
	}

	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");
		
		    String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        Login login = new Login();
	        PrintWriter out = response.getWriter();
	       
	        login.setEmail(email);
	        login.setPassword(password);
	         
	        try {
	            if (logindao.validate(login)) {
	            	 
	            	out.print("You Have Successfully Logged In"); 
	            } else {
	            	 
	            	out.print("Failed to login"); 
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	
}}
