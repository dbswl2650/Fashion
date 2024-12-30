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
 	<h2 class="m-4"><i class="fa-solid fa-user fa-10px">찜 된 옷 넘버 리스트</i></h2>
    <br>
		<c:forEach var="likenum" items="${likeList}">
			<p>
				${likenum}
			</p>
		</c:forEach>
	</br>
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