package com.masai.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	 private LocalDate orderDate;
	    
	    
	    private String orderStatus;
	    
	    
	    private Double total;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    private Customer customer;
	    
	    
	    @ElementCollection
	    private List<Products> poder = new ArrayList<>();
	    
	    
	    @Embedded
	    private Address address;


}
