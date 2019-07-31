package com.hcl.product.version.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 3340571659598355427L;

	@Id
	private String productId;
	private String productNumber;
	private String productName;
	private String productDescription;
	private Double price;
	private String version;
	private String status;
}
