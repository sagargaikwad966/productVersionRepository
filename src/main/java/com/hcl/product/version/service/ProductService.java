package com.hcl.product.version.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.product.version.exception.ProductVersionException;
import com.hcl.product.version.model.ProductModel;

@Service
public interface ProductService {

	public String addProduct(ProductModel productModel);

	public List<ProductModel> loadProducts(String filePath);

	public List<ProductModel> getAllProducts() throws ProductVersionException;
}
