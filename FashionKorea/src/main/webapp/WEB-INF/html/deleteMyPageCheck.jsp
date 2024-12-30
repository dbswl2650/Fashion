<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<% 
    String errorMessage = (String) request.getAttribute("errorMessage");
	String memberId = (String) session.getAttribute("member_id");
%>

<!-- 오류 메시지가 있을 경우 화면에 표시 -->
<% if (errorMessage != null) { %>
    <div style="color: red; text-align: center;">
        <%= errorMessage %>
    </div>
<% } %>

<form class="w3-container w3-card-4" action="DeleteMyPageCheckControl.ko" method="post">
    <div>
        <h1>회원정보 탈퇴</h1>
        <label>ID 확인</label>
        <input class="w3-input" type="text" name="id" value="<%= memberId %>" readonly="readonly">
    </div>

    <div>
        <label>PW 확인</label>
        <input class="w3-input" type="password" name="member_pw" required="required"> <!-- 현재 비밀번호 -->
    </div>
	 <div>
        <label>비밀번호 재확인</label>
        <input class="w3-input" type="password" name="confirm_pw" required="required">
    </div>
    <button type="submit" class="w3-button">확인</button>
    <button type="button" class="w3-button" onclick="window.location.href='myPage.ko'">취소</button>
</form>
<jsp:include page="./footer.jsp"></jsp:include>