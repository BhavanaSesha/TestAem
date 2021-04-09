package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.Project_O2Store.core.entity.Product;

public class AllPricesDao {
	/*
	  public static void main(String[] args) { List<Product> plants = new
	  ArrayList<>(); plants = new AllPricesDao().fetchMedicinalAndRange3PlantsData();
	  plants.forEach(System.out::println); }
*/
	public List<Product> fetchRange1PlantsData() {
		List<Product> Range1Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join\r\n"
					+ "categories on plant_categories.category_id = categories.category_id\r\n"
					+ " where  price between 300 and 700 \r\n"
					+ " and categories.category_name in ('medicine','foilage','flowers')\r\n" + "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Range1Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Range1Plants;

	}

	public List<Product> fetchRange2PlantsData() {
		List<Product> Range2Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "  select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join\r\n"
					+ "categories on plant_categories.category_id = categories.category_id\r\n"
					+ " where  price between 701 and 1100 \r\n"
					+ " and categories.category_name in ('medicine','foilage','flowers')\r\n" + "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Range2Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Range2Plants;

	}

	public List<Product> fetchRange3PlantsData() {
		List<Product> Range3Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join\r\n"
					+ "categories on plant_categories.category_id = categories.category_id\r\n"
					+ " where  price between 1101 and 1500 \r\n"
					+ " and categories.category_name in ('medicine','foilage','flowers')\r\n" + "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Range3Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Range3Plants;

	}

	public List<Product> fetchMedicinalAndRange1PlantsData() {
		List<Product> medicinalAndRange1Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 300 and 700\r\n" + "and categories.category_name in ('medicine')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				medicinalAndRange1Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return medicinalAndRange1Plants;

	}

	public List<Product> fetchMedicinalAndRange2PlantsData() {
		List<Product> medicinalAndRange2Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 701 and 1100\r\n" + "and categories.category_name in ('medicine')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				medicinalAndRange2Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return medicinalAndRange2Plants;

	}

	public List<Product> fetchMedicinalAndRange3PlantsData() {
		List<Product> medicinalAndRange3Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 1101 and 1500\r\n" + "and categories.category_name in ('medicine')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				medicinalAndRange3Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return medicinalAndRange3Plants;

	}

	public List<Product> fetchFoilageAndRange1PlantsData() {
		List<Product> foilageAndRange1Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 300 and 700\r\n" + "and categories.category_name in ('foilage')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				foilageAndRange1Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return foilageAndRange1Plants;

	}

	public List<Product> fetchFoilageAndRange2PlantsData() {
		List<Product> foilageAndRange2Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 701 and 1100\r\n" + "and categories.category_name in ('foilage')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				foilageAndRange2Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return foilageAndRange2Plants;

	}

	public List<Product> fetchFoilageAndRange3PlantsData() {
		List<Product> foilageAndRange3Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 1101 and 1500\r\n" + "and categories.category_name in ('foilage')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				foilageAndRange3Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return foilageAndRange3Plants;

	}

	public List<Product> fetchFlowerAndRange1PlantsData() {
		List<Product> flowerAndRange1Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 300 and 700\r\n" + "and categories.category_name in ('flowers')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				flowerAndRange1Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flowerAndRange1Plants;

	}

	public List<Product> fetchFlowerAndRange2PlantsData() {
		List<Product> flowerAndRange2Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 701 and 1100\r\n" + "and categories.category_name in ('flowers')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				flowerAndRange2Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flowerAndRange2Plants;

	}

	public List<Product> fetchFlowerAndRange3PlantsData() {
		List<Product> flowerAndRange3Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n"
					+ "plant_categories on plants.plant_id = plant_categories.plant_id inner join \r\n"
					+ "categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where  price between 1101 and 1500\r\n" + "and categories.category_name in ('flowers')\r\n"
					+ "order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				flowerAndRange3Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flowerAndRange3Plants;

	}
}
