package com.masai.Service;



import com.masai.Bean.Customer;
import com.masai.Exception.CustomerException;


public interface CustomerService {

	
	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCust(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Customer id) throws CustomerException;
	
	public Customer viemCustomer(Integer cusInteger) throws CustomerException;
}
