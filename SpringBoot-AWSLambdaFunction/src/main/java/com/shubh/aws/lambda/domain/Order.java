package com.shubh.aws.lambda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	private Integer orderId;
	private String orderName;
	private Double price;
	private Integer quantity;

}
