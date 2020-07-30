package com.hcl.product.productinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.product.productinfo.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer>{

}
