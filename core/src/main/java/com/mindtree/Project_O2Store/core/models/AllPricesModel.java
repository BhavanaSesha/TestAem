package com.mindtree.Project_O2Store.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.Project_O2Store.core.entity.Product;
import com.mindtree.Project_O2Store.core.services.AllPrices;



@Model(adaptables = Resource.class)
public class AllPricesModel {
	
	@OSGiService
	private AllPrices allPrices;
	
	List<Product> range1Plants;
	List<Product> range2Plants;
	List<Product> range3Plants;
	List<Product> medAndRange1;
	List<Product> medAndRange2;
	List<Product> medAndRange3;
	List<Product> flowAndRange1;
	List<Product> flowAndRange2;
	List<Product> flowAndRange3;
	List<Product> foilAndRange1;
	List<Product> foilAndRange2;
	List<Product> foilAndRange3;
	
	@PostConstruct
	protected void init() {
		range1Plants= allPrices.readRange1Data();
		range2Plants= allPrices.readRange2Data();
		range3Plants= allPrices.readRange3Data();
		medAndRange1= allPrices.readMedAndRange1();
		medAndRange2= allPrices.readMedAndRange2();
		medAndRange3= allPrices.readMedAndRange3();
		flowAndRange1= allPrices.readFlowAndRange1();
		flowAndRange2= allPrices.readFlowAndRange2();
		flowAndRange3= allPrices.readFlowAndRange3();
		foilAndRange1= allPrices.readFoilAndRange1();
		foilAndRange2= allPrices.readFoilAndRange2();
		foilAndRange3= allPrices.readFoilAndRange3();
	}

	public List<Product> getRange1Plants() {
		return range1Plants;
	}

	public List<Product> getRange2Plants() {
		return range2Plants;
	}

	public List<Product> getRange3Plants() {
		return range3Plants;
	}

	public List<Product> getMedAndRange1() {
		return medAndRange1;
	}

	public List<Product> getMedAndRange2() {
		return medAndRange2;
	}

	public List<Product> getMedAndRange3() {
		return medAndRange3;
	}

	public List<Product> getFlowAndRange1() {
		return flowAndRange1;
	}

	public List<Product> getFlowAndRange2() {
		return flowAndRange2;
	}

	public List<Product> getFlowAndRange3() {
		return flowAndRange3;
	}

	public List<Product> getFoilAndRange1() {
		return foilAndRange1;
	}

	public List<Product> getFoilAndRange2() {
		return foilAndRange2;
	}

	public List<Product> getFoilAndRange3() {
		return foilAndRange3;
	}
	
	
	

}
