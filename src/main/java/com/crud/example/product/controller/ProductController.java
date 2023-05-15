package com.crud.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.product.entity.Product;
import com.crud.example.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	@GetMapping("/productByPrice/{price}")
	public Product getProductByPrice(@PathVariable int price) {
		return service.getProductByPrice(price);
	}
	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	@PutMapping("/update/{productId}")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);		
	}
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		return service.deleteProduct(productId);
	}
}
	
