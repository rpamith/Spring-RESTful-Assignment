package com.Question_8.QNo_8.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Question_8.QNo_8.Product;

@Service
public interface ProductService {
	public List<Product> getProducts();
	public Optional<Product> getProduct(int id);
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(int id);
}
