package com.fashion.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Review {

	int reviewNo;
	int memberNo;
	int clothesNo;
	String type;
	String comments;
	Date wdateDate;
	String score;
	String title;
	String image;
	
	String memberName; 
}


