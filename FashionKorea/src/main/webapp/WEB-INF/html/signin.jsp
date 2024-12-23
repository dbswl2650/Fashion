<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

.box input,
.box button {
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
</head>
<body>



<div class="box">
  <h1>로그인</h1>
  <form action="login.ko" method="post">
  <input type="text" name="uid" id="uid" placeholder="아이디" />
  <input type="password" name="upw" id="upw" placeholder="비밀번호" />
  
  <button>로그인</button>

  <button type="button" onclick="location.href='signup.ko'">회원가입</button>
  </form>
</div>

<script>

</script>

</body>
</html>