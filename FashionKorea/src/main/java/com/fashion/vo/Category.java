package com.fashion.vo;

public class Category {
	int categoryNo;
	String sex;
	String type;
	public Category() {
		this(-1, "", "");
	}
	public Category(int cno, String sex, String type) {
		setCategoryNo(cno);
		setSex(sex);
		setType(type);
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
