package com.masai.Bean;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	
	private String firstname;
	
	private String lastname;
	
	 private String mobilenumber;
	 
	    private String email;
	    
	    private String username;
	    
	    private String password;
	
	    @Embedded
	    private Address address;

}
