package com.OnlineFoodDelivery.service;


import java.util.List;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFoodDelivery.entities.Category;
import com.OnlineFoodDelivery.repository.ICategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
    ICategoryRepository repository;
	
	
	@Override
	public Category addCategory(Category cat) {
		
		repository.save(cat);
		return cat;
	}

	@Override
	public Category updateCategory(Category cat) {
		
		repository.save(cat);
		return cat;
	}

	@Override
	public String removeCategory(Category cat) {
		
		repository.delete(cat);
		String msg="Category removed successfully...";
		return msg;
	}

	@Override
	public Category viewCategoryById(int id) {
		
		Category c=repository.findById(id).orElse(null);
		return c;
	}

	@Override
	public List<Category> viewAllCategory() {
		
		List<Category> cat=repository.findAll();
		return cat;
	}

}
