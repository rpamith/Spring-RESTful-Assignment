package com.Question_8.QNo_8;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Question_8.QNo_8.services.ProductService;


@RestController
public class ProductsController {
	
	@Autowired
	private ProductService obj;
	
	@GetMapping("/Home")
	public String msg()
	{
		return  "Welcome user";
	}
	
	@GetMapping("/Products")
	public List<Product> getAllProducts()
	{
		return  this.obj.getProducts();
	}
	
	@GetMapping("/Products/{id}")
	public Optional<Product> getProduct(@PathVariable("id") String id)
	{
		return this.obj.getProduct(Integer.parseInt(id));
	}
	
	@PostMapping(path="/Products",consumes = "application/json")
	public Product addProduct(@RequestBody Product product) 
	{
		return this.obj.addProduct(product);
	}
	
	@PutMapping("/Products")
	public Product updateProduct(@RequestBody Product product) 
	{
		return this.obj.updateProduct(product);
	}

	@DeleteMapping("/Products/{id}")
	public void deleteProduct(@PathVariable("id") String id) 
	{
		this.obj.deleteProduct(Integer.parseInt(id));
		
	}
}
