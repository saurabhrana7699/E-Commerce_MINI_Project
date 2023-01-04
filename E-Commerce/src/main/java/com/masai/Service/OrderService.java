package com.masai.Service;

import java.time.LocalDate;
import java.util.List;

import com.masai.Bean.Orders;
import com.masai.Exception.AddressException;
import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OrderException;

public interface OrderService {

public  Orders addOrder(Orders order,String key) throws LoginException, CartException, OrderException ,CustomerException;
	
	public  Orders updateCustomer(Orders order,String key) throws LoginException, CartException, OrderException;
	
	public  Orders removeOrder(Integer id,String key) throws LoginException, CartException, OrderException;

	public  Orders viewOrder(Integer id) throws CartException, OrderException;
	
	public List<Orders> viewallOrderByDate(LocalDate date) throws OrderException;
	
	public List<Orders> orderbylocation(String city) throws OrderException, AddressException;
	
	public List<Orders> viewallbyuserid(String userid) throws OrderException;

}
