<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
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
  width: 600px;
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
  <h1>회원가입</h1>
   <span>이름</span>
  <input type="text" name="name" id="name" maxlength="10" placeholder="이름" />
   <span>아이디</span>
  <input type="text" name="uid" id="uid" maxlength="10" placeholder="아이디" />
   <span>비밀번호</span>
  <input type="password" name="upw" id="upw" maxlength="20" placeholder="비밀번호" />
  
  <input type="password" name="upw" id="upw" maxlength="20" placeholder="비밀번호 확인" />
   <span>메일</span>
  <input type="email" name="em" id="em" maxlength="50" placeholder="메일" />
   <span>휴대폰번호</span>
  <input type="tel" name="pho" id="pho" maxlength="13" placeholder="휴대폰번호" />
   <span>생년월일</span>
  <input type="date" name="da" id="upw" placeholder="생년월일" />
   <span>주소</span>
  <input type="text" name="upw" id="upw" placeholder="주소" />
  
  <button> 가입하기 </button>

</div>
</body>
</html>