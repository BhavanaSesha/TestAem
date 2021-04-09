package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.mindtree.Project_O2Store.core.dao.DebitCardDao;
import com.mindtree.Project_O2Store.core.entity.DebitCard;


@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/DebitCard/DebitCardServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class DebitCardServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	private DebitCardDao debitCardDao;

	public void init() {
		debitCardDao = new DebitCardDao();
	}

	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		String cardnumber = request.getParameter("cardnumber");
		String name = request.getParameter("name");
		String expiry = request.getParameter("expiry");
		String cvv = request.getParameter("cvv");

		DebitCard debitCard = new DebitCard();
		debitCard.setCardnumber(cardnumber);
		debitCard.setName(name);
		debitCard.setExpiry(expiry);
		debitCard.setCvv(cvv);

		try {
			debitCardDao.debitDetails(debitCard);
		} catch (Exception e) {
			e.printStackTrace();
		}}}
