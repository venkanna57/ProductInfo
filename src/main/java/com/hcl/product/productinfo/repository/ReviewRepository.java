package com.hcl.product.productinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.productinfo.entity.Product;
import com.hcl.product.productinfo.entity.Rating;
import com.hcl.product.productinfo.entity.User;

@Repository
public interface ReviewRepository extends JpaRepository<Rating,Integer> {
	public Optional<Rating> findByProductAndUser(Product product, User user);	

}
