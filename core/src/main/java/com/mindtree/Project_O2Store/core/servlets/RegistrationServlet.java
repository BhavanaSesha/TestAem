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

import com.mindtree.Project_O2Store.core.dao.RegistrationDao;
import com.mindtree.Project_O2Store.core.entity.Registration;


@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Registration/RegistrationServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class RegistrationServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	private RegistrationDao registrationdao;

	public void init() {
		registrationdao = new RegistrationDao();
	}

	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String country = request.getParameter("country");

		Registration registration = new Registration();
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setEmail(email);
		registration.setPassword(password);
		registration.setCountry(country);

//		try {
//			registrationdao.register(registration);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		PrintWriter out = response.getWriter();
		try {
			boolean b = registrationdao.register(registration);
			if (b == false) {
				out.print("Email already exists");
			} else {
				out.print("Successfully Registered");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
}
