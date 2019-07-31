package com.hcl.product.version.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.hcl.product.version.model.ProductModel;
import com.hcl.product.version.service.ReceiveService;

@Component
public class ProductMessageListener {
	
	@Autowired
    private ReceiveService receiveService;
     
    @Autowired
    public ProductMessageListener(ReceiveService receiveService) {
        this.receiveService = receiveService;
    }
     
    @JmsListener(destination = "jms.queue", containerFactory= "myFactory")
    public void receiveProduct(ProductModel productModel) {
    	System.out.println("Inside ProductMessageListener................................................................");
    	receiveService.registerProduct(productModel);
    }
}
