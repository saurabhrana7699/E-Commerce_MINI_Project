package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Bean.Cart;
import com.masai.Bean.Customer;
import com.masai.Exception.CustomerException;

public interface CartDao extends JpaRepository<Cart, Integer>{

public Cart findByCustomer(Customer customer) throws CustomerException;
	
	
	@Query("select c from Cart c where c.customer.customerid=?1")
	public Cart getCart(Integer custId);
}
