package com.OnlineFoodDelivery.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Category {

    @Id
    @GeneratedValue(generator="category_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="category_seq",sequenceName="category_seq",allocationSize=1)
	private int catId;
    @NotEmpty
    private String categoryName;
	
		
	public Category() {
		super();
	}

	public Category(int catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
	}
	
	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}
	
	
	
}

