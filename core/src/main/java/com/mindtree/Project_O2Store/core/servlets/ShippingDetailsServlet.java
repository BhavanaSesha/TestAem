package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.mindtree.Project_O2Store.core.dao.ShippingDetailsDao;
import com.mindtree.Project_O2Store.core.entity.ShippingDetails;


@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/ShippingDetails/ShippingDetailsServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class ShippingDetailsServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	private ShippingDetailsDao shippingDetailsDao;

	public void init() {
		shippingDetailsDao = new ShippingDetailsDao();
	}

	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalcode = request.getParameter("postalcode");

		ShippingDetails shippingDetails = new ShippingDetails();
		shippingDetails.setFullname(fullname);
		shippingDetails.setEmail(email);
		shippingDetails.setAddress(address);
		shippingDetails.setCity(city);
		shippingDetails.setState(state);
		shippingDetails.setPostalcode(postalcode);

		try {
			shippingDetailsDao.shipping(shippingDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}}}

