package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Bean.CurrentUserSession;
import com.masai.Bean.CurrentuserCustomer;
import com.masai.Bean.Customer;
import com.masai.Bean.CustomerDTO;
import com.masai.Exception.AdminException;
import com.masai.Exception.CustomerException;
import com.masai.Repository.CustomerLogin;
import com.masai.Repository.Customerrepo;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceIMPL implements CustomerloginService {

	@Autowired
	private Customerrepo admindao;
	
	@Autowired
	private CustomerLogin  currUserSession;

	@Override
	public String logincustomer(CustomerDTO admin) throws CustomerException {
		
		Customer existingUser = admindao.findByUsername(admin.getUsername());
		if (existingUser == null)
			throw new CustomerException("Invalid credentials. Username does not exist " + admin.getUsername());
	
		
		Optional<CurrentuserCustomer> validCustomerSessionOpt = currUserSession.findById(existingUser.getCustomerid());
		
		if (validCustomerSessionOpt.isPresent()) {
	
			throw new CustomerException("User already Logged In with this username");
	
		}
		
		if (existingUser.getPassword().equals(admin.getPassword())) {
			
			String key = RandomString.make(6);
	
			Boolean isAdmin = true;
	
			CurrentuserCustomer cs = new CurrentuserCustomer(existingUser.getCustomerid(), key, isAdmin, LocalDateTime.now());
            
			currUserSession.save(cs);
	
			return cs.toString();
			
		} else
			throw new CustomerException("Please Enter a valid password");
		
		
	}
	
	

	@Override
	public String logoutcustomer(String key) throws CustomerException {
		
		CurrentuserCustomer validCustomerSession = currUserSession.findByUuid(key);

		if (validCustomerSession == null) {
			throw new CustomerException("User Not Logged In with this username");

		}
		currUserSession.delete(validCustomerSession);

		return "Logged Out !";
		
	}
	
	
	
	
}
