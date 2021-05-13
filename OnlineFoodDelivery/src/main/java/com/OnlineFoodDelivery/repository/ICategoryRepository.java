package com.OnlineFoodDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineFoodDelivery.entities.Category;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
