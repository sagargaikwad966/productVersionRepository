package com.hcl.product.version.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.product.version.exception.ProductVersionException;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.model.ResponseData;
import com.hcl.product.version.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest 
{
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductService productServiceMock;
	
	
	List<ProductModel> productModelList = new ArrayList<>();
	ProductModel productModel1 = new ProductModel();
	
	@Before
	public void setUp()
	{
		productModel1.setProductId("POLO1_1");
		productModelList.add(productModel1);
	}
	
	@Test
	public void testShowAllProducts() throws ProductVersionException
	{
		Mockito.when(productServiceMock.getAllProducts()).thenReturn(productModelList);
		ResponseEntity<ResponseData> showAllProductsResponse = productController.showAllProducts();
		
		String statusDescription = showAllProductsResponse.getBody().getStatus().get(200);
		assertNotNull(showAllProductsResponse);
		assertEquals("Successfull Fetch", statusDescription);
		
		
	}

}
