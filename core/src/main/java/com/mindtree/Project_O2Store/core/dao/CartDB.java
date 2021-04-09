package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.Project_O2Store.core.entity.Cart;



public class CartDB {
	
	   public boolean insertData(List<Cart> carts,String custId) {
	       Connection connection;
	       Statement statement;
	       Statement stmt1;
	       Statement stmt2;
	       ResultSet resultset;
	       List<String> cartids = new ArrayList<String>();
	       PreparedStatement pscustomer;
	       PreparedStatement psdelete;
	       PreparedStatement psinsert;
	       PreparedStatement psselect;
	       //String quantityUpdate = "UPDATE cart " + "SET quantity = ? " + "WHERE cart_id = ?";
	       //String priceUpdate = "UPDATE cart " + "SET price = ? " + "WHERE cart_id = ?";
	       String sqlInsert = "Insert into cart values(?,?,?,?,?)";
	       String sqlInsertCustomer = "Insert into cart_customer values(?,?)";
	       String sqldelete = "delete  from cart using cart  inner join cart_customer on cart.cart_id = cart_customer.cart_id where cart_customer.customer_id=?";
	       String sqlselect = "select * from cart inner join cart_customer on cart.cart_id = cart_customer.cart_id where customer_id = ?";
	       int quantityInsert=0,priceInsert=0,cartInsert=0;
	       connection = DBUtil.getConnection();
	       try {
	           statement = connection.createStatement();
	           stmt1 = connection.createStatement();
	           psselect=connection.prepareStatement(sqlselect);
	           psselect.setString(1, custId);
	           
	           
	           resultset = psselect.executeQuery();
	           
	           while(resultset.next())
	           {
	               cartids.add(resultset.getString(1));
	               System.out.println(cartids.size());
	           }
	           if(cartids.size()!=0)
	           {
	        	   psdelete = connection.prepareStatement(sqldelete);
	        	   psdelete.setString(1, custId);
	        	   psdelete.execute();
	        	   
	              // statement.executeUpdate(sqldelete);
	           }
	           for(Cart cart:carts)
	           {
	               String cart_id = String.valueOf(cart.getId())+custId;
	               psinsert=connection.prepareStatement(sqlInsert);
	               psinsert.setString(1, cart_id);
	               psinsert.setInt(2, cart.getId());
	               psinsert.setString(3, cart.getName());
	               psinsert.setInt(4, cart.getCount());
	               psinsert.setInt(5, cart.getPrice());
	               cartInsert=psinsert.executeUpdate();
	               pscustomer = connection.prepareStatement(sqlInsertCustomer);
	               String cart_id2 = String.valueOf(cart.getId())+custId;
	               pscustomer.setString(1,cart_id2);
	               pscustomer.setString(2, custId);
	               pscustomer.execute();
	               
	           }
	           
	       } catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
	       if(cartInsert!=0)
	       {
	           return true;
	       }
	       else {
	           return false;
	       }
	   }

	   public boolean deleteData(int id, String custId) {
		   int result = 0;
		   String cartId = id+custId;
		   String query1 = "delete  from cart_customer where cart_id = ?";
		   String query2 = "delete from cart where cart_id = ?";
		   Connection connection;
	       PreparedStatement statement1,statement2;
	       Statement stmt1;
	       ResultSet resultset;
	       connection = DBUtil.getConnection();
	       try {
	    	   statement1 = connection.prepareStatement(query1);
	    	   statement1.setString(1, cartId);
	    	   result = statement1.executeUpdate();
	    	   statement2 = connection.prepareStatement(query2);
	    	   statement2.setString(1, cartId);
	    	   result = statement2.executeUpdate();
	           
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	       if(result != 0) {
	    	   return true;
	       }
	       else
	    	   return false;
	   }
	   
	   public boolean updateData(int id,int count,String custId) {
		   int result = 0;
		   String cartId = id+custId;
		   String query1 = "UPDATE cart " + "SET quantity = ? " + "WHERE cart_id = ?";
		  // String query = "UPDATE cart INNER JOIN cart_customer ON cart.cart_id = cart_customer.cart_id "+"SET cart.quantity = ?" + "WHERE customer_id=?";
		   Connection connection;
	       PreparedStatement statement;
	       Statement stmt1;
	       ResultSet resultset;
	       connection = DBUtil.getConnection();
	       try {
	    	   statement = connection.prepareStatement(query1);
	    	   statement.setInt(1, count);
	    	   statement.setString(2, cartId );
	    	   result = statement.executeUpdate();
	    	   System.out.println(result);
	           
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	       if(result != 0) {
	    	   return true;
	       }
	       else
	    	   return false;
	   }
	   
	   public boolean removeAllData(String custId) {
		   int result = 0;
		   String query1 = "delete  from cart using cart  inner join cart_customer on cart.cart_id = cart_customer.cart_id where cart_customer.customer_id=?";
		   Connection connection;
	       PreparedStatement statement;
	       Statement stmt1;
	       ResultSet resultset;
	       connection = DBUtil.getConnection();
	       try {
	    	   statement = connection.prepareStatement(query1);
	    	   statement.setString(1, custId);
	    	   result = statement.executeUpdate();
	           
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	       if(result != 0) {
	    	   return true;
	       }
	       else
	    	   return false;
	   }
	   public List<Cart> fetchData(String custId){
		   List<Cart> carts = new ArrayList<>();
		   String query = "select cart.plant_id,cart.plant_display_name,cart.price,cart.quantity from cart inner join cart_customer on cart.cart_id = cart_customer.cart_id where customer_id = ?";
		   Connection connection;
		   PreparedStatement statement;
		   ResultSet resultset;
		   connection = DBUtil.getConnection();
		   try {
			statement = connection.prepareStatement(query);
			statement.setString(1, custId);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				Cart cart = new Cart();
				cart.setId(resultset.getInt(1));
				cart.setName(resultset.getString(2));
				cart.setPrice(resultset.getInt(3));
				cart.setCount(resultset.getInt(4));
				carts.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return carts;
	   }
	}
