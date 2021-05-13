package com.OnlineFoodDelivery.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineFoodDelivery.entities.Restaurant;
import com.OnlineFoodDelivery.repository.IRestaurantRepository;



@Service
@Transactional
public  class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	IRestaurantRepository repository;
	
	/*@Autowired
	IItemRepository repo2;*/
	
	
	
	@Override
	public Restaurant addRestaurant(Restaurant res) {
		
		repository.saveAndFlush(res);
		return res;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		
		repository.saveAndFlush(restaurant);
		return restaurant;
	}
	@Override
	public String removeRestaurantById(int Rid) {
		
		Restaurant rest=repository.findByRestaurantId(Rid);
//		List<Item> list=repo2.findItemsByRestaurant(rest.getRestaurantName());
//		for(int i=0;i<list.size();i++)
//		{
//			Item item=list.get(i);
//			int id=item.getItemId();
//			repo2.deleteById(id);
//		}
		repository.deleteById(Rid);
		
		String msg="Remove restaurant successfull !!!";
		return msg;
	}
 
	
	

	@Override
	public List<Restaurant> viewAllRestaurants() {
		
		List<Restaurant> list=repository.findAll();
		return list;
	}
	
	@Override
	public Restaurant viewRestaurantById(int id) {
		
		Restaurant restaurant = repository.findById(id).orElse(null);
		return restaurant;	
	}


	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		
		List<Restaurant> list = repository.viewNearByRestaurant(location);
		return list;
	}


	@Override
	public List<Restaurant> viewRestaurantByItemName(String restaurantName) {
		
		//List<Restaurant> list=repository.viewRestaurantByItemName(restaurantName);
		List<Restaurant> list=repository.findByRestaurantName(restaurantName);
		return list;
	}
}