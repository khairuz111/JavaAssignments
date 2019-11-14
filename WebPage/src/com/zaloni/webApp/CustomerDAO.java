package com.zaloni.webApp;

public interface CustomerDAO {

	public int insertCustomer(Customer c);
	
	public Customer getCustomer(String username, String password);
	
	public int updateCustomer(Customer c);
	public Customer searchCustomer(String name);
	
}
