package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Bean.Admin;
import com.masai.Exception.AdminException;
import com.masai.Repository.Adminrepo;
@Service
public class AdminServiceIMPL implements AdminService {
	
	@Autowired
	private Adminrepo ad;

	@Override
	public Admin RegisterAdmin(Admin add) throws AdminException {
		
		Admin adr = ad.findByUsername(add.getUsername());
		
		if(adr==null) {
			ad.save(add);
		}
		else {
			throw new AdminException("UserName Exists"+adr.getUsername());
		}
		
		return add;
		
		
	}
	


	
	
	
	@Override
	public Admin DeleteAdmin(int id) throws AdminException {
	
	Optional<Admin> del = ad.findById(id);
	
if(del.isPresent()) {
	ad.deleteById(id);
}

else {
	throw new AdminException("Invalid ID for delete Admin");
}
return del.get();


	}
	

	@Override
	public Admin UpdateAdminDetails(Admin up) throws AdminException {
		Optional<Admin> upd = ad.findById(up.getAdminid());
		
		if(upd.isEmpty()) {
			throw new AdminException("Id not found ");
		}else {
			ad.save(up);
		}
		return upd.get();
	}

	@Override
	public Admin SearchAdminByID(int id) throws AdminException {
		
		Optional<Admin> sid = ad.findById(id);
		
		if(sid.isEmpty()) {
			throw new AdminException("No Id Found");
		}else {
			return sid.get();
		}
		
	}

	
	@Override
	public List<Admin> ViewAllAdmin() throws AdminException {
		
		List<Admin> adm = ad.findAll();
		if(adm==null) {
			throw new AdminException("No Admin registered");
		}else {
			return adm;
		}
	}

}
