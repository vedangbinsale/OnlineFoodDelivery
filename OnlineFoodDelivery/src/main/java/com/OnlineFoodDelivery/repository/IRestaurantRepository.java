package com.OnlineFoodDelivery.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OnlineFoodDelivery.entities.Restaurant;


@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

//	@Query("select r from Restaurant r inner join Item i on r.restaurantId = i.restaurant.restaurantId where i.itemName = ?1")
//	public List<Restaurant> viewRestaurantByItemName(String itemName);
	public List<Restaurant> findByRestaurantName(String name);

	@Query(value="select * from restaurant r inner join address a on r.add_id = a.address_id where a.area =:area",nativeQuery = true)
	public List<Restaurant> viewNearByRestaurant(String area);
	//public List<Restaurant> viewNearByRestaurant(@Param("area") String location);

	
	//public Restaurant removeRestaurant(String res);

	public Restaurant findByRestaurantId(int rid);

}