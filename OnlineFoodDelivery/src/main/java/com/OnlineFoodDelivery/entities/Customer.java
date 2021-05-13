package com.OnlineFoodDelivery.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;




@Entity
public class Customer {

	@Id
	@GeneratedValue(generator="customer_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="customer_seq",sequenceName="customer_seq",allocationSize=1)	
	private int customerId;
	 @NotEmpty
	private String firstName;
	 @NotEmpty
	private String lastName;
	private String gender;

	private int age;
	
	private String mobileNumber;
	 @NotEmpty
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = false)
	@JoinColumn(name="add_Id", referencedColumnName = "addressId")
	private Address address;
		
			
	public Customer() {
		super();
	}


	public Customer(String firstName, String lastName, String gender, int age, String mobileNumber, Address address,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
	}
	
	
	public Customer(int customerId, String firstName, String lastName, String gender, int age,
			String mobileNumber, Address address, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", email=" + email + "]";
	}
	
	
	
	
}
