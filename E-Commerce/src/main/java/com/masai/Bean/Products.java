package com.masai.Bean;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Products {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
//	@Size(min =3, max = 25, message = "Product name should contain min 3 charater")
	private String pname;
	
//	@Min(value = 1, message = "Please Enter the valid  price")
	private int pprice;
	
	@Embedded
	private Category pcategory;
	
//	@Min(value = 1, message = "Please Enter the valid Quantity")
	private int pquantity;
	
	
	
	
}
