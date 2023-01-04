package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Admin;
import com.masai.Exception.AdminException;
import com.masai.Service.AdminService;

@RestController
public class AdminController {	
	@Autowired
	private AdminService ad;
	
	@PostMapping("/regAdmin")
	public ResponseEntity<Admin> ResgisterAdmin(@RequestBody Admin adms)throws AdminException{
		
		Admin add = ad.RegisterAdmin(adms);
		
		return new ResponseEntity<Admin>(add,HttpStatus.ACCEPTED);
		
	}
	
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Admin> deleteAdmin( @PathVariable("id") int adms)throws AdminException{
	    	
		  Admin del = ad.DeleteAdmin(adms);
		  
		  return new ResponseEntity<Admin>(del,HttpStatus.ACCEPTED);
		 
	    }
	  
	  @GetMapping("/viewallAdmin")
	  public ResponseEntity<List<Admin>> viewAllAdmin()throws AdminException{
		  
		  List<Admin> vie = ad.ViewAllAdmin();
		  
		  return new ResponseEntity<List<Admin>>(vie,HttpStatus.ACCEPTED);
		  
	  }
	  
	  @GetMapping("/viwadbyid/{id}")
	 public ResponseEntity<Admin> viewbyid(@PathVariable("id") int adms)throws AdminException{
		  
		  Admin byid = ad.SearchAdminByID(adms);
		  
		  return new ResponseEntity<Admin>(byid,HttpStatus.ACCEPTED);
		  
	  }
	  
	  
	  @PutMapping("/update")
	  public ResponseEntity<Admin> updateAdmin(@RequestBody Admin adms)throws AdminException{
		  
		  Admin up = ad.UpdateAdminDetails(adms);
		  
		  return new ResponseEntity<Admin>(up,HttpStatus.ACCEPTED);
		  
		  
	  }
	
	
}

   







