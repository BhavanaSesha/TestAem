package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.Project_O2Store.core.dao.CartDB;
import com.mindtree.Project_O2Store.core.entity.Cart;



@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Cart/CartServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class CartServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	static CartDB dao = new CartDB();
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		/*
		 * int plantId = Integer.parseInt(request.getParameter("plantId")); String name
		 * = request.getParameter("plantname"); int price =
		 * Integer.parseInt(request.getParameter("plantprice")); int quantity =
		 * Integer.parseInt(request.getParameter("quantity"));
		 */

		String action = request.getParameter("action");
		String custId = request.getParameter("customerID");
		if (action.equals("insert")) {
		
			String json = request.getParameter("cartArray");
			PrintWriter out = response.getWriter();
			
			ObjectMapper mapper = new ObjectMapper();
			List<Cart> carts = new ArrayList<>();
			carts = mapper.readValue(json, new TypeReference<List<Cart>>() {
			});
			out.println(carts);

			
			boolean success = dao.insertData(carts,custId);
			if (success)
				out.println("Products added successfully");
			else
				out.println("already present");
		}
		else if(action.equals("removeItem")) {
			//String custId = request.getParameter("customerID");
			int id = Integer.parseInt(request.getParameter("plantId"));
			boolean success = dao.deleteData(id,custId);
			PrintWriter out = response.getWriter();
			if (success)
				out.println("Products removed successfully");
			else
				out.println("not removed");
		}
		else if(action.equals("updateQuantity")) {
			int id = Integer.parseInt(request.getParameter("plantId"));
			int count = Integer.parseInt(request.getParameter("quantity"));
			boolean success = dao.updateData(id,count,custId);
			PrintWriter out = response.getWriter();
			out.println("count");
			if (success)
				out.println("Quantity of products updated successfully");
			else
				out.println("Quantity not updates");
		}
		else if(action.equals("removeAllCart")) {
			boolean success = dao.removeAllData(custId);
			PrintWriter out = response.getWriter();
			if (success)
				out.println("products removed successfully");
			else
				out.println("Quantity not removed");
		}
		else if(action.equals("fetch"))
		{
			PrintWriter out = response.getWriter();
			List<Cart> cart = dao.fetchData(custId);
			ObjectMapper mapper = new ObjectMapper();
			String cartJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cart);
			out.println(cartJson);
		}
			
	}
}
