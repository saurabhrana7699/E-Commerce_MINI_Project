package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Admin;
import com.masai.Bean.Category;
import com.masai.Bean.Products;
import com.masai.Exception.AdminException;
import com.masai.Exception.ProductException;
import com.masai.Service.PrductService;

@RestController
public class ProductController {
	
	@Autowired
	private PrductService prode;
	
	
	@PostMapping("/addproduct")
	public ResponseEntity<Products> addproductHandler(@Valid @RequestBody Products prod)throws ProductException{
		
		   Products s = prode.addProduct(prod);
		   
		   return new ResponseEntity<Products>(s, HttpStatus.OK);
	}
	
	
	@GetMapping("/allproduct")
	public ResponseEntity<List<Products>> getallprod()throws ProductException
	{
		List<Products> allpr = prode.viewAllproduct();
		
		return new ResponseEntity<List<Products>>(allpr,HttpStatus.OK);
	}
	
	@DeleteMapping("/p/{pid}")
	public ResponseEntity<Products> deletProdouct(@PathVariable("pid")Integer pr) throws ProductException
	{
		Products s = prode.removeProduct(pr);
		
		return new ResponseEntity<Products>(s, HttpStatus.OK);
	}
	
	@PutMapping("/updateprod")
	public ResponseEntity<Products> updateproducts(@RequestBody Products pro)throws ProductException{
		
		Products ps = prode.updateProduct(pro);
		
		return new ResponseEntity<Products>(ps,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Products> getproductsbyid(@PathVariable("id") Integer i)throws ProductException{

		Products pp = prode.viewProduct(i);
		
		return new ResponseEntity<Products>(pp,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/searchbycat/{cat}")
	public ResponseEntity<List<Products>>  searchbycategory(@PathVariable("cat") String name)throws ProductException{
		
		List<Products> ss = prode.viewProudctbyCategory(name);
		
		return new ResponseEntity<List<Products>>(ss,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	

}
