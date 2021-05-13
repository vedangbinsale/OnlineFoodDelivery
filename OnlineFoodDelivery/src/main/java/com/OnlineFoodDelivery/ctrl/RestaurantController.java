package com.OnlineFoodDelivery.ctrl;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFoodDelivery.entities.Restaurant;
import com.OnlineFoodDelivery.service.IRestaurantService;



@RestController
@RequestMapping(path="restaurant")

public class RestaurantController {
	
	@Autowired
	IRestaurantService service;
	
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant){
		
		Restaurant restaurant2 = service.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(restaurant2, HttpStatus.OK);
	}
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<Restaurant> updateRestaurant(@Valid @RequestBody Restaurant restaurant){
		
		Restaurant restaurant1=service.viewRestaurantById(restaurant.getRestaurantId());
		
			Restaurant restaurant2 = service.updateRestaurant(restaurant);
			return new ResponseEntity<Restaurant>(restaurant2, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removeRestaurantById/{restaurantId}")
	public ResponseEntity<String> removeRestaurantById(@PathVariable("restaurantId") int Rid) {
		
		Restaurant restaurant=service.viewRestaurantById(Rid);
	
			String msg = service.removeRestaurantById(Rid); 
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/viewAllRestaurants")
	public ResponseEntity<List<Restaurant>> viewAllRestaurants(){
		
		List <Restaurant> list = new ArrayList<Restaurant>();
		for(Restaurant r : service.viewAllRestaurants())
		{
			Restaurant r1 = new Restaurant();
			r1.setRestaurantId(r.getRestaurantId());
			r1.setRestaurantName(r.getRestaurantName());
			r1.setManagerName(r.getManagerName());
			r1.setContactNumber(r.getContactNumber());
			r1.setAddress(r.getAddress());
			list.add(r1);
			
		}
		return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/viewRestaurantByItemName")
	public ResponseEntity<List<Restaurant>> viewRestaurantByItemName(@RequestParam("itemName") String itemName) {
		
		List <Restaurant> list =  service.viewRestaurantByItemName(itemName);
		System.err.println(list);
		
			return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
			
		
	}
	
	@GetMapping("/viewNearByRestaurant")
	public ResponseEntity<List<Restaurant>> viewNearByRestaurant(@RequestParam("area") String location) {
		
		List <Restaurant> list = service.viewNearByRestaurant(location);
		
			return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
				
	}

	@GetMapping("/viewRestaurantById/{restaurantId}")
	public ResponseEntity<Restaurant> viewRestaurantById(@PathVariable("restaurantId") int id) {
		
		Restaurant rest2 = new Restaurant();
		Restaurant restaurant = service.viewRestaurantById(id);
		
			rest2.setContactNumber(restaurant.getContactNumber());
			rest2.setManagerName(restaurant.getManagerName());
			rest2.setRestaurantName(restaurant.getRestaurantName());
			rest2.setRestaurantId(restaurant.getRestaurantId());
			rest2.setAddress(restaurant.getAddress());
			return new ResponseEntity<Restaurant>(rest2, HttpStatus.OK);
	
		
	}
}

