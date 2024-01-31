package com.bankingsystem.bankdeal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortAndFilterModel {
	@JsonProperty("sortOrder")
	private String sortOrder;
	@JsonProperty("sortDirection")
	private int sortDirection;
	@JsonProperty("searchText")
	private String searchText;
	@JsonProperty("pageSize")
	private int pageSize;
	@JsonProperty("pageIndex")
	private int pageIndex;
	
	public SortAndFilterModel(){
		sortOrder = "name";
		sortDirection = 0;
		searchText = null;
		pageSize = 30;
		pageIndex = 1;
	}
	
	public SortAndFilterModel(String sortOrder,int sortDirection,String searchText, int pageSize, int pageIndex) {
		this.sortOrder = sortOrder;
		this.sortDirection = sortDirection;
		this.searchText = searchText;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}
	
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public String getSortOrder() {
		return this.sortOrder;
	}
	
	public void setSortDirection(int sortDirection) {
		this.sortDirection = sortDirection;
	}
	
	public int getSortDirection() {
		return this.sortDirection;
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	public String getSearchText() {
		return this.searchText;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return this.pageSize;
	}
	
	public void setPageIndex(int pageIndex){
		this.pageIndex = pageIndex;
	}
	
	public int getPageIndex() {
		return this.pageIndex;
	}
}
