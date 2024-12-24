<%@page import="com.fashion.dao.LoginDAO"%>
<%@page import="com.fashion.control.LoginControl"%>
<%@ page import="com.fashion.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />

<form method="post" id="mypage-form">
    <table align="center">
        <tr>
            <td>* 아이디</td>
            <td><input type="text" name="id" value="${ loginInfo.memberId }"  readonly maxlength="12" required></td>
            <td></td>
        </tr>
        <tr>
            <td>* 이름</td>
            <td><input type="text" name="userName" value="${loginInfo.memberName }" maxlength="5" required></td>
            <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;전화번호</td>
            <td><input type="text" name="phone" value="${ loginInfo.memberPhone }" placeholder="- 포함해서 입력해주세요"></td>
            <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;이메일</td>
            <td><input type="email" name="email" value="${ loginInfo.memberMail }"></td>
            <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;주소</td>
            <td><input type="text" name="address" value="${ loginInfo.memberAdd }"></td>
            <td></td>
        </tr>
       
    </table>
    <br><br>
    <script>
        
    </script>

    <div align="center">
        <button type="submit" class="btn btn-sm btn-secondary">정보변경</button>
        <button type="button" class="btn btn-sm btn-warning" data-toggle="modal" data-target="#updatePwdFor">비밀번호변경</button>
        <button type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteMember">회원탈퇴</button>
    </div>

    <br><br>
</form>
<jsp:include page="./footer.jsp"></jsp:include>