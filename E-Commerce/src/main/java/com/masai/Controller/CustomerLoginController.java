package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.AdminDTO;
import com.masai.Bean.CustomerDTO;
import com.masai.Exception.AdminException;
import com.masai.Exception.CustomerException;
import com.masai.Service.CustomerloginService;

@RestController
public class CustomerLoginController {
	
	@Autowired
	private CustomerloginService loginService;
	
	@PostMapping("/customerlogin")
	public ResponseEntity<String> LoginAdmin(@Valid @org.springframework.web.bind.annotation.RequestBody CustomerDTO admin  )throws CustomerException{
		
		String res = loginService.logincustomer(admin);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	
	@PostMapping("/customerlogout")
	public ResponseEntity<String> LogoutAdmin(@RequestParam("key") String key )throws CustomerException{
		
		String res = loginService.logoutcustomer(key);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	
	

}
