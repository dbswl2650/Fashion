package com.fashion.vo;

import lombok.Data;

@Data
public class MemberVO {
    private int memberNo;        // 번호
    private String memberName;   // 이름
    private String memberId;     // 아이디
    private String memberPw;     // 비밀번호
    private String memberMail;   // 이메일
    private String memberPhone;  // 전화번호
    private String memberAge;    // 생년월일
    private String memberAdd;    // 주소
}
