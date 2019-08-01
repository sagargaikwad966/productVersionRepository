package com.hcl.product.version.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.version.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
{

	public Optional<List<Product>> findByStatus(String status);
}
