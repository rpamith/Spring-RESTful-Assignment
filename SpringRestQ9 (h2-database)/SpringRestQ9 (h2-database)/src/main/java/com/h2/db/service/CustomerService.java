package com.h2.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.db.exception.RecordNotFoundException;
import com.h2.db.model.CustomerEntity;
import com.h2.db.model.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	public List<CustomerEntity> getAllCustomers()
	{
		System.out.println("getAllCustomers");
		List<CustomerEntity> result = (List<CustomerEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<CustomerEntity>();
		}
	}

	
	public CustomerEntity getCustomerById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getCustomerById");
		Optional<CustomerEntity> customer = repository.findById(id);
		
		if(customer.isPresent()) {
			return customer.get();
		} else {
			throw new RecordNotFoundException("No customer record exist for given id");
		}
	}
	
	public CustomerEntity createOrUpdateCustomer(CustomerEntity entity) 
	{
		System.out.println("createOrUpdateCustomer");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<CustomerEntity> customer = repository.findById(entity.getId());
			
			if(customer.isPresent()) 
			{
				CustomerEntity newEntity = customer.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteCustomerById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteCustomerById");
		
		Optional<CustomerEntity> customer = repository.findById(id);
		
		if(customer.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No customer record exist for given id");
		}
	} 
}