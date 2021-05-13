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

import com.OnlineFoodDelivery.entities.Category;
import com.OnlineFoodDelivery.service.CategoryServiceImpl;

@RestController
@RequestMapping(path="category")

public class CategoryController {
	
	@Autowired
	CategoryServiceImpl service;
	
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category)
	{ 
		Category category1=service.addCategory(category);
		return new ResponseEntity<Category>(category1,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) 
	{ 
		Category category1=service.viewCategoryById(category.getCatId());
		
			Category category2=service.updateCategory(category);
			return new ResponseEntity<Category>(category2,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/removeCategory/{categoryId}")
	public ResponseEntity<String> removeCategory(@PathVariable("categoryId") int id) 
	{ 
		Category category1=service.viewCategoryById(id);
		
			String msg=service.removeCategory(category1);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewCategory/{categoryId}")
	public ResponseEntity<Category> viewCategory(@PathVariable("categoryId") int id) 
	{
		Category category1=service.viewCategoryById(id);
		
			return new ResponseEntity<Category>(category1,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/viewAllCategory")
	public ResponseEntity<List<Category>> viewAllCategory()
	{ 
		List<Category> category1=service.viewAllCategory();
		return new ResponseEntity<List<Category>>(category1,HttpStatus.OK);
		
	}
	
}
