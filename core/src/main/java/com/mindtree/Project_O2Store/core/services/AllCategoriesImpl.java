package com.mindtree.Project_O2Store.core.services;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.mindtree.Project_O2Store.core.dao.AllCategoriesDao;
import com.mindtree.Project_O2Store.core.entity.Product;




@Component(service = AllCategories.class, immediate = true)
public class AllCategoriesImpl implements AllCategories{

	List<Product> allPlants = new ArrayList<>();
	List<Product> medicinalPlants = new ArrayList<>();
	List<Product> floweringPlants = new ArrayList<>();
	List<Product> foilagePlants = new ArrayList<>();
	List<Product> planters = new ArrayList<>();
	List<Product> fertilizers = new ArrayList<>();
	List<Product> accesories = new ArrayList<>();
	List<Product> materials = new ArrayList<>();
	List<Product> seeds = new ArrayList<>();
	
	@Activate
	@Modified
	public void activate() {
		allPlants = new AllCategoriesDao().fetchAllPlantsData(); 
		medicinalPlants = new AllCategoriesDao().fetchMedicinalPlantsData();
		floweringPlants = new AllCategoriesDao().fetchFlowerPlantsData();
		foilagePlants = new AllCategoriesDao().fetchFoilagePlantsData();
		planters = new AllCategoriesDao().fetchPlantersData();
		fertilizers = new AllCategoriesDao().fetchFertilizerData();
		accesories = new AllCategoriesDao().fetchAccessoriesData();
		materials = new AllCategoriesDao().fetchMaterialsData();
		seeds = new AllCategoriesDao().fetchSeedsData();
	}

	@Override
	public List<Product> readAllPlantsData() {
		// TODO Auto-generated method stub
		return allPlants;
	}

	@Override
	public List<Product> readMedicinalData() {
		// TODO Auto-generated method stub
		return medicinalPlants;
	}

	@Override
	public List<Product> readFloweringData() {
		// TODO Auto-generated method stub
		return floweringPlants;
	}

	@Override
	public List<Product> readFoilageData() {
		// TODO Auto-generated method stub
		return foilagePlants;
	}

	@Override
	public List<Product> readPlantersData() {
		// TODO Auto-generated method stub
		return planters;
	}

	@Override
	public List<Product> readFertilizerData() {
		// TODO Auto-generated method stub
		return fertilizers;
	}

	@Override
	public List<Product> readAccessoriesData() {
		// TODO Auto-generated method stub
		return accesories;
	}

	@Override
	public List<Product> readMaterialsData() {
		// TODO Auto-generated method stub
		return materials;
	}

	@Override
	public List<Product> readSeedsData() {
		// TODO Auto-generated method stub
		return seeds;
	}
}
