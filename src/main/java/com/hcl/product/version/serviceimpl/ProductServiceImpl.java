package com.hcl.product.version.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.version.repository.ProductRepository;
import com.hcl.product.version.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;

}
