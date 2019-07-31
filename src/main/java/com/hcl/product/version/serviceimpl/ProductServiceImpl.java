package com.hcl.product.version.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.version.entity.Product;
import com.hcl.product.version.exception.ProductVersionException;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.repository.ProductRepository;
import com.hcl.product.version.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<ProductModel> getAllProducts() throws ProductVersionException 
	{
		Optional<List<Product>> findByStatusOptional = productRepository.findByStatus("ACTIVE");
		
		List<Product> productList = new ArrayList<>();
		List<ProductModel> productModelList = new ArrayList<>();
		
		boolean isOptionalPresent = findByStatusOptional.isPresent();
		
		if(isOptionalPresent)
		{
			productList = findByStatusOptional.get();
			productList.stream().forEach(product ->
			{
				ProductModel model = new ProductModel();
				BeanUtils.copyProperties(product, model);
				productModelList.add(model);
			}
			);
		}
		else
		{
			throw new ProductVersionException("No product found");
		}
		return productModelList;
	}

}
