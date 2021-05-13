package com.OnlineFoodDelivery.tests;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.OnlineFoodDelivery.entities.Address;
import com.OnlineFoodDelivery.entities.Bill;
import com.OnlineFoodDelivery.entities.Category;
import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.entities.OrderDetails;
import com.OnlineFoodDelivery.entities.Restaurant;
import com.OnlineFoodDelivery.repository.IBillRepository;
import com.OnlineFoodDelivery.service.BillServiceImpl;




@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class BillServiceTest {

	@MockBean
	private IBillRepository repository;
	@Autowired
	private BillServiceImpl service;
	@Test
	void testAddBill() {
		 Address addr = new Address();
		 addr.setAddressId(12);
		 addr.setArea("bad");
		 addr.setBuildingName("good");
		 addr.setCity("better");
		 addr.setCountry("India");
		 addr.setState("MAHA");
		 addr.setPincode("123456");
		 addr.setStreetNo("123");
		    Customer customer = new Customer();
		    customer.setCustomerId(124);
		    customer.setFirstName("Abv234");;
		    customer.setLastName("abe3");
		    customer.setAge(34);
		    customer.setEmail("adb@hd87.cm");
		    customer.setMobileNumber("34567886");
		    customer.setGender("female");
		    customer.setAddress(addr);
		 Restaurant rest = new Restaurant();
		 rest.setContactNumber("12344556");
		 rest.setManagerName("Me.bdfs");
		 rest.setRestaurantId(12);
		 rest.setRestaurantName("sdjsjf");
		 rest.setAddress(addr);
		 	Category cat = new Category();
		 	cat.setCategoryName("itemacta");
		 	cat.setCatId(23);
		 List<Item> it = (List<Item>) new Item();
		 ((Item) it).setCategory(cat);
		 ((Item) it).setCost(20000);
		 ((Item) it).setItemId(12);
		 ((Item) it).setItemName("lunchvox");
		 ((Item) it).setRestaurant(rest);
		 ((Item) it).setQuantity(6);
		 	OrderDetails ord = new OrderDetails();
		 	ord.setOrderId(23);
		 	ord.setOrderDate(null);
		 	ord.setOrderStatus("Good");
		 	ord.setCustomer(customer);
		 	ord.setRestaurant(rest);
		 	ord.setList(it);
		 Bill bill = new Bill();
		 bill.setBillDate(null);
		 bill.setBillId(1);
		 bill.setOrder(ord);
		 bill.setTotalCost(1200000);
		 bill.setTotalItem(5);
		 
		 given(repository.save(bill)).willReturn(bill);	    
		    Bill savedCustomer = service.addBill(ord);	     
		    Assertions.assertThat(savedCustomer).isNotNull();	    
		    verify(repository).save(any(Bill.class));   
		 
		 
		 
	}

	@Test
	void testViewBillById() {
		Bill bill=repository.findById(36).orElse(null);
		assertNotNull(bill);
	}

	@Test
	void testViewBillsBetweenDates() {
		String time = "2019-03-27T10:15:30";
		String time2 = "2020-03-27T10:15:30";
		LocalDateTime startDateTime = LocalDateTime.parse(time);
        LocalDateTime endDateTime =LocalDateTime.parse(time2);
		List<Bill> list=repository.findByBillDates(startDateTime,endDateTime);
		assertNotNull(list);
	}

	@Test
	void testViewBillsByCustomerId() {
		List<Bill> list=repository.findByCustId(1);
		int cnt=list.size();
		boolean res=false;
		if(cnt>0)
		{
			res=true;
		}
		assertTrue(res);

	}

	@Test
	void testCalculateTotalCost() {
		Bill bill=new Bill();
		Double totalCost=bill.getTotalCost();
		assertNotNull(totalCost);
	}
	
	public Customer getCustomer()
	{
		Customer cust=new Customer();
		cust.setAddress(getAddress());
		cust.setAge(22);
		cust.setCustomerId(10);
		cust.setEmail("chaitu@gmail.com");
		cust.setFirstName("chitanya");
		cust.setGender("M");
		cust.setLastName("tholeti");
		cust.setMobileNumber("987654321");
		return cust;
	}
	public Address getAddress()
	{
		Address add=new Address();
		add.setAddressId(2);
		add.setArea("rajavaram");
		add.setBuildingName("naidu");
		add.setCity("kyg");
		add.setCountry("India");
		add.setPincode("534312");
		add.setState("AP");
		add.setStreetNo("106");
		return add;
	}
	public Restaurant getRestaurant()
	{
		Restaurant res=new Restaurant();
		res.setAddress(getAddress());
		res.setContactNumber("987654321");
	    res.setManagerName("vijneeth");
	    res.setRestaurantId(3);
	    res.setRestaurantName("Suprabath");
	    return res;
	}
	public Category getCategory() {
		Category cat=new Category();
		cat.setCatId(11);
		cat.setCategoryName("Food");
		return cat;
		
	}
	public Item getItem() {
		Item item=new Item();
		
		return null;
		
	}
	public OrderDetails getOrder()
	{
		OrderDetails ord=new OrderDetails();
		ord.setCustomer(getCustomer());
		ord.setList(null);
		ord.setOrderDate(LocalDateTime.now());
		ord.setOrderId(11);
		ord.setOrderStatus("pending");
		ord.setRestaurant(getRestaurant());
		return ord;
	}
	 public Bill getBill()
	 {
		 Bill bill=new Bill();
		 bill.setBillDate(LocalDateTime.now());
		 bill.setBillId(12);
		 bill.setOrder(getOrder());
		 bill.setTotalCost(100);
		 bill.setTotalItem(3);
		 return bill;
	 }


}
/*
{
	  "category": {
	    "catId": 0,
	    "categoryName": "string"
	  },
	  "cost": 0,
	  "itemId": 0,
	  "itemName": "string",
	  "quantity": 0,
	  "restaurant": {
	    "address": {
	      "addressId": 0,
	      "area": "string",
	      "buildingName": "string",
	      "city": "string",
	      "country": "string",
	      "pincode": "string",
	      "state": "string",
	      "streetNo": "string"
	    },
	    "contactNumber": "string",
	    "managerName": "string",
	    "restaurantId": 0,
	    "restaurantName": "string"
	  }
	}
	*/
