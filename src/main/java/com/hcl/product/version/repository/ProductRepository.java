package com.hcl.product.version.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.version.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
{

}
