package com.shubh.aws.lambda.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shubh.aws.lambda.domain.Order;

@Repository
public class OrderDao {
	
	public List<Order> buildOrder(){
		List<Order> orderList=new ArrayList<>();
		orderList.add(new Order(101, "Earphone", 1200.0, 1));
		orderList.add(new Order(102, "Mobile", 30000.0, 1));
		orderList.add(new Order(103, "Bike", 95000.0, 1));
		orderList.add(new Order(104, "Laptop", 32000.0, 1));
		return orderList;
	}

}
