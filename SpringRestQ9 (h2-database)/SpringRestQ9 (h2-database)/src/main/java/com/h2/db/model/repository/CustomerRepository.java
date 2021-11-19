package com.h2.db.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h2.db.model.CustomerEntity;


@Repository
public interface CustomerRepository 
			extends CrudRepository<CustomerEntity, Long> {

}
