package com.masai.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Orders;
import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OrderException;
import com.masai.Service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService odd;
	

	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order, @RequestParam String key) throws OrderException, LoginException, CartException, CustomerException
	{
		Orders added = odd.addOrder(order, key);
		
		return new ResponseEntity<Orders>(added,HttpStatus.OK);
	}
	
	@PutMapping("/orderup")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order, @RequestParam String key) throws LoginException,OrderException, CartException
	{
		
		Orders s = odd.updateCustomer(order, key);
		
		return new ResponseEntity<Orders>(s,HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/delt{orderid}")
	public ResponseEntity<Orders> removeorder(@PathVariable("orderid") Integer orderId, @RequestParam String uuid) throws OrderException, LoginException, CartException
	{
		Orders delt = odd.removeOrder(orderId, uuid);
		
		return new ResponseEntity<Orders>(delt, HttpStatus.OK);
	}
	
	@GetMapping("/allorder/{date}")
	public ResponseEntity<List<Orders>> georderbydate(@PathVariable("data") LocalDate date) throws OrderException
	{
		
		   List<Orders> s= odd.viewallOrderByDate(date);
		   
		   return new ResponseEntity<List<Orders>>(s, HttpStatus.OK);
		   
	}
	
	@GetMapping("/vieworder")
     public ResponseEntity<Orders> viewOrder(@RequestParam Integer orderId) throws OrderException, CartException
     
     {
		Orders s = odd.viewOrder(orderId);
		
		return new ResponseEntity<Orders>(s,HttpStatus.OK);
     }
}
