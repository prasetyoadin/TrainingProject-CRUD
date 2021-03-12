package com.sarp.TrainingProject.service;

import org.springframework.stereotype.Service;

import com.sarp.TrainingProject.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Override
	public Product postProduct(Product model) {
		
		Product product = new Product();
		
		product.setProductName(model.getProductName());
		product.setOtherData(model.getOtherData());
		
		return product;
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
