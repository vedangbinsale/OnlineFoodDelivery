package com.OnlineFoodDelivery.ctrl;

 


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFoodDelivery.entities.Bill;
import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.exceptions.IdNotFoundException;
import com.OnlineFoodDelivery.service.ICustomerService;



@RestController
@RequestMapping(path="customers")
public class CustomerController {

	@Autowired
	ICustomerService service;
	private static Logger logger=LoggerFactory.getLogger(CustomerController.class);

	//http://localhost:8143/customers/addCustomer
	@PostMapping("/addCustomer") 
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) 
	{
		logger.info("Enter CustomerController :: method=addCustomer");

	    Customer customer2=service.addCustomer(customer);
		return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
	}
	//http://localhost:8143/customers/updateCustomer

	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer)
	{
		logger.info("Enter CustomerController :: method=updateCustomer");

			Customer customer2=service.updateCustomer(customer);
			return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
		
	}
	//http://localhost:8143/customers/removeCustomer/5

	@DeleteMapping("/removeCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") int id)  
	{
		logger.info("Enter CustomerController :: method=removeCustomer");

			String result=service.removeCustomerById(id);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		
			
	}
	//http://localhost:8143/customers/viewCustomer/1

	@GetMapping("/viewCustomer/{customerId}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("customerId") int id) throws IdNotFoundException
	{
		logger.info("Enter CustomerController :: method=findbyIdCustomer");

		Customer customer=service.viewCustomerById(id);
	  
		if(customer==null)
		{
			throw new IdNotFoundException("Customer Id not found !!!");
		}
		else
		{
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
	}
	//http://localhost:8143/customers/viewAllCustomerByRestaurant/string

	@GetMapping("/viewAllCustomerByRestaurant/{restaurantName}")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("restaurantName") String name) 
	{
		logger.info("Enter CustomerController :: method=FindByrestauntCustomer");

	    List<Customer> customer=service.viewAllCustomer(name);
	    
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
}
