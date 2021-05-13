package com.OnlineFoodDelivery.service;

import java.util.List;

import com.OnlineFoodDelivery.entities.Category;


public interface ICategoryService {

	public Category addCategory(Category cat);
	public Category updateCategory(Category cat);
	public String removeCategory(Category cat) ;
	public Category viewCategoryById(int id) ;
	public List<Category> viewAllCategory();
}
