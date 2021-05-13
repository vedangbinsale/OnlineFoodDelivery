package com.OnlineFoodDelivery.entities;

import java.util.List;



import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class FoodCart {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(generator="cart_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cart_seq",sequenceName="cart_seq",allocationSize=1)	
	private int cartId;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = false)
	@JoinColumn(name="custId", referencedColumnName = "customerId")
	private Customer customer;
	
	//@ManyToMany
	//@JoinTable(name="cart_item_list", joinColumns = { @JoinColumn(name="cartId")},inverseJoinColumns = {@JoinColumn(name="itemId")})
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = false)
	@JoinTable(name="itemId")
   private List<Item> itemList;
	
	
	public FoodCart() {
		super();
	}

	public FoodCart(int cartId, Customer customer, List<Item> itemList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.itemList = itemList;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}
	
	
}
