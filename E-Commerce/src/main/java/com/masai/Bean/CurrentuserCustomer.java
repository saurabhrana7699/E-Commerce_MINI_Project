package com.masai.Bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrentuserCustomer {

	@Id
	private Integer userId;

	private String uuid;

	private Boolean admin;

	private LocalDateTime localDateTime;
	
}
