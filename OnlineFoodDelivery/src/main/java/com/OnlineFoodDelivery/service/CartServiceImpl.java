package com.OnlineFoodDelivery.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFoodDelivery.entities.FoodCart;
import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.entities.Restaurant;
import com.OnlineFoodDelivery.repository.ICartRepository;
import com.OnlineFoodDelivery.repository.IItemRepository;



@Service
@Transactional
public class CartServiceImpl implements ICartService{

	@Autowired
	ICartRepository repository;
	
	@Autowired
	IItemRepository repository2;
	
	@Override
	public FoodCart addItemToCart(int cartId, int itemId) {
		
		FoodCart cart=repository.findById(cartId).orElse(null);
		FoodCart cart1=new FoodCart();
		Item item=repository2.findById(itemId).orElse(null);
		int size=cart.getItemList().size();
		if(size==0)
		{
			cart.getItemList().add(item);
		    cart1=repository.save(cart);			
		}
		else
		{
			int new_rid=item.getRestaurant().getRestaurantId();
			int old_rid=cart.getItemList().get(0).getRestaurant().getRestaurantId();
			if(new_rid==old_rid)
			{
				//item.setQuantity(1);
				cart.getItemList().add(item);
			    cart1=repository.save(cart);
			}
			else
			{
				return null;
			}
		}
		return cart1;
	}

	@Override
	public FoodCart increaseQuantity(int cart_id,int item_id, int quantity) {
		
		FoodCart cart=repository.findById(cart_id).orElse(null);
		List<Item> list=cart.getItemList();							
		int size=list.size();
		int cnt=0;
		for(int i=0;i<size;i++)
		{
			int id=list.get(i).getItemId();
			if(item_id==id)
			{
				cnt++;
			}
		}
		
		if(cnt>0)
		{
			for(int i=0;i<quantity;i++)
			{
				addItemToCart(cart_id, item_id);
			}
			return cart;
		}
		else
		{
			return null;
		}
	
	}

	@Override
	public FoodCart reduceQuantity(int cart_id,int item_id, int quantity) {
		
		FoodCart cart=repository.findById(cart_id).orElse(null);
		List<Item> list=cart.getItemList();	
		Item item=repository2.findById(item_id).orElse(null);
	
		for(int i=0;i<quantity;i++)
		{
			removeItem(cart, item);
		}
		return cart;
	}

	@Override
	public String removeItem(FoodCart cart, Item item) {
		List<Item> list=cart.getItemList();
		int id=item.getItemId();
		int isPresent=0,index=0;
		for(int i=0;i<list.size();i++)
		{
			if(id==list.get(i).getItemId())
			{
				isPresent=1;
				index=i;
				break;
			}
			
		}
		if(isPresent==1)
		{
			list.remove(index);
		}
		cart.setItemList(list);
		repository.save(cart);
		return "Item removed successfully...";
	}
	
	@Override
	public String clearCart(int cartId) {
		FoodCart cart=repository.findById(cartId).orElse(null);
		List<Item> item=cart.getItemList();
		item.clear();
		return "Cart cleared....";
	}

	@Override
	public FoodCart getCartById(int cartId) {
		System.out.println(cartId);
		FoodCart cart=repository.findById(cartId).orElse(null);
		System.err.println(cart);
		return cart;
	}

	@Override
	public Item getItemById(int itemId) {
		return repository2.findById(itemId).orElse(null);
	}

	@Override
	public FoodCart addCart(FoodCart Cart) {
		
		return repository.save(Cart);
	}

}
