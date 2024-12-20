package vo;

public class Category {
	int category_no;
	String sex;
	String type;
	public Category() {
		this(-1, "", "");
	}
	public Category(int cno, String sex, String type) {
		setCategory_no(cno);
		setSex(sex);
		setType(type);
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
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
