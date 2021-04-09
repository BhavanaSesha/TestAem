package com.mindtree.Project_O2Store.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.Project_O2Store.core.entity.Product;
import com.mindtree.Project_O2Store.core.services.AllCategories;



@Model(adaptables = Resource.class)
public class AllCategoriesModel {

	@OSGiService
	private AllCategories allCategories;
	
	List<Product> allPlants;
	List<Product> medicinalPlants;
	List<Product> floweringPlants;
	List<Product> foilagePlants;
	List<Product> planters;
	List<Product> fertilizers;
	List<Product> accesories;
	List<Product> materials;
	List<Product> seeds;
	
	@PostConstruct
	protected void init() {
		allPlants = allCategories.readAllPlantsData();
		medicinalPlants = allCategories.readMedicinalData();
		floweringPlants = allCategories.readFloweringData();
		foilagePlants = allCategories.readFoilageData();
		planters=allCategories.readPlantersData();
		fertilizers=allCategories.readFertilizerData();
		accesories=allCategories.readAccessoriesData();
		materials=allCategories.readMaterialsData();
		seeds=allCategories.readSeedsData();

	}

	public List<Product> getAllPlants() {
		return allPlants;
	}

	public List<Product> getMedicinalPlants() {
		return medicinalPlants;
	}

	public List<Product> getFloweringPlants() {
		return floweringPlants;
	}

	public List<Product> getFoilagePlants() {
		return foilagePlants;
	}

	public List<Product> getPlanters() {
		return planters;
	}

	public List<Product> getFertilizers() {
		return fertilizers;
	}

	public List<Product> getAccesories() {
		return accesories;
	}

	public List<Product> getMaterials() {
		return materials;
	}

	public List<Product> getSeeds() {
		return seeds;
	}
	
	
}
