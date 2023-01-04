package com.masai.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Bean.Cart;
import com.masai.Bean.CurrentuserCustomer;
import com.masai.Bean.Customer;
import com.masai.Bean.Orders;
import com.masai.Bean.Products;
import com.masai.Exception.AddressException;
import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OrderException;
import com.masai.Repository.CartDao;
import com.masai.Repository.Customerrepo;
import com.masai.Repository.Ordersrepo;
import com.masai.Repository.SessionDao;

@Service
public class OrderServiceIMPL implements OrderService {

	 @Autowired
	 private Ordersrepo od;
	 
	 @Autowired
	  private SessionDao sdo;
	
	 @Autowired
	 private Customerrepo cus;
	
	 
	 @Autowired
	 private CartDao cartdao;
	
	
	@Override
	public Orders addOrder(Orders order, String key) throws LoginException, CartException, OrderException, CustomerException {
		
		 CurrentuserCustomer ke = sdo.findByuuid(key);
		    
		    if(ke==null)
		    {
		    	throw new LoginException("You are not Authorized");
		    }
		    else
		    {
		    	
		    	
		    	 Integer customerId =  ke.getUserId();
		    	 
		    	 Optional<Customer>  s = cus.findById(customerId);
		    	 
		    	 com.masai.Bean.Address ss = s.get().getAddress();
		    	 
		    	 Orders curr  = new Orders();
		    	 
		    	 curr.setOrderDate(LocalDate.now());
               curr.setAddress( new com.masai.Bean.Address(ss.getStreetNo(), ss.getCity(), ss.getState(), ss.getCountry(), ss.getPincode()));
              
               curr.setCustomer(s.get());
               curr.setOrderStatus("Order Confrimed");
               
               
               List<Products> list = cartdao.findByCustomer(s.get()).getProducts();
               
               if( list.size() < 1) {
  				 throw new CartException("Add product to the cart first...");
  			 }
               
               
               
               List<Products> product = new ArrayList<Products>();
               
               Double total = 0.0;
//               for(ProductDto s: )
		    	
               
               for(Products proDto : list) {
  				 
  				 product.add(proDto);
  				 
  				 total += (proDto.getPprice() * proDto.getPquantity()) ;
  				 
  			 }
               
               curr.setTotal(total);	
  			 curr.setPoder(product);
  			 
  			 
  			 
             Integer customerI =  ke.getUserId();
		    	 
		    	 Optional<Customer>  t = cus.findById(customerI);
  			 
  			 
  			 Cart customerCart = cartdao.findByCustomer(t.get()) ;
  			 
  			 customerCart.setProducts(new ArrayList<>());
  			 
  			 cartdao.save(customerCart);
  			 
  			 return od.save(curr);
               
               
		    }	
		
	
	}

	@Override
	public Orders updateCustomer(Orders order, String key) throws LoginException, CartException, OrderException {
		
		 CurrentuserCustomer s = sdo.findByuuid(key);
		  
		  if(s==null)
		  {
			  throw new LoginException("Sorry you are not Authorized");
		  }
		  else
		  {
			  Optional<Orders> opt=  od.findById(order.getOrderId());
			  
			  
			  if(opt.isPresent()) {
					return od.save(order);
				}
				else {
					throw new OrderException("Order does not exist");
				}
			  
		  }
			
		
	}
	
	
	

	@Override
	public Orders removeOrder(Integer id, String key) throws LoginException, CartException, OrderException {
CurrentuserCustomer s = sdo.findByuuid(key);
		
		if(s==null)
			{
			       throw new LoginException("You are not Authorized");
			}
		else
			{
			   Optional<Orders> ss = od.findById(id);
			   
			    if(ss.isEmpty())
			    {
			    	throw new  OrderException("You Don't have orders prodcut");
			    }
			    else
			    {
			    	Orders se = ss.get();
			    	od.deleteById(id);
			    	
			    	return se;
			    }
			     
			}
		
		
	}

	@Override
	public Orders viewOrder(Integer id) throws CartException, OrderException {
	
Optional<Orders> s = od.findById(id);
		
		Orders ss = s.get();
		
		
		return ss;	
		
		
		
	}

	@Override
	public List<Orders> viewallOrderByDate(LocalDate date) throws OrderException {
	
		  List<Orders> s = od.findByorderDate(date);
			
			
			return s;
		
		
	}

	@Override
	public List<Orders> orderbylocation(String city) throws OrderException, AddressException {
	
		
		return null;
	}

	@Override
	public List<Orders> viewallbyuserid(String userid) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
