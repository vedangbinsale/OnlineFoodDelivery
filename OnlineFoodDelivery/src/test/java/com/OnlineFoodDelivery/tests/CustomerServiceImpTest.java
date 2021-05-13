package com.OnlineFoodDelivery.tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.OnlineFoodDelivery.entities.Address;
import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.exceptions.IdNotFoundException;
import com.OnlineFoodDelivery.repository.ICustomerRepository;
import com.OnlineFoodDelivery.service.CustomerServiceImp;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerServiceImpTest {

	@Autowired
	private CustomerServiceImp cusService;

	 @MockBean
	private ICustomerRepository cusRepo;
	 Customer customer=new Customer();
	 
	 /*
	 Success Test Case for adding a customer. 
	 Here a customer is created using customer attributes.
	 Then it is saved.
	 */
	 
	 @Test
		@DisplayName("Test create customer Success")
		void testCreateCustomerSuccess()  {
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
		    given(cusRepo.save(customer)).willReturn(customer);	    
		    Customer savedCustomer = cusService.updateCustomer(customer);	     
		    Assertions.assertThat(savedCustomer).isNotNull();	    
		    verify(cusRepo).save(any(Customer.class));       	    
		}
	 
	 /*
	 Failure Test Case for adding a customer.
	 Here we are using isNuLL for failure check.
	 */
	/* @Test
		@DisplayName("Test create customer Success")
		void testCreateCustomerFailure()  {
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
		    given(cusRepo.save(customer)).willReturn(customer);	    
		    Customer savedCustomer = cusService.updateCustomer(customer);	     
		    Assertions.assertThat(savedCustomer).isNull();	    
		    verify(cusRepo).save(any(Customer.class));       	    
		}
	 */
	 
	 @Test
		@DisplayName("Test findById Success")
		void testFindCustomerById() throws IdNotFoundException {
		 final int customerId= 12;
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
		    given(cusRepo.findById(customerId)).willReturn(Optional.of(customer));
	        final Customer expected  =cusService.viewCustomerById(customerId);
	        Assertions.assertThat(expected).isNotNull();	 
	 }
	 
	 
	 
	/* @Test
		@DisplayName("Test For Delete success")
		public void shouldBeDeleted() {
		 Customer customer=new Customer();
			final int customerId =8;
			customer.setCustomerId(customerId);
	        given(cusRepo.findById(customerId)).willReturn(Optional.of(customer));
	        cusService.removeCustomerById(customerId);
			verify(cusRepo,times(1)).delete(customer);	
	 }*/
	
	/* @Test
		@DisplayName("Test For CustomerById Throw Exceptions")
		public void testFindCustomerByIdWhenExceptionThrown() {
		 final int customerId = 10;
		 Address addr = new Address();
		 addr.setAddressId(1);
		 addr.setArea("bad");
		 addr.setBuildingName("good");
		 addr.setCity("better");
		 addr.setCountry("India");
		 addr.setState("MAHA");
		 addr.setPincode("123456");
		 addr.setStreetNo("123");
		    Customer customer = new Customer();
		    customer.setCustomerId(100);
		    customer.setFirstName("Abv234");;
		    customer.setLastName("abe3");
		    customer.setAge(34);
		    customer.setEmail("adb@hd87.cm");
		    customer.setMobileNumber("34567886");
		    customer.setGender("female");
		    customer.setAddress(addr);
		    Exception exception = assertThrows(IdNotFoundException.class, () -> {
		    	cusService.viewCustomerById(customerId);
		    });	
		    String expectedMessage = "Customer Id not found !!!";
		    String actualMessage = exception.getMessage();
		    assertEquals(expectedMessage,actualMessage);
	 }*/
	 
}