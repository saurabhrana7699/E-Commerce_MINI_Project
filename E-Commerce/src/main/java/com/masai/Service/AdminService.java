package com.masai.Service;

import java.util.List;

import com.masai.Bean.Admin;
import com.masai.Exception.AdminException;



public interface AdminService  {
	
	public Admin RegisterAdmin(Admin add)throws AdminException;
	public Admin DeleteAdmin(int id)throws AdminException;
	public Admin UpdateAdminDetails(Admin up)throws AdminException;
	public Admin SearchAdminByID(int id)throws AdminException;
	public List<Admin>  ViewAllAdmin()throws AdminException;

}
