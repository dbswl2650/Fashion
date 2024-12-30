<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<jsp:include page="./sidebar.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/upDateMyPageCheck.css" rel="stylesheet"/>
<% 
    String errorMessage = (String) request.getAttribute("errorMessage");
	String memberId = (String) session.getAttribute("member_id");
%>

<form class="w3-container w3-card-4" action="upDateMyPageCheck.ko" method="post">
    <div>
        <h1><i class="fa-solid fa-key">회원 인증</i></h1>
        <label>ID 확인</label>
        <input class="form-control" type="text" name="id" value="<%= memberId %>" readonly="readonly">
    </div>

    <div>
        <label>PW 확인</label>
        <input class="form-control" type="password" name="member_pw" required="required">
    </div>
	 <div>
        <label>비밀번호 재확인</label>
        <input class="form-control" type="password" name="confirm_pw" required="required">
    </div>
    <br>
    <div class="btns" align="center">
    	<button type="submit" class="btn btn-primary">확인</button>
    	<button type="button" class="btn btn-danger" onclick="window.location.href='myPage.ko'">취소</button>
    </div>
</form>
<jsp:include page="./footer.jsp"></jsp:include>