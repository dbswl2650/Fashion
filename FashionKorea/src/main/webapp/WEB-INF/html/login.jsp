<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>로그인 화면</title>

<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/loginn.css" rel="stylesheet" />


<jsp:include page="./header.jsp"></jsp:include>

<div class="body">
<form class="w3-container w3-card-4" action="login.ko" method="post">
	<div class="box">
		<h1><i class="fa-solid fa-right-to-bracket">로그인</i></h1>
		<div class="box">
		 <input class="form-control" type="text" name="id" id="id" placeholder="아이디" />
		</div>
		<div class="box">
		 <input	class="form-control" type="password" name="pw" id="pw" placeholder="비밀번호" />
		</div> 
		<div class="btns" align="center">
		 <button class="btn btn-primary">로그인</button>
		 <button type="button" class="btn btn-danger" onclick="location.href='signup.ko'">회원가입</button>
		</div>
	</div>
</form>
</div>

<jsp:include page="./footer.jsp"></jsp:include>