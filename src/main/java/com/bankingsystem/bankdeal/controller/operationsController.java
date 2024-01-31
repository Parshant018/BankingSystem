package com.bankingsystem.bankdeal.controller;

import com.bankingsystem.bankdeal.Interfaces.CustomerService;
import com.bankingsystem.bankdeal.model.Customer;
import com.bankingsystem.bankdeal.model.SortAndFilterModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class operationsController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(@RequestBody SortAndFilterModel filters)
	{
		List<Customer> customerList = null;
		try {
		customerList = this.customerService.getCustomers(filters);
		}catch(Exception e)
		{
			throw e;
		}
		return ResponseEntity.ok(customerList);
	}
	
	@PostMapping("/customer/create")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
	{
		this.customerService.addCustomer(customer);
		return ResponseEntity.ok("Created Successfully");
	}
	
	@PutMapping("/customer/update")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer)
	{
		this.customerService.updateCustomer(customer);
		return ResponseEntity.ok("Success");
	}
	
	@DeleteMapping("/customer/delete/{id}")
	public String delete(@PathVariable String id)
	{
		this.customerService.deleteCustomer(id);
		return "deleted";
	}
}
