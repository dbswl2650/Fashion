<%@page import="com.fashion.dao.LoginDAO"%>
<%@page import="com.fashion.control.LoginControl"%>
<%@ page import="com.fashion.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<%
	MemberVO mvo = new MemberVO();
	int number = mvo.getMemberNo();
	String name = mvo.getMemberName(); 
    String id = mvo.getMemberId();
    String pw = mvo.getMemberPw();
    // 필수입력사항이 아닌 경우 => null이 나올 수 있음
    String phone = (mvo.getMemberPhone() == null) ? "" : mvo.getMemberPhone();
    String email = (mvo.getMemberMail() == null) ? "" : mvo.getMemberMail();
    String address = (mvo.getMemberAdd() == null) ? "" : mvo.getMemberAdd();
    String age = (mvo.getMemberAge() == null) ? "" : mvo.getMemberAge();
%>
<form method="post" id="mypage-form">
    <table align="center">
        <tr>
            <td>* 아이디</td>
            <td><input type="text" name="userId" value="<%= id %>"  readonly maxlength="12" required></td>
            <td></td>
        </tr>
        <tr>
            <td>* 이름</td>
            <td><input type="text" name="userName" value="<%= name %>" maxlength="5" required></td>
            <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;전화번호</td>
            <td><input type="text" name="phone" value="<%= phone %>" placeholder="- 포함해서 입력해주세요"></td>
            <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;이메일</td>
            <td><input type="email" name="email" value="<%= email %>"></td>
            <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;주소</td>
            <td><input type="text" name="address" value="<%= address %>"></td>
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