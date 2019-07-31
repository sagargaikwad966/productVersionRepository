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

@Service
public class ProductServiceImpl implements ProductService,CommandLineRunner 
{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	LoadObjectUtils loadObjectUtils;
	
	private static final String JMS_QUEUE = "jms.queue";

	private final JmsTemplate jmsTemplate;
	

	@Override
	public List<ProductModel> loadProducts(String filePath) {
		List<Product> existingProducts = productRepository.findAll();
		productRepository.deleteAll(existingProducts);
		List<Product> products = loadObjectUtils.mappingExcelToProduct(filePath);
		List<ProductModel> productModelList = new ArrayList<>();
		productRepository.saveAll(products);
		// BeanUtils.copyProperties(productRepository.saveAll(products), productModel);

		for (Product product : products) {
			ProductModel productModel = new ProductModel();
			BeanUtils.copyProperties(product, productModel);
			productModelList.add(productModel);
		}

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


	

	@Autowired
	public ProductServiceImpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public String addProduct(ProductModel productModel) {
		System.out.println("Inside ProductServiceImpl..........................................................");
		String result = "Successfully saved new product data";
		jmsTemplate.convertAndSend(JMS_QUEUE, productModel);
		System.out.println("Message sent from ProductServiceImpl.........................................................." +productModel+ " ");
		return result;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}
}
