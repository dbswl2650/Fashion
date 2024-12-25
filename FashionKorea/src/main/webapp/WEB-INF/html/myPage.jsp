<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.fashion.vo.MemberVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />

<%
MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
if (memberInfo != null) {
%>
<h1>마이페이지</h1>
<p>
	회원 이름:
	<%=memberInfo.getMemberName()%></p>
<p>
	회원 아이디:
	<%=memberInfo.getMemberId()%></p>
<p>
	회원 이메일:
	<%=memberInfo.getMemberMail()%></p>
<p>
	회원 전화번호:
	<%=memberInfo.getMemberPhone()%></p>
<p>
	회원 주소:
	<%=memberInfo.getMemberAdd()%></p>
<%
} else {
%>
<p>회원 정보를 불러오는 데 실패했습니다.</p>
<%
}
%>
<jsp:include page="./footer.jsp"></jsp:include>