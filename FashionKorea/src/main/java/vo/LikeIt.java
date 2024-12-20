package vo;

public class LikeIt {
	int clothes_no;
	int member_no;
	public LikeIt() {
		this(-1, -1);
	}
	public LikeIt(int cno, int mno) {
		setClothes_no(cno);
		setMember_no(mno);
	}
	public int getClothes_no() {
		return clothes_no;
	}
	public void setClothes_no(int clothes_no) {
		this.clothes_no = clothes_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
}
