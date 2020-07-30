package com.hcl.product.productinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.productinfo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductId(Integer productId);

}
