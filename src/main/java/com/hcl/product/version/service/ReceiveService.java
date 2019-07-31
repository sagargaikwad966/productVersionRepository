package com.hcl.product.version.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hcl.product.version.model.ProductModel;

@Service
public interface ReceiveService {


	//public Optional<ProductModel> getReceivedProduct(String productId);

	void registerProduct(ProductModel productModel);

	//Optional<ProductModel> getReceivedProduct(List receivedProductModelList);

}
