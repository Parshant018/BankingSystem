package com.bankingsystem.bankdeal.Interfaces;

import java.util.List;
import com.bankingsystem.bankdeal.model.Customer;
import com.bankingsystem.bankdeal.model.SortAndFilterModel;

public interface CustomerService {
	
	public List<Customer> getCustomers(SortAndFilterModel filters);
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(String id);
}
