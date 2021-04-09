package com.mindtree.Project_O2Store.core.services;

import java.util.List;

import com.mindtree.Project_O2Store.core.entity.Product;



public interface AllPrices {

	public List<Product> readRange1Data();
	public List<Product> readRange2Data();
	public List<Product> readRange3Data();
	public List<Product> readMedAndRange1();
	public List<Product> readMedAndRange2();
	public List<Product> readMedAndRange3();
	public List<Product> readFlowAndRange1();
	public List<Product> readFlowAndRange2();
	public List<Product> readFlowAndRange3();
	public List<Product> readFoilAndRange1();
	public List<Product> readFoilAndRange2();
	public List<Product> readFoilAndRange3();
}
