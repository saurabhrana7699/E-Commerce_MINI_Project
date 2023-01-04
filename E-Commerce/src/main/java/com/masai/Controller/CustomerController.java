package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Admin;
import com.masai.Bean.Customer;
import com.masai.Exception.AdminException;
import com.masai.Exception.CustomerException;
import com.masai.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	
	@PostMapping("/regcustomer")
	public ResponseEntity<Customer> ResgisteCustomer(@RequestBody Customer adms)throws CustomerException{
		
		Customer add = cs.addCustomer(adms);
		
		return new ResponseEntity<Customer>(add,HttpStatus.ACCEPTED);
}
	
	
	@DeleteMapping("/deletecus/{id}")
	public ResponseEntity<Customer> deletecustomer(@PathVariable("id") Customer id)throws CustomerException{
		
		Customer del = cs.removeCustomer(id);
		
		return new ResponseEntity<Customer>(del,HttpStatus.ACCEPTED);
		
	}
	
	  @PutMapping("/updatecus")
	  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer adms)throws CustomerException{
		  
		  Customer up = cs.updateCust(adms);
		  
		  return new ResponseEntity<Customer>(up,HttpStatus.ACCEPTED);
	 }
	  
	  
	  @GetMapping("/viwadbyidofcus/{id}")
		 public ResponseEntity<Customer> viewbyid(@PathVariable("id") int adms)throws CustomerException{
			  
			  Customer byid = cs.viemCustomer(adms);
			  
			  return new ResponseEntity<Customer>(byid,HttpStatus.ACCEPTED);
			  
		  }
	  
	  
	  

}
