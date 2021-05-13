package com.OnlineFoodDelivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFoodDelivery.entities.Bill;
import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.entities.FoodCart;
import com.OnlineFoodDelivery.entities.Item;
import com.OnlineFoodDelivery.entities.OrderDetails;
import com.OnlineFoodDelivery.repository.IBillRepository;
import com.OnlineFoodDelivery.repository.IOrderRepository;



@Service
@Transactional
public class BillServiceImpl implements IBillService {
	
	@Autowired
    IBillRepository repository;
	
	@Autowired
	IOrderRepository repository2;
	
	
	Customer customer;
	FoodCart foodCart;
	Item item;
	
	

	@Override
	public String removeBill(Bill bill) {
		
		repository.delete(bill);
		String msg="Bill removed Succesfully";
		return msg;
	}

	@Override
	public Bill viewBillById(int id) {
		
		Bill bill=repository.findById(id).orElse(null);
		System.out.println(bill);
		return bill;
		
	}

	@Override
	public List<Bill> viewBillsBetweenDates(LocalDate startDate, LocalDate endDate) {
        
		LocalDateTime startDateTime = startDate.atTime(0,0, 0);
        LocalDateTime endDateTime = endDate.atTime(23,59,59);
        List<Bill> bill=repository.findByBillDates(startDateTime, endDateTime);
        System.out.println(bill);
        return bill;
    }

	@Override
	public List<Bill> viewBillsByCustomerId(int custId) {
		
		List<Bill> bill=repository.findByCustId(custId);
		System.out.println(bill);
		return bill;
	}

	@Override
	public String calculateTotalCost(Bill bill) {
		
		Double totalCost=bill.getTotalCost();
		StringBuffer sb=new StringBuffer("Total cost of bill is ");
		sb.append(totalCost);
		String msg=sb.toString();
		return msg;
	}

	@Override
	public Bill addBill(OrderDetails order) {
		Bill bill=new Bill();
		List<Item> list=order.getList();	
		int total_item=list.size();
		int sum=0;
		for(int i=0;i<total_item;i++)
		{
			Item item=list.get(i);
			sum+=item.getCost();
		}
		
		bill.setBillDate(order.getOrderDate());
		bill.setOrder(order);
		bill.setTotalItem(total_item);
		bill.setTotalCost(sum);
		
		repository.save(bill);
		//repository.saveAndFlush(bill);
		return bill;
	}
	
}
