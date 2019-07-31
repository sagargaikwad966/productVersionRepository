package com.hcl.product.version.model;

import java.time.LocalDateTime;

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
	private LocalDateTime releaseDate;
	private String version;
	private String status;

}
