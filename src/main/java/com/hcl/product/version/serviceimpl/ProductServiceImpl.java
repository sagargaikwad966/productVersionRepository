package com.hcl.product.version.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.hcl.product.version.entity.Product;
import com.hcl.product.version.exception.ProductVersionException;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.repository.ProductRepository;
import com.hcl.product.version.service.ProductService;
import com.hcl.product.version.utils.LoadObjectUtils;

@Service("ProductServiceImplss")
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;

	@Autowired
	LoadObjectUtils loadObjectUtils;
	
	@Autowired
	JmsTemplate jmsTemplate;

	private static final String JMS_QUEUE = "jms.queue";

	

	@Override
	public List<ProductModel> loadProducts(String filePath) {
		
		List<Product> oldProductList = new ArrayList<>();
		List<Product> newProductList = new ArrayList<>();
		
		oldProductList = productRepository.findAll();
		
		productRepository.deleteAll(oldProductList);
		
		List<ProductModel> productModelList = loadObjectUtils.mappingExcelToProduct(filePath);
		
		productModelList.stream().forEach(productModel ->
		{
			Product product = new Product();
			BeanUtils.copyProperties(productModel, product);
			newProductList.add(product);
		}
				);
		
		productRepository.saveAll(newProductList);

		return productModelList;
	}

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


	@Override
	public void addProduct(ProductModel productModel) {
		System.out.println("Inside ProductServiceImpl..........................................................");
		jmsTemplate.convertAndSend(JMS_QUEUE, productModel);
		System.out.println("Message sent from ProductServiceImpl.........................................................." +productModel+ " ");
	}


}
