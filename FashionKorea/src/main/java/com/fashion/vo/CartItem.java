package com.fashion.vo;

import lombok.Data;

@Data
public class CartItem {
	String image;
	int price;
	String name;
	int quantity;
	int totalPrice;
}
