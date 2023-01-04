package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Bean.Orders;
import com.masai.Exception.OrderException;

public interface Ordersrepo extends JpaRepository<Orders, Integer> {
	

	public List<Orders> findByorderDate(LocalDate date) throws  OrderException;
}
