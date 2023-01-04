package com.masai.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminid;
	@NotNull
	private String adminname;
	@NotNull
	@Column(unique = true)
	private String adminEmail;
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String city;
	@NotNull
	private int pincode;
	
	
	
	

}
