package com.OnlineFoodDelivery.service;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.entities.Restaurant;
import com.OnlineFoodDelivery.repository.IItemRepository;



@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemRepository itemRepository;
	@PersistenceContext
	EntityManager em ;
	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		itemRepository.save(item);
		return item;
	}

	@Override
	public Item viewItem(int id) {
		// TODO Auto-generated method stub
		Optional<Item> item =itemRepository.findById(id); 
		return item.get();
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		itemRepository.saveAndFlush(item);
		return item;
	}

	@Override
	public void removeItem(int itemId) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(itemId);
		
		
		
	}

	

	public List<Item> viewAllItems(int catId) {
		// TODO Auto-generated method stub
		TypedQuery<Item> tq = em.createQuery("select i from Item i inner join Category c on i.catId=c.catId where i.catId=:name1",Item.class);
		tq.setParameter("name1", catId);
		return tq.getResultList();
		
		
		//return null;
		
	}
	
	@Override
	
	public List<Item> viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Item> tq = em.createQuery("select i from Item i where i.itemName=:name1",Item.class);
		tq.setParameter("name1", name);
		return tq.getResultList();
		//return null;
	}

}