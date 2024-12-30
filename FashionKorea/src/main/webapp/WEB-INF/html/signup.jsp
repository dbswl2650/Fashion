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

<jsp:include page="./header.jsp"></jsp:include>

<link href="./css/headerfooter.css" rel="stylesheet" />

<body>

<div >
  <form class="box" action="signupProcess.ko" method="post">
  <h1>회원가입</h1>
  <%-- requst(리퀘스트/요청)get(겟/받기)Context(컨텍스트/문맥)Path(패스/경로) 컨텍스트 경로(Context Path) 를 반환함
       signupProcess.ko(사인업 프로세스)는 실제 요청을 처리할 엔드포인트(URL)--%>
   <span>이름</span>
  <input type="text" name="name" id="name" maxlength="10" placeholder="이름" />
   <span>아이디</span>
  <input type="text" name="uid" id="uid" maxlength="10" placeholder="아이디" />
  <input type="button" id="btn" value="중복검사" onclick="idcheck()">
   <span id="result"></span>
   <span>비밀번호</span>
  <input type="password" name="upw" id="upw" maxlength="20" placeholder="비밀번호" />
   <span>비밀번호 확인</span>
  <input type="password" name="confirm_upw" id="confirm_upw" maxlength="20" placeholder="비밀번호 확인" />
   <span>메일</span>
  <input type="email" name="em" id="em" maxlength="50" placeholder="메일" />
   <span>휴대폰번호</span>
  <input type="tel" name="pho" id="pho" maxlength="13" placeholder="휴대폰번호"
  pattern="010-[0-9]{3,4}-[0-9]{4}" onfocus="this.placeholder=''" oninput="autoHyphen(this)"
  autocomplete="off" />
   <span>생년월일</span>
  <input type="date" name="da" id="da" placeholder="생년월일" />
   <span>주소</span>
  <input type="text" name="add" id="add" placeholder="주소" />
  
  <button type="submit"> 가입하기 </button>
  </form>
</div>

<script>
<!-- 비밀번호 확인 -->
  function validateForm() {
    const password = document.getElementById('upw').value;
    const confirmPw = document.getElementById('confirmPw').value;

    if (password !== confirmPw) {
      alert('비밀번호가 일치하지 않습니다.');
      return false;
    }
    return true;
  }
  
<!--자동하이픈기능추가 -->
  const autoHyphen = (target) => {
      target.value = target.value
       .replace(/[^0-9]/g, '')
       .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
  }
  
<!-- 아이디 중복확인 -->
function idcheck() {
    const uid = document.getElementById('uid').value;

    if (!uid.trim()) {
        alert("아이디를 입력해주세요.");
        return;
    }

    fetch('selectSameId.ko', {
        method: 'POST',
        headers: {'Content-Type': 'text/json'},       
        body: JSON.stringify({ uid })
    })
        .then(response => response.json())
        .then(result => {
            const resultElement = document.getElementById('result');
            if (result.hasSameId) {
                resultElement.textContent = "중복된 아이디입니다.";
                resultElement.style.color = "red";
            } else {
                resultElement.textContent = "사용 가능한 아이디입니다.";
                resultElement.style.color = "green";
            }
        })
        .catch(err => console.error("Error:", err));
}
</script>

</body>
<jsp:include page="./footer.jsp"></jsp:include>
</html>