package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.customer.model.Customer;
import com.spring.dao.CustomerDao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "end point for different operations on customer")
@RequestMapping("/Customers")
public class RestPracticeController {
	@Autowired
	private CustomerDao customerDao;

	@GetMapping("/health")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Checks API health")
	public String checkHealth() {
		return "API Up and Running.";
	}
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "returns all customers", notes = "Return the firstName and lastname of the customers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerDao.getAllCustomers();
		return customers;
	}

	@GetMapping("Customers/{firstName}")
	@ApiOperation(value = "returns customers with firstname", notes = "Return the customers details with firstName")
	public ResponseEntity<Customer> getcusutomerByfirstName(@PathVariable String firstName) {
		Customer customer = customerDao.getcusutomerByfirstName(firstName);
		ResponseEntity<Customer> response;
		if (customer != null) {
			response = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@PutMapping("/Customers/{firstName}")
	@ApiOperation(value = "Updates customers firstname with uppercase", notes = "updates the customers details with uppercase")
	public ResponseEntity<Customer> updateCustomerName(@PathVariable String firstName) {
		Customer customer = customerDao.updateCustomerName(firstName);
		ResponseEntity<Customer> response;
		if (customer != null) {
			response = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return response;

	}

	@DeleteMapping("/Customers/{lastName}")
	@ApiOperation(value = "Deletes customers with Latname", notes = "delete operation is performed on customer by lastName")
	public boolean deleteCustomer(String lastName) {
		return customerDao.deleteCustomer(lastName);

	}

	@PostMapping("/Customers")
	@ApiOperation(value = " new customers is added", notes = "A new customer is added to that list")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerDao.saveCustomer(customer);

	}

}
