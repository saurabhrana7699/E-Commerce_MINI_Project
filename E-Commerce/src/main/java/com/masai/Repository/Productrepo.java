package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Bean.Category;
import com.masai.Bean.Products;
import com.masai.Exception.ProductException;

@Repository
public interface Productrepo extends JpaRepository<Products, Integer> {
	
	@Query("select p from Products p where p.pcategory.cname=?1")
	public List<Products> viewbyCategoryName(String cname);

}
