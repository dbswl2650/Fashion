<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<%
	String loginInfo = (String) session.getAttribute("member_id");
    MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
%>
<form action="upDateMember.ko" method="post">
    <input type="text" name="memberId" value="${ memberInfo.memberId }" readonly>
    <input type="text" name="memberName" value="${ memberInfo.memberName }" required>
    <input type="email" name="memberMail" value="${ memberInfo.memberMail }" required>
    <input type="text" name="memberPhone" value="${ memberInfo.memberPhone }" required>
    <input type="text" name="memberAdd" value="${ memberInfo.memberAdd }" required>
    <input type="password" name="memberPw">
    <input type="password" name="confirmPw">
    <button type="submit">수정하기</button>
</form>
<jsp:include page="./footer.jsp"></jsp:include>