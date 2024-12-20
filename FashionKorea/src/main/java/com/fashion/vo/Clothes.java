package com.fashion.vo;

public class Clothes {
	int clothesNo;
	int categoryNo;
	String name;
	int price;
	String color;
	String clothesSize;
	String image;
	String category;
	String about;
	String imageDetail;
	public Clothes() {
		this(-1, -1, "", 0, "", "", "", "", "", "");
	}
	public Clothes(int clno, int cano, String name, int price, String color, String clsize, String img, String category, String about, String imgdetail) {
		setClothesNo(clno);
		setCategoryNo(cano);
		setName(name);
		setPrice(price);
		setColor(color);
		setClothesSize(clsize);
		setImage(img);
		setCategory(category);
		setAbout(about);
		setImageDetail(imgdetail);
	}
	public int getClothesNo() {
		return clothesNo;
	}
	public void setClothesNo(int clothesNo) {
		this.clothesNo = clothesNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getClothesSize() {
		return clothesSize;
	}
	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getImageDetail() {
		return imageDetail;
	}
	public void setImageDetail(String imageDetail) {
		this.imageDetail = imageDetail;
	}
}
