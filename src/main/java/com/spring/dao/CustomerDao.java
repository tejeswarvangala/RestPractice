package com.spring.dao;

import java.util.List;

import com.spring.customer.model.Customer;

public interface CustomerDao {
	 public Customer saveCustomer(Customer customer);

	    public Customer getcusutomerByfirstName(String firstName);

	    public List<Customer> getAllCustomers();

	    public boolean deleteCustomer(String lastName);
	    public Customer updateCustomerName(String firstName);

}
