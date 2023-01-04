package com.masai.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {


	
	private int cid;
	
	
//	@NotNull(message = "Country cannot be null")
//	@NotBlank(message = "Country cannot be blank")
//	@NotEmpty(message = "Country cannot be Empty")
	private String cname;
	
	
}
