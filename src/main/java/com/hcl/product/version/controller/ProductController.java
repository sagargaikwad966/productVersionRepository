package com.hcl.product.version.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.version.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductService productService;

}
