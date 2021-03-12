package com.sarp.TrainingProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarp.TrainingProject.common.ResErrorDto;
import com.sarp.TrainingProject.model.Product;
import com.sarp.TrainingProject.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	public ResponseEntity<?> post(@RequestBody Product model) {
		
		
		
		Product responseBody;
		
		try {
			responseBody = productService.postProduct(model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			ResErrorDto error = new ResErrorDto(e.getMessage());
			return ResponseEntity.badRequest().body(error);
		}
		
		return ResponseEntity.ok(responseBody);
	}
}
