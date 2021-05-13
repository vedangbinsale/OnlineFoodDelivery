package com.OnlineFoodDelivery.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OnlineFoodDelivery.entities.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	//@Query("select c from OrderDetails c where c.restaurant.restaurantId=(select r.restaurantId from Restaurant r where r.restaurantName=?1)")
	@Query("select c from Customer c inner join OrderDetails o on c.customerId=o.customer.customerId "
			+ "inner join Restaurant r on o.restaurant.restaurantId=r.restaurantId where "
			+ "r.restaurantName=:rName")
	List<Customer> findByRestaurantName(@Param("rName") String restaurantName);

	
}