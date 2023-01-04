package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Bean.CurrentuserCustomer;

public interface SessionDao extends JpaRepository<CurrentuserCustomer, Integer> {

	public CurrentuserCustomer findByuuid(String uuid);
	
}
