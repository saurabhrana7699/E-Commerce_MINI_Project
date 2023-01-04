package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Bean.CurrentUserSession;
import com.masai.Bean.CurrentuserCustomer;

@Repository
public interface CustomerLogin  extends JpaRepository<CurrentuserCustomer, Integer>{

public Optional<CurrentuserCustomer>findByuuid(String uuid);
	
	public CurrentuserCustomer findByUuid(String uuid);
	
	
}
