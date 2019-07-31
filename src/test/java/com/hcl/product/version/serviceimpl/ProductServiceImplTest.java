package com.hcl.product.version.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.product.version.entity.Product;
import com.hcl.product.version.exception.ProductVersionException;
import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.repository.ProductRepository;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

		
		@InjectMocks
		ProductServiceImpl productServiceImpl;
		
		@Mock
		ProductRepository productRepositoryMock;
		
		List<ProductModel> productModelList = new ArrayList<>();
		ProductModel productModel1 = new ProductModel();
		
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product();
		
		Optional<List<Product>> optionalList = Optional.of(productList);
		
		@Before
		public void setUp()
		{
			productModel1.setProductId("POLO1_1");
			productModelList.add(productModel1);
			
			product1.setProductId("POLO1_1");
			product1.setStatus("ACTIVE");
			productList.add(product1);
			
			optionalList = Optional.of(productList);
			
		}
		
		@Test
		public void testGetAllProductsSuccess() throws ProductVersionException
		{
			
			Mockito.when(productRepositoryMock.findByStatus("ACTIVE")).thenReturn(optionalList);
			List<ProductModel> allProducts = productServiceImpl.getAllProducts();
			
			assertNotNull(allProducts);
			assertEquals(1, allProducts.size());
		}
		
		@Test(expected = ProductVersionException.class)
		public void testGetAllProductsFailure() throws ProductVersionException
		{
			
			Mockito.when(productRepositoryMock.findByStatus("ACTIVE")).thenReturn(Optional.empty());
			productServiceImpl.getAllProducts();

		}
		
}
