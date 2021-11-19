package com.Question_8.QNo_8.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Question_8.QNo_8.Product;

public interface ProductMongoRepo extends MongoRepository<Product, Integer> {

}
