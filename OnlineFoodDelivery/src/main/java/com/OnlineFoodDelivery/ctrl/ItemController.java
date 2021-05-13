package com.OnlineFoodDelivery.ctrl;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.service.IItemService;



@RestController
@CrossOrigin
@RequestMapping(path="item")
public class ItemController {
	@Autowired
	private IItemService itemService;

		@PostMapping("/addItem")
		public ResponseEntity<Item> AddItem(@RequestBody Item item){
			Item items= itemService.addItem(item);
			if(items==null){
				return new ResponseEntity("Sorry! Items not available!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Item>(items, HttpStatus.OK);
		}
		@GetMapping("/{itemId}")
		public ResponseEntity<Item> findItem(@PathVariable("itemId")int itemId){
			Item items= itemService.viewItem(itemId);
			if(items==null) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Item>(items, HttpStatus.OK);
		}
		@PutMapping("/updateItem")
		public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
			
			Item item1 = itemService.viewItem(item.getItemId());
			
				Item item2 = itemService.updateItem(item);
				return new ResponseEntity<Item>(item2, HttpStatus.OK);
			
		}
		@DeleteMapping("/deleteItem/{itemId}")
		public ResponseEntity<?> deleteItem(@PathVariable("itemId")int itemId){
			itemService.removeItem(itemId);
			
			return new ResponseEntity<>("Item deleted", HttpStatus.OK);
		}
		@GetMapping("itemName/{itemName}")
		public ResponseEntity<List<Item>> findItemByName(@PathVariable("itemName")String itemName){
			List<Item> items= itemService.viewAllItemsByName(itemName);
			if(items==null) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
		}
		@GetMapping("/categoryName/{category.catId}")
		public ResponseEntity<List<Item>> findItemByCategory(@PathVariable("category.catId")int catId){
			List<Item> items= itemService.viewAllItems(catId);
			if(items==null) {
				return new ResponseEntity("Sorry! Items not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
		}
	

}