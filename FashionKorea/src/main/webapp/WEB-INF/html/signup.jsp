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
  <form action="signupProcess.ko" method="post">
  <%-- requst(리퀘스트/요청)get(겟/받기)Context(컨텍스트/문맥)Path(패스/경로) 컨텍스트 경로(Context Path) 를 반환함
       signupProcess.ko(사인업 프로세스)는 실제 요청을 처리할 엔드포인트(URL)--%>
   <span>이름</span>
  <input type="text" name="name" id="name" maxlength="10" placeholder="이름" />
   <span>아이디</span>
  <input type="text" name="uid" id="uid" maxlength="10" placeholder="아이디" />
   <span>비밀번호</span>
  <input type="password" name="upw" id="upw" maxlength="20" placeholder="비밀번호" />
   <span>비밀번호 확인</span>
  <input type="password" name="confirm_upw" id="confirm_upw" maxlength="20" placeholder="비밀번호 확인" />
   <span>메일</span>
  <input type="email" name="em" id="em" maxlength="50" placeholder="메일" />
   <span>휴대폰번호</span>
  <input type="tel" name="pho" id="pho" maxlength="15" placeholder="휴대폰번호" />
   <span>생년월일</span>
  <input type="date" name="da" id="da" placeholder="생년월일" />
   <span>주소</span>
  <input type="text" name="add" id="add" placeholder="주소" />
  
  <button type="submit"> 가입하기 </button>
  </form>
</div>

<script>
  function validateForm() {
    const password = document.getElementById('upw').value;
    const confirmPw = document.getElementById('confirmPw').value;

    if (password !== confirmPw) {
      alert('비밀번호가 일치하지 않습니다.');
      return false;
    }
    return true;
  }
</script>

</body>
</html>