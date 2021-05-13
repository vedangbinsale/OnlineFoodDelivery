package com.OnlineFoodDelivery.ctrl;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFoodDelivery.entities.FoodCart;
import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.service.ICartService;
import com.OnlineFoodDelivery.service.IItemService;

@RestController
@RequestMapping(path="cart")

public class CartController {

	@Autowired
	ICartService CService;
	
	@Autowired
	IItemService IService;
	@PostMapping("/addCart")
	public ResponseEntity<FoodCart> addCart(@Valid @RequestBody FoodCart Cart){
		FoodCart cart= CService.addCart(Cart);
		
		return new ResponseEntity<FoodCart>(Cart, HttpStatus.OK);
	}
	
	@PostMapping("/addItemToCart/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@RequestParam("cartId") int cartId,@PathVariable int itemId) {
		
		FoodCart cart1 = CService.addItemToCart(cartId,itemId);
		
		FoodCart cart2=new FoodCart();
		cart2.setCartId(cart1.getCartId());
		cart2.setCustomer(cart1.getCustomer());
		return new ResponseEntity<FoodCart>(cart2, HttpStatus.OK);
		
	}
	
	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@PathVariable("cartId") int cart_id,@PathVariable("itemId") int item_id, @PathVariable int quantity){
		
		FoodCart cart=CService.increaseQuantity(cart_id,item_id, quantity);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>  reduceQuantity(@PathVariable("cartId") int cart_id,@PathVariable("itemId") int item_id, @PathVariable int quantity) {
		
		FoodCart cart=CService.reduceQuantity(cart_id,item_id, quantity);
		
		
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItem")
	public ResponseEntity<String> removeItem(@RequestParam("cartId") int cartId, @RequestParam("itemId") int itemId) {
		
		FoodCart cart=CService.getCartById(cartId);
		
			Item item=IService.viewItem(itemId);
			String msg=CService.removeItem(cart, item);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
	}
	
	@DeleteMapping("/clearCart/{cartId}")
	public ResponseEntity<String>  clearCart(@PathVariable int cartId){
		
		String msg=CService.clearCart(cartId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}

