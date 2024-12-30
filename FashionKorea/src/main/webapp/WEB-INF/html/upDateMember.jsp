<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<%	
	
	String loginInfo = (String) session.getAttribute("member_id");
    MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
  	
%>

<form action="upDateMember.ko" method="post">
    <div>
        <label for="memberId">아이디:</label>
        <input type="text" id="member_id" name="member_id" value="${memberInfo.memberId}" readonly>
    </div>
    <div>
        <label for="memberName">이름:</label>
        <input type="text" id="member_name" name="member_name" value="${memberInfo.memberName}" required>
    </div>
    <div>
        <label for="memberAge">생년월일:</label>
        <input type="text" id="member_age" name="member_age" value="${memberInfo.memberAge}" required>
    </div>
    <div>
        <label for="memberMail">이메일:</label>
        <input type="email" id="member_mail" name="member_mail" value="${memberInfo.memberMail}" required>
    </div>
    <div>
        <label for="memberPhone">휴대폰번호:</label>
        <input type="text" id="member_phone" name="member_phone" value="${memberInfo.memberPhone}" required>
    </div>
    <div>
        <label for="memberAdd">주소:</label>
        <input type="text" id="member_add" name="member_add" value="${memberInfo.memberAdd}" required>
    </div>
    <div>
        <label for="memberPw">새 비밀번호:</label>
        <input type="password" id="member_pw" name="member_pw">
    </div>
    <div>
        <label for="confirmPw">새 비밀번호 확인:</label>
        <input type="password" id="confirmPw" name="confirmPw">
    </div>
    <button type="submit">수정</button>
</form>
<jsp:include page="./footer.jsp"></jsp:include>