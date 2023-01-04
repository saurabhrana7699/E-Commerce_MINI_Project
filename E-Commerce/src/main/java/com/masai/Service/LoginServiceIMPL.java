package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Bean.Admin;
import com.masai.Bean.AdminDTO;
import com.masai.Bean.CurrentUserSession;
import com.masai.Exception.AdminException;
import com.masai.Repository.Adminrepo;
import com.masai.Repository.LoginRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceIMPL implements LoginService{
	@Autowired
	private Adminrepo admindao;
	
	@Autowired
	private LoginRepo currUserSession;

	@Override
	public String loginAdmin(AdminDTO admin) throws AdminException {
		Admin existingUser = admindao.findByUsername(admin.getUsername());
		
		if (existingUser == null)
			throw new AdminException("Invalid credentials. Username does not exist " + admin.getUsername());
	
		Optional<CurrentUserSession> validCustomerSessionOpt = currUserSession.findById(existingUser.getAdminid());
	
		if (validCustomerSessionOpt.isPresent()) {
	
			throw new AdminException("User already Logged In with this username");
	
		}
	
		if (existingUser.getPassword().equals(admin.getPassword())) {
	
			String key = RandomString.make(6);
	
			Boolean isAdmin = true;
	
			CurrentUserSession cs = new CurrentUserSession(existingUser.getAdminid(), key, isAdmin, LocalDateTime.now());

			currUserSession.save(cs);
	
			return cs.toString();
		} else
			throw new AdminException("Please Enter a valid password");
	}

	@Override
	public String logoutAdmin(String key) throws AdminException {
		CurrentUserSession validCustomerSession = currUserSession.findByUuid(key);

		if (validCustomerSession == null) {
			throw new AdminException("User Not Logged In with this username");

		}
		currUserSession.delete(validCustomerSession);

		return "Logged Out !";
	}

	
	
	
	
	@Override
	public Admin searchbyusername(String us) throws AdminException {
		 
		Admin ad = admindao.findByUsername(us);
		
		
		
		if(ad==null) {
			throw new AdminException("galatnaam");
		}
		else {
			return ad;
		}
	}

	}


