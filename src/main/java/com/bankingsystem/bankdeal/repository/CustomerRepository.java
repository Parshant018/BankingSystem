package com.bankingsystem.bankdeal.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankingsystem.bankdeal.model.Customer;
import com.bankingsystem.bankdeal.model.SortAndFilterModel;
import com.bankingsystem.bankdeal.model.spNames;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class CustomerRepository {
	
	@Autowired
	private EntityManager entityManager;
	private StoredProcedureQuery query;
	
	@SuppressWarnings("unchecked")
	public List<Customer> retrieve(SortAndFilterModel filters){
		List<Customer> customerList = null;
		try {
		query = entityManager.createNamedStoredProcedureQuery(spNames.getCustomers);
		addFilterParameters(filters); 
		customerList = query.getResultList();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return customerList;
	}
	
	public void create(Customer customer)
	{
		try {
		entityManager.clear();
		query = entityManager.createNamedStoredProcedureQuery(spNames.createCustomer);
		addCustomerDetails(customer);
		query.execute();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void update(Customer customer)
	{
		try {
		query = entityManager.createNamedStoredProcedureQuery(spNames.updateCustomer);
		addCustomerDetails(customer);
		query.setParameter("id",customer.getId());
		query.execute();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void delete(String id)
	{
		try {
		query = entityManager.createNamedStoredProcedureQuery(spNames.deleteCustomer);
		query.setParameter("id",id);
		query.execute();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	private void addFilterParameters(SortAndFilterModel filters)
	{
		query.setParameter("sortOrder",filters.getSortOrder());
		query.setParameter("sortDirection",filters.getSortDirection());
		query.setParameter("searchText",filters.getSearchText());
		query.setParameter("pageSize",filters.getPageSize());
		query.setParameter("pageIndex",filters.getPageIndex());
	}
	
	private void addCustomerDetails(Customer customer)
	{
		if(customer.getId()!=null)
		query.setParameter("id",customer.getId());
		query.setParameter("name",customer.getName());
		query.setParameter("email",customer.getEmail());
		query.setParameter("phone",customer.getPhone());
		query.setParameter("balance",customer.getBalance());
	}
}
