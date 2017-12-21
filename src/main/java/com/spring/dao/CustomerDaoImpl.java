package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.customer.model.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	private static List<Customer> customer;
	{
		customer = new ArrayList<Customer>();
		customer.add(new Customer("teja", "Vangala"));
		customer.add(new Customer("arvani", "reddy"));
		customer.add(new Customer("raja", "Van"));
		customer.add(new Customer("vani", "redy"));
	}

	public Customer saveCustomer(Customer customer) {
		return customer;
	}

	public Customer getcusutomerByfirstName(String firstName) {
		for (Customer cust : customer) {
			if (cust.getFirstName().equals(firstName)) {
				return cust;
			}
		}
		return null;

	}

	public List<Customer> getAllCustomers() {
//		List<Customer> customer = new ArrayList<Customer>();
//		customer.add(new Customer("teja", "Vangala"));
//		customer.add(new Customer("arvani", "reddy"));
//		customer.add(new Customer("raja", "Van"));
//		customer.add(new Customer("vani", "redy"));
		return customer;

	}

	public boolean deleteCustomer(String lastName) {
		// TODO Auto-generated method stub
		for(Customer cust: customer){
			if(cust.getLastName().equals(lastName)){
				return true;
			}
		}
		return false;
	}

	public Customer updateCustomerName(String firstName) {
		// TODO Auto-generated method stub
	for(Customer cust: customer){
		if(cust.getFirstName().equals(firstName)){
		cust.setFirstName(firstName.toUpperCase());
		return cust;
		}
	}
	return null;
	}

}
