package com.hcl.product.version.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.version.exception.ProductVersionException;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.model.ResponseData;
import com.hcl.product.version.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductService productService;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseData> showAllProducts() throws ProductVersionException
	{
		List<ProductModel> allProducts = productService.getAllProducts();
		Map<Integer,String> status = new HashMap<Integer, String>(); 
		status.put(200, "Successfull Fetch");
		ResponseData response = new ResponseData("Product List", status, allProducts);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
