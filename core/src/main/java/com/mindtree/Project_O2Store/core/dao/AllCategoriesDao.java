package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.Project_O2Store.core.entity.Product;



public class AllCategoriesDao {
/*
	public static void main(String[] args) {
		List<Product> plants = new ArrayList<>();
		plants = new AllCategoriesDao().fetchFertilizerData();
		plants.forEach(System.out::println);
	}
*/
	public List<Product> fetchAllPlantsData()
	{
		List<Product> allPlants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql="select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id where categories.category_name in ('medicine','foilage','flowers')";
			resultset = statement.executeQuery(sql);
			while(resultset.next())
			{
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				allPlants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allPlants;
		
	}

	public List<Product> fetchMedicinalPlantsData() {
		List<Product> medicinalPlants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where categories.category_name='medicine';";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				medicinalPlants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return medicinalPlants;

	}

	public List<Product> fetchFlowerPlantsData() {
		List<Product> flowerPlants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where categories.category_name='flowers';";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				flowerPlants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flowerPlants;

	}

	public List<Product> fetchFoilagePlantsData() {
		List<Product> foilagePlants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id \r\n"
					+ "where categories.category_name='foilage';";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				foilagePlants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return foilagePlants;

	}

	public List<Product> fetchPlantersData() {
		List<Product> Planters = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql ="select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id and categories.category_name in ('accessories','materials')";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Planters.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Planters;

	}
	public List<Product> fetchAccessoriesData() {
		List<Product> accessories = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql ="select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id and categories.category_name ='accessories';";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product acc = new Product();
				acc.setProductName(resultset.getString(1));
				acc.setProductDisplayName(resultset.getString(2));
				acc.setPrice(resultset.getInt(3));
				acc.setProductId(resultset.getInt(4));
				acc.setPdpLink(resultset.getString(5));
				accessories.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accessories;

	}
	public List<Product> fetchMaterialsData() {
		List<Product> materials = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql ="select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id and categories.category_name ='materials';";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product mat = new Product();
				mat.setProductName(resultset.getString(1));
				mat.setProductDisplayName(resultset.getString(2));
				mat.setPrice(resultset.getInt(3));
				mat.setProductId(resultset.getInt(4));
				mat.setPdpLink(resultset.getString(5));
				materials .add(mat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return materials;

	}
	public List<Product> fetchSeedsData() {
		List<Product> seeds = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql ="select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id and categories.category_name = 'seeds'";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product seed = new Product();
				seed.setProductName(resultset.getString(1));
				seed.setProductDisplayName(resultset.getString(2));
				seed.setPrice(resultset.getInt(3));
				seed.setProductId(resultset.getInt(4));
				seed.setPdpLink(resultset.getString(5));
				seeds.add(seed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seeds;
	}
	
	public List<Product> fetchFertilizerData() {
		List<Product> fertilizer = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql ="select plant_name,plant_display_name,price,plants.plant_id,pdplink from plants inner join plant_categories on plants.plant_id = plant_categories.plant_id inner join categories on plant_categories.category_id = categories.category_id and categories.category_name = 'soil'";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				fertilizer.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fertilizer;
	}
}
