package com.OnlineFoodDelivery.ctrl;


import java.util.List;
import javax.validation.Valid;


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

import com.OnlineFoodDelivery.entities.OrderDetails;
import com.OnlineFoodDelivery.exceptions.IdNotFoundException;
import com.OnlineFoodDelivery.service.ICartService;
import com.OnlineFoodDelivery.service.IOrderService;


@RestController
@RequestMapping(path="orders")

public class OrderController {
	
	@Autowired
	IOrderService orderservice;
	
	@Autowired
	ICartService cartService;
	

	@PostMapping("/addOrder/{cartId}")
	public ResponseEntity<OrderDetails> addOrder(@PathVariable("cartId") int cartId)
	{
		OrderDetails order2 =orderservice.addOrder(cartId);
	   	return new ResponseEntity<OrderDetails>(order2,HttpStatus.OK);
	}
	
	/*@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrder(@Valid @RequestBody OrderDetails order)
	{
		OrderDetails order1=orderservice.viewOrderById(order.getOrderId());
	
			OrderDetails order2 =orderservice.updateOrder(order);
			return new ResponseEntity<OrderDetails>(order2,HttpStatus.OK);
	}*/
	
	@DeleteMapping("/removeOrderByOrderId/{orderId}")
	public  ResponseEntity<String> removeOrder(@PathVariable("orderId") int oid) throws IdNotFoundException  
	{
		   OrderDetails order1=orderservice.viewOrderById(oid);
	       
	    	   String msg=orderservice.removeOrderById(order1);
	    	   return new ResponseEntity<String>(msg, HttpStatus.OK);
	       
	}
	
	@GetMapping("/viewOrderByOrderId/{orderId}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") int oid) throws IdNotFoundException 
	{
		OrderDetails order2 = orderservice.viewOrderById(oid);
		
		
			return new ResponseEntity<OrderDetails>(order2, HttpStatus.OK);
		
	
	}
	
	@GetMapping("/viewAllOrdersByRestaurant/{restaurantName}")
	public ResponseEntity<List<OrderDetails>> viewAllOrdersByRestaurant(@PathVariable("restaurantName") String resName) 
	{
		List<OrderDetails> order2 = orderservice.viewAllOrdersByRestaurant(resName);
		
			return new ResponseEntity<List<OrderDetails>>(order2, HttpStatus.OK);

		
	}
	
	@GetMapping("/viewAllOrdersByCustomer/{customerId}")
	public ResponseEntity<List<OrderDetails>> viewAllOrdersByCustomer(@PathVariable("customerId") int id)  
	{
		List<OrderDetails> order2 = orderservice.viewAllOrdersByCustomer(id);
		
			return new ResponseEntity<List<OrderDetails>>(order2, HttpStatus.OK);
		
	}
	
	
}
