package com.masai.Service;

import javax.validation.constraints.NotNull;

import com.masai.Bean.Admin;
import com.masai.Bean.AdminDTO;
import com.masai.Exception.AdminException;

public interface LoginService {
	 public String loginAdmin(AdminDTO admin) throws AdminException;
		
		public String logoutAdmin(String key) throws AdminException;
		
		public Admin searchbyusername( @NotNull String us)throws AdminException;
}
