package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Bean.CurrentUserSession;
@Repository
public interface LoginRepo extends JpaRepository<CurrentUserSession, Integer> {
	
public Optional<CurrentUserSession>findByuuid(String uuid);
	
	public CurrentUserSession findByUuid(String uuid);

}
