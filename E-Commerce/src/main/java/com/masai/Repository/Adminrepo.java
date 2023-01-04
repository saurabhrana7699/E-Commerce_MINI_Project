package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Bean.Admin;
import com.masai.Exception.AdminException;
@Repository
public interface Adminrepo extends JpaRepository<Admin, Integer> {
	
public Admin findByUsername(String username)throws AdminException;
	
}
