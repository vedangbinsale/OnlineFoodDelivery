package com.OnlineFoodDelivery.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Item")
public class Item {
	@Id
	@GeneratedValue(generator="item_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_seq",sequenceName="item_seq",allocationSize=1)
	//@Column(name="item_Id")
	private int itemId;
	//@Column(name="item_name")
	private String itemName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="catId")
	private Category category;
	//@Column(name="quantity")
	private int quantity;
	//@Column(name="cost")
	private double cost;
	//@Column(name="restaurantlist")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant;
	public Item(int itemId, String itemName, Category category, int quantity, double cost, Restaurant restaurant) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurant = restaurant;
	}
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}