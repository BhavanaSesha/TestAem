package com.mindtree.Project_O2Store.core.services;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.mindtree.Project_O2Store.core.dao.AllPricesDao;
import com.mindtree.Project_O2Store.core.entity.Product;


@Component(service = AllPrices.class, immediate = true)
public class AllPricesImpl implements AllPrices{

	List<Product> range1Plants = new ArrayList<>();
	List<Product> range2Plants = new ArrayList<>();
	List<Product> range3Plants = new ArrayList<>();
	List<Product> medAndRange1 = new ArrayList<>();
	List<Product> medAndRange2 = new ArrayList<>();
	List<Product> medAndRange3 = new ArrayList<>();
	List<Product> flowAndRange1 = new ArrayList<>();
	List<Product> flowAndRange2 = new ArrayList<>();
	List<Product> flowAndRange3 = new ArrayList<>();
	List<Product> foilAndRange1 = new ArrayList<>();
	List<Product> foilAndRange2 = new ArrayList<>();
	List<Product> foilAndRange3 = new ArrayList<>();
	
	@Activate
	@Modified
	public void activate() {
	 range1Plants = new AllPricesDao().fetchRange1PlantsData();
	 range2Plants = new AllPricesDao().fetchRange2PlantsData();
	 range3Plants = new AllPricesDao().fetchRange3PlantsData();
	 medAndRange1 = new AllPricesDao().fetchMedicinalAndRange1PlantsData();
	 medAndRange2 = new AllPricesDao().fetchMedicinalAndRange2PlantsData();
	 medAndRange3 = new AllPricesDao().fetchMedicinalAndRange3PlantsData();
	 flowAndRange1 = new AllPricesDao().fetchFlowerAndRange1PlantsData();
	 flowAndRange2 = new AllPricesDao().fetchFlowerAndRange2PlantsData();
	 flowAndRange3 = new AllPricesDao().fetchFlowerAndRange3PlantsData();
	 foilAndRange1 = new AllPricesDao().fetchFoilageAndRange1PlantsData();
	 foilAndRange2 = new AllPricesDao().fetchFoilageAndRange2PlantsData();
	 foilAndRange3 = new AllPricesDao().fetchFoilageAndRange3PlantsData();
	}

	@Override
	public List<Product> readRange1Data() {
		// TODO Auto-generated method stub
		return range1Plants;
	}

	@Override
	public List<Product> readRange2Data() {
		// TODO Auto-generated method stub
		return range2Plants;
	}

	@Override
	public List<Product> readRange3Data() {
		// TODO Auto-generated method stub
		return range3Plants;
	}

	@Override
	public List<Product> readMedAndRange1() {
		// TODO Auto-generated method stub
		return medAndRange1;
	}

	@Override
	public List<Product> readMedAndRange2() {
		// TODO Auto-generated method stub
		return medAndRange2;
	}

	@Override
	public List<Product> readMedAndRange3() {
		// TODO Auto-generated method stub
		return medAndRange3;
	}

	@Override
	public List<Product> readFlowAndRange1() {
		// TODO Auto-generated method stub
		return flowAndRange1;
	}

	@Override
	public List<Product> readFlowAndRange2() {
		// TODO Auto-generated method stub
		return flowAndRange2;
	}

	@Override
	public List<Product> readFlowAndRange3() {
		// TODO Auto-generated method stub
		return flowAndRange3;
	}

	@Override
	public List<Product> readFoilAndRange1() {
		// TODO Auto-generated method stub
		return foilAndRange1;
	}

	@Override
	public List<Product> readFoilAndRange2() {
		// TODO Auto-generated method stub
		return foilAndRange2;
	}

	@Override
	public List<Product> readFoilAndRange3() {
		// TODO Auto-generated method stub
		return foilAndRange3;
	}
	
	
}
