package com.Question_8.QNo_8.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import com.Question_8.QNo_8.Product;

@Service
public class ProductServicesImpl implements ProductService{

	@Autowired
	private ProductMongoRepo repo;
	List <Product> list;
	
	public ProductServicesImpl() {
	}
	
	@Override
	public List<Product> getProducts() {
		return repo.findAll();
	}

	@Override
	public Optional<Product> getProduct(int id) {
		return repo.findById(id);
	}

	@Override
	public Product addProduct(Product product) {
		return repo.insert(product); 
	}

	@Override
	public Product updateProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		repo.deleteById(id);
	}	

}
