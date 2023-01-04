package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Admin;
import com.masai.Bean.Customer;
import com.masai.Exception.AdminException;
import com.masai.Exception.CustomerException;

@Repository
public interface Customerrepo extends JpaRepository<Customer, Integer> {

	public Customer findByUsername(String username)throws CustomerException;
	
	public Customer findByemail(String email);
	public Optional<Customer> findBymobilenumber(String mobileNumber) throws CustomerException;
	
}
