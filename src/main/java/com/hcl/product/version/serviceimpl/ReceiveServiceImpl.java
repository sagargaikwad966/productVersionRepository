package com.hcl.product.version.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.version.entity.Product;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.repository.ProductRepository;
import com.hcl.product.version.service.ReceiveService;

@Service
public class ReceiveServiceImpl implements ReceiveService {

	@Autowired
	ProductRepository productRepository;

	private final List<ProductModel> receivedProductModelList = new ArrayList<>();

	@Override
	public void registerProduct(ProductModel productModel) {

		Product product = new Product(); 

		System.out.println("Inside registerProduct method................................................................");

		this.receivedProductModelList.add(productModel);

		for(ProductModel productModel1 : receivedProductModelList) { 
			Optional<Product> productOptional = productRepository.findById(productModel1.getProductId());

			if(productOptional.isPresent()) { 
				product = productOptional.get(); 
			}

			if (!(productModel.getProductNumber().equals(product.getProductNumber()) &&
					productModel.getProductId().equals(product.getProductId()) &&
					productModel.getProductName().equals(product.getProductName()) &&
					productModel.getPrice().equals(product.getPrice()) &&
					productModel.getProductDescription().equals(product.getProductDescription()) )) {

				Product productNew = new Product();

				BeanUtils.copyProperties(productModel, productNew);

				product.setStatus("INACTIVE");
				productRepository.save(product);

				productNew.setVersion("V" + String.valueOf(Integer.parseInt(productNew.getProductId().substring(6)) + 1));
				productNew.setStatus("ACTIVE");
				productNew.setProductId(productNew.getProductId().substring(0, 6) + String.valueOf(Integer.parseInt(productNew.getProductId().substring(6, 7)) + 1));
				productRepository.save(productNew); 
			} 
		}
	}
}