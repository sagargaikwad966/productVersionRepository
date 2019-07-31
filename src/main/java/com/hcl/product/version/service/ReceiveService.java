package com.hcl.product.version.service;

import org.springframework.stereotype.Service;

import com.hcl.product.version.model.ProductModel;

@Service
public interface ReceiveService {

	void registerProduct(ProductModel productModel);

}
