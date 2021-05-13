package com.OnlineFoodDelivery.repository;

 


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.entities.Restaurant;


@Repository
public interface IItemRepository extends JpaRepository<Item, Integer>{


}