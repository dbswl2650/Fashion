<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<jsp:include page="./sidebar.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<link href="./css/myPage.css" rel="stylesheet"/>
<%
String loginInfo = (String) session.getAttribute("member_id");
MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
if (loginInfo != null) {
%>
<form action = "myPageForm.ko" method = "post">
 <section class="row m-3">
 <div class="body center">
 	<h2 class="m-4"><i class="fa-solid fa-user fa-10px">나의 프로필</i></h2>
    <br>
	<div class="form-group">
		<label for="Id">* 아이디 :</label> 
			<input type="text" class="form-control" id="Id" name="Id"
			value="${ memberInfo.getMemberId() }" readonly><br> 
		<label for="Name">* 이름 :</label> 
			<input type="text" class="form-control" id="Name" name="Name"
			value="${ memberInfo.getMemberName() }" readonly><br> 
		<label for="email"> 이메일 :</label> 
			<input type="email" class="form-control" id="Mail" name="Mail"
		 	value="${ memberInfo.getMemberMail() }" readonly><br> 
		<label for="phone"> 휴대폰번호 :</label> 
			<input type="tel" class="form-control" id="phone" name="phone"
			value="${ memberInfo.getMemberPhone()}" readonly><br> 
		<label for="address"> 주소 :</label> 
			<input type="text" class="form-control" id="address" name="address"
			value="${ memberInfo.getMemberAdd() }" readonly>
		
		<br>
     <div class="btns" align="center">
    	<button type="submit" class="btn btn-primary" onclick="upDateMyPageCheck.ko">수정하기</button>

        <button type="button" class="btn btn-danger" onclick="location.href='deleteMyPageCheck.ko'">회원탈퇴</button>


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