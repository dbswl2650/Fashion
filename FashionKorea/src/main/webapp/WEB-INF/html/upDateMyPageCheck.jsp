<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<%
String loginInfo = (String) session.getAttribute("member_id");
MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
%>
<div class="col-2 w3-container w3-half w3-margin-top" style="height: 90vh; width: 25%;">
<form class="w3-container w3-card-4 w3-border w3-round-large" action="upDateMember.ko" method="post" style="margin: 40% auto; height: 330px;">
	<div style="margin-top: 30px; text-align: center;">
					<h1>회원정보 수정</h1>
	</div>
			
			<div>
				<label>ID 확인</label>
				<input class="w3-input" type="text" name="customerId" value="${ memberInfo.getMemberId() }" readonly="readonly">
			</div>
			
			<div>
				<label>PW 확인</label>
				<input class="w3-input" type="password" name="customerPw" required="required">
			</div>

			<div class="row" style="margin-top: 20px;">
				<div class="col">
					<button class="w3-button w3-section w3-dark-grey w3-ripple" type="submit" style="width: 100%;">
						정보 수정하기
					</button>
				</div>				
			</div>
		</form>
	</div>
<jsp:include page="./footer.jsp"></jsp:include>