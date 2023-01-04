package com.masai.Service;

import javax.validation.constraints.NotNull;

import com.masai.Bean.Admin;
import com.masai.Bean.AdminDTO;
import com.masai.Bean.CustomerDTO;
import com.masai.Exception.AdminException;
import com.masai.Exception.CustomerException;

public interface CustomerloginService {

	 public String logincustomer(CustomerDTO admin) throws CustomerException;
		
		public String logoutcustomer(String key) throws CustomerException;
		
		
}

