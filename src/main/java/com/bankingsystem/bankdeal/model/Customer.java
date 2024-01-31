package com.bankingsystem.bankdeal.model;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table
@NamedStoredProcedureQueries(
{@NamedStoredProcedureQuery(
		name="getCustomers", 
		procedureName = "usp_retrieveUser",
		resultClasses = Customer.class,
		parameters = {
				@StoredProcedureParameter(mode=ParameterMode.IN,name="sortOrder",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="sortDirection",type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="searchText",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="pageSize",type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="pageIndex",type=Integer.class)
				}
		),
@NamedStoredProcedureQuery(
		name="createCustomer",
		procedureName = "usp_createCustomer",
		parameters = {
				@StoredProcedureParameter(mode=ParameterMode.IN,name="name",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="email",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="phone",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="balance",type=String.class),
				}
		),
@NamedStoredProcedureQuery(
		name="updateCustomer",
		procedureName = "usp_updateUser",
		parameters = {
				@StoredProcedureParameter(mode=ParameterMode.IN,name="id",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="name",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="email",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="phone",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="balance",type=String.class),
				}
		),
@NamedStoredProcedureQuery(
		name = "deleteCustomer",
		procedureName = "usp_deleteuser",
		parameters = {
				@StoredProcedureParameter(mode=ParameterMode.IN,name="id",type=String.class)
				}
		)
})
public class Customer {
	@Id
	private String id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String email;
	@JsonProperty
	private String phone;
	@JsonProperty
	private String balance;
	@JsonProperty
	private String modified_on;
	
	public Customer(String id, String name, String email,String phone, String balance, String modifiedOn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.modified_on = modifiedOn;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBalance() {
		return this.balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public String getModifiedon() {
		return this.modified_on;
	}
	
	public void setModifiedOn(String modifiedOn) {
		this.modified_on = modifiedOn;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
