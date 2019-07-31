package com.hcl.product.version.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productId;
	private String productNumber;
	private String productName;
	private String productDescription;
	private Double price;
	private String version;
	private String status;

}
