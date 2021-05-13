package com.OnlineFoodDelivery.service;

import com.OnlineFoodDelivery.entities.FoodCart;
import com.OnlineFoodDelivery.entities.Item;

public interface ICartService {
	public FoodCart addCart(FoodCart Cart);
	public FoodCart addItemToCart(int cartId,int itemId);
	public FoodCart increaseQuantity(int cart_id,int item_id,int quantity);
	public FoodCart reduceQuantity(int cart_id,int item_id,int quantity);
	public String removeItem(FoodCart cart,Item item);
	public String clearCart(int cartId);
	public FoodCart getCartById(int cartId);
	public Item getItemById(int itemId);
		
}

