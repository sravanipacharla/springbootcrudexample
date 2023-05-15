package com.crud.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.example.product.entity.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Integer> {


	//JPQL
	//NATIVE QUERY>
	
	
	
	@Query("select p from Product p where p.price=50000")
	public Product findProductByPrice(int price);
}


