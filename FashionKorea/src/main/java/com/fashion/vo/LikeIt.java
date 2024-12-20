package com.fashion.vo;

public class LikeIt {
	int clothesNo;
	int memberNo;
	public LikeIt() {
		this(-1, -1);
	}
	public LikeIt(int cno, int mno) {
		setClothesNo(cno);
		setMemberNo(mno);
	}
	public int getClothesNo() {
		return clothesNo;
	}
	public void setClothesNo(int clothesNo) {
		this.clothesNo = clothesNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
