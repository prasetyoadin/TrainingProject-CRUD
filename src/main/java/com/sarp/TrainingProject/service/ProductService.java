package com.sarp.TrainingProject.service;

import com.sarp.TrainingProject.model.Product;

public interface ProductService {

	public Product postProduct(Product model);
	
	public Product getProductById(String id);
	
	public Product getAllProduct();
	
}
