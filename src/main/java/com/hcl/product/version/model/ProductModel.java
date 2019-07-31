package com.hcl.product.version.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel 
{
	private String productId;
	private String productNumber;
	private String productName;
	private String productDescription;
	private Double price;
	private Date releaseDate;
	private String version;
	private String status;

}
