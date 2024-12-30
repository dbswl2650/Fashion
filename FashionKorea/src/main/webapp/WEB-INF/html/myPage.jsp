<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<%
String loginInfo = (String) session.getAttribute("member_id");
MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
if (loginInfo != null) {
%>
<form action = "upDateMyPageCheck.ko" method = "post">
 <section class="row m-3" style="min-height: 500px">
 <div class="body center">
 	<h2 class="m-4">나의 프로필</h2>
    <br>
	<span class="material-symbols-outlined">
		person
	</span>
	<div class="form-group">
		<label for="Id">* ID :</label> 
			<input type="text" class="form-control" id="Id" name="Id"
			value="${ memberInfo.getMemberId() }" readonly><br> 
		<label for="Name">* Name :</label> 
			<input type="text" class="form-control" id="Name" name="Name"
			value="${ memberInfo.getMemberName() }"><br> 
		<label for="email"> Email :</label> 
			<input type="email" class="form-control" id="Mail" name="Mail"
		 	value="${ memberInfo.getMemberMail() }"><br> 
		<label for="phone"> Phone :</label> 
			<input type="tel" class="form-control" id="phone" name="phone"
			value="${ memberInfo.getMemberPhone()}"><br> 
		<label for="address"> Address :</label> 
			<input type="text" class="form-control" id="address" name="address"
			value="${ memberInfo.getMemberAdd() }">
		
		<br>
     <div class="btns" align="center">
    	<button type="submit" class="btn btn-primary" onclick="upDateMyPageCheck.ko">수정하기</button>
        <button type="button" class="btn btn-danger">회원탈퇴</button>
     </div>
	</div>
  </div>
</section>
</form>
<%
} else {
%>
<p>회원 정보를 불러오는 데 실패했습니다.</p>
<%
}
%>
<jsp:include page="./footer.jsp"></jsp:include>