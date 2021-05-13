package com.OnlineFoodDelivery.service;

import java.util.List;

import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.exceptions.IdNotFoundException;



public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer viewCustomerById(int id ) throws IdNotFoundException ;
	public List<Customer> viewAllCustomer(String restaurantname);
	public String removeCustomerById(int id)  ;
	 
}