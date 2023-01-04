package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Bean.Category;
import com.masai.Bean.Products;
import com.masai.Exception.ProductException;
import com.masai.Repository.Productrepo;

@Service
public class ProductServiceIMPL implements PrductService{
	
	@Autowired
	private Productrepo pr;

	@Override
	public Products addProduct(Products product) throws ProductException {
	
		Products add = pr.save(product);
		
		if(add == null) {
			throw new ProductException("Please Add Actual Product");
		}
		else {
			return product;
		}
		
	
	}

	@Override
	public List<Products> viewAllproduct() throws ProductException {
		
		List<Products> vi = pr.findAll();
	if(vi.isEmpty()) {
		throw new ProductException("No Product in the Database");
	}
	else {
		return vi;
	}
	}

	@Override
	public Products updateProduct(Products product) throws ProductException {
	
		Optional<Products> up = pr.findById(product.getPid());
		
		if(up.isEmpty()) {
			throw new ProductException("Product Id not found for update");
		}
		
		else {
			return product;
		}
	}

	@Override
	public Products viewProduct(Integer id) throws ProductException {
		
	Optional<Products> vp = pr.findById(id);
	if(vp.isEmpty()) {
		throw new ProductException("Product Id not found ");
	}
	else {
		return vp.get();
	}
	
	}


	@Override
	public Products removeProduct(Integer pid) throws ProductException {
	
	Optional<Products> rm = pr.findById(pid);
	
	if(rm.isEmpty()) {
		throw new ProductException("Unknown Prodcut ID ");
	}
	else {
		return rm.get();
	}
	
		
	}

	@Override
	public List<Products> viewProudctbyCategory(String cname) throws ProductException {
	
		List<Products> pmr = pr.viewbyCategoryName(cname);
		
		if(pmr.isEmpty()) {
			throw new ProductException("Unknown Category Name ");
		}
		else {
			return pmr;
		}
		
	
	}
	
	

}
