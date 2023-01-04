package com.masai.Service;

import java.util.List;

import com.masai.Bean.Category;
import com.masai.Bean.Products;
import com.masai.Exception.ProductException;

public interface PrductService {

	
	public Products addProduct(Products product) throws ProductException;
	
	public List<Products> viewAllproduct() throws ProductException;
	
	public Products updateProduct(Products product) throws ProductException;
	
	public Products viewProduct(Integer id) throws ProductException;
	
	public List<Products> viewProudctbyCategory(String cname) throws ProductException;

	public Products removeProduct(Integer pid) throws ProductException;
	
	
	
}
