package vo;

public class Clothes {
	int clothes_no;
	int category_no;
	String name;
	int price;
	String color;
	String clothes_size;
	String image;
	String category;
	String about;
	String image_detail;
	public Clothes() {
		this(-1, -1, "", 0, "", "", "", "", "", "");
	}
	public Clothes(int clno, int cano, String name, int price, String color, String clsize, String img, String category, String about, String imgdetail) {
		setClothes_no(clno);
		setCategory_no(cano);
		setName(name);
		setPrice(price);
		setColor(color);
		setClothes_size(clsize);
		setImage(img);
		setCategory(category);
		setAbout(about);
		setImage_detail(imgdetail);
	}
	public int getClothes_no() {
		return clothes_no;
	}
	public void setClothes_no(int clothes_no) {
		this.clothes_no = clothes_no;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
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
	public String getClothes_size() {
		return clothes_size;
	}
	public void setClothes_size(String clothes_size) {
		this.clothes_size = clothes_size;
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
	public String getImage_detail() {
		return image_detail;
	}
	public void setImage_detail(String image_detail) {
		this.image_detail = image_detail;
	}
}
