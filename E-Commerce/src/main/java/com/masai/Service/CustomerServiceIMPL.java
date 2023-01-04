package com.masai.Service;

import java.util.Optional;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Bean.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Repository.Customerrepo;

@Service
public class CustomerServiceIMPL implements CustomerService {
	
	@Autowired
	private Customerrepo cs;
	
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
	
		Customer add = cs.save(customer);
		
		if(add==null) {
			throw new CustomerException("Data not found for add ");
		}
		else {
			return add;
		}
		
		
	}

	@Override
	public Customer updateCust(Customer customer) throws CustomerException {
		
		Optional<Customer> up = cs.findById(customer.getCustomerid());
		
		if(up.isEmpty()) {
			throw new CustomerException("Incorrect ID");
		}
		else {
			return up.get();
		}
		
	}

	@Override
	public Customer removeCustomer(Customer id) throws CustomerException {
	
		Optional<Customer> rc = cs.findById(id.getCustomerid());
		
		if(rc.isEmpty()) {
		cs.delete(id);
			
		}
		else {
			throw new CustomerException("Incorrect ID");
		}
	return rc.get();
		
	}

	@Override
	public Customer viemCustomer(Integer cusInteger) throws CustomerException {

		Optional<Customer> vc = cs.findById(cusInteger);
		
		if(vc.isPresent()) {
			return vc.get();
		}
		else {
			throw new CustomerException("Incorrect ID");
		}
	}

}
