package com.fashion.vo;

import lombok.Data;

@Data
public class Order {
	int ordersNo;
	int memberNo; 
	int orTotal;
	String orDate;
	String orStatus;
	int ordersitemNo;
	int clothesNo;
	int quantity;
}
