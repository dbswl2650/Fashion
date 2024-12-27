<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<%
String loginInfo = (String) session.getAttribute("member_id");
MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
%>
<form class="w3-container w3-card-4" action="deleteMember.ko" method="post">
    <div>
    	<h1>회원정보 수정</h1>
        <label>ID 확인</label>
        <input class="w3-input" type="text" name="id" value="${ memberInfo.getMemberId() }" readonly="readonly">
    </div>
    <div>
        <label>PW 확인</label>
        <input class="w3-input" type="password" name="pw" required="required">
        <input class="w3-input" type="hidden" name="number" required="required">
        <input class="w3-input" type="hidden" name="name" required="required">
        <input class="w3-input" type="hidden" name="mail" required="required">
        <input class="w3-input" type="hidden" name="phone" required="required">
        <input class="w3-input" type="hidden" name="age" required="required">
        <input class="w3-input" type="hidden" name="address" required="required">
    </div>
    <button type="submit" class="w3-button">확인</button>
    <button type="submit" class="w3-button" onclick= "myPage.ko">취소</button>
</form>
<jsp:include page="./footer.jsp"></jsp:include>