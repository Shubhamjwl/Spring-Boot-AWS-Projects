package com.shubh.aws.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shubh.aws.lambda.dao.OrderDao;
import com.shubh.aws.lambda.domain.Order;

@SpringBootApplication
public class SpringBootAwsLambdaFunctionApplication {

	@Autowired
	private OrderDao orderDao;
	
	@Bean
	public Supplier<List<Order>> makeOrder(){
		
		return ()->orderDao.buildOrder();
	}
	
	@Bean
	public Function<String, List<Order>> findOrderByName(){
		
		return (input)->orderDao.buildOrder().stream().filter(order->order.getOrderName().equals(input))
				.collect(Collectors.toList());
		
	}
	@Bean
	public Function<String, List<Order>> findOrderById(){
		
		return (input)->orderDao.buildOrder().stream().filter(order->order.getOrderId().equals(Integer.valueOf(input)))
				.collect(Collectors.toList());
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsLambdaFunctionApplication.class, args);
	}

}
