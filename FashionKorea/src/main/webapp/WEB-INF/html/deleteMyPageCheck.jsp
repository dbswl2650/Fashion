<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.fashion.vo.MemberVO"%>
<jsp:include page="./header.jsp"></jsp:include>
<jsp:include page="./sidebar.jsp"></jsp:include>

<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/deleteMyPageCheck.css" rel="stylesheet" />
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

<form id="deleteForm" class="w3-container w3-card-4" action="deleteMyPageCheck.ko" method="post">
    <div>
        <h1><i class="fa-solid fa-key">회원정보 탈퇴</i></h1>
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
    <div class="btns" align="center">
    <button type="button" class="btn btn-primary" onclick="confirmDeletion()" >확인</button>
    <button type="button" class="btn btn-danger" onclick="window.location.href='myPage.ko'">취소</button>
    </div>
</form>
<jsp:include page="./footer.jsp"></jsp:include>

<script>
        // 탈퇴 확인 메시지 표시
    function confirmDeletion() {      
        const confirmResult = confirm("정말로 탈퇴하시겠습니까? 되돌릴 수 없습니다.");
        if (confirmResult) {
        // 확인을 눌르면 제출
            document.getElementById('deleteForm').submit();
        }
    }
</script>