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

import com.mindtree.Project_O2Store.core.dao.ForgetPasswordDao;
import com.mindtree.Project_O2Store.core.entity.ForgetPassword;



@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/ForgetPassword/ForgetPasswordServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class ForgetPasswordServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;
	
	private ForgetPasswordDao forgetPasswordDao;

	public void init() {
		forgetPasswordDao = new ForgetPasswordDao();
	}

	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");
		
		    String email = request.getParameter("email");
	        String newpassword = request.getParameter("newpassword");
	        ForgetPassword forget = new ForgetPassword();
	        PrintWriter out = response.getWriter();
	       
	        forget.setEmail(email);
	        forget.setNewpassword(newpassword);
	         
	        try {
	            if (forgetPasswordDao.forgetPassword(forget)) {
	            	 
	            	out.println("Successfully change"); 
	            } else {
	            	 
	            	out.println("Failed to change the password"); 
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	
}}

