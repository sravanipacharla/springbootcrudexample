package com.crud.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.product.entity.Product;
import com.crud.example.product.repository.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	public List<Product> saveProduct(List<Product> products) {
		return repository.saveAll(products);
	}
	public List<Product> getProducts(){
		return repository.findAll();
	}
	public Product getProductByPrice(int price) {
		return repository.findProductByPrice(price);
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return" product removed"+id;
	}
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
	

}
