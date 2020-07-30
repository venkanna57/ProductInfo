package com.hcl.product.productinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.productinfo.entity.Orders;
import com.hcl.product.productinfo.entity.Product;

@Repository
public interface ProductOrderRepository extends JpaRepository<Orders,Integer>{
	public Optional<Orders> findByProduct(Product product);

}
