package com.hcl.product.productinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.productinfo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	public Optional<User> findByUserId(Integer userId);
}
