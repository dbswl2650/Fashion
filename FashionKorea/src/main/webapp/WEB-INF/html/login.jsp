<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>로그인 화면</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

:root {
	--padding: 60px;
}

.box {
	position: relative;
	margin: 50px auto;
	width: 400px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	padding: var(--padding);
	background-color: #c4dfff;
	border-radius: 7px;
}

.box input, .box button {
	padding: 15px;
	font-size: 1.2em;
	border: none;
}

.box input {
	margin-bottom: 25px;
}

.box button {
	background-color: #ffe4c4;
	color: #547fb2;
	border-radius: 4px;
}

h1 {
	text-align: center;
}

/*.active*/
</style>

<jsp:include page="./header.jsp"></jsp:include>

<link href="./css/headerfooter.css" rel="stylesheet" />

<form action="login.ko" method="post">
	<div class="box">
		<h1>로그인</h1>
		<input type="text" name="id" id="id" placeholder="아이디" />
		 <input	type="password" name="pw" id="pw" placeholder="비밀번호" />
		<button>로그인</button>
		<button type="button" onclick="location.href='./signup.jsp'">회원가입</button>
	</div>
</form>
<link href="./css/login.css" rel="stylesheet" />
<script>
	
</script>
<jsp:include page="./footer.jsp"></jsp:include>