package com.bankingsystem.bankdeal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingsystem.bankdeal.Interfaces.CustomerService;
import com.bankingsystem.bankdeal.model.Customer;
import com.bankingsystem.bankdeal.model.SortAndFilterModel;
import com.bankingsystem.bankdeal.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Override
	public List<Customer> getCustomers(SortAndFilterModel filters) {
		List<Customer> customerList = null; 
		try {
			
			customerList = customerRepo.retrieve(filters);
			
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		try {
			customerRepo.create(customer);
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			customerRepo.update(customer);
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void deleteCustomer(String id) {
		try {
			customerRepo.delete(id);
		}catch(Exception ex) {
			throw ex;
		}
	}

}
