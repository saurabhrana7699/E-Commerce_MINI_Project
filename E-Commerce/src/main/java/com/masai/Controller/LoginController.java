package com.masai.Controller;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Admin;
import com.masai.Bean.AdminDTO;
import com.masai.Exception.AdminException;
import com.masai.Service.LoginService;



@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/adminlogin")
	public ResponseEntity<String> LoginAdmin(@Valid @org.springframework.web.bind.annotation.RequestBody AdminDTO admin  )throws AdminException{
		
		String res = loginService.loginAdmin(admin);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	
	@PostMapping("/adminlogout")
	public ResponseEntity<String> LogoutAdmin(@RequestParam("key") String key )throws AdminException{
		
		String res = loginService.logoutAdmin(key);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	
	@GetMapping("/findbyusername/{id}")
	public ResponseEntity<Admin> userfind(@PathVariable("id") String ad)throws AdminException{
		
		Admin adr = loginService.searchbyusername(ad);
		return new ResponseEntity<>(adr,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
	


}
