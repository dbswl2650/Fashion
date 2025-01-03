<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./header.jsp"></jsp:include>

<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/sigup.css" rel="stylesheet" />

<div >
  <form class="box" action="signupProcess.ko" method="post">
  <h1>회원가입</h1>
  <%-- requst(리퀘스트/요청)get(겟/받기)Context(컨텍스트/문맥)Path(패스/경로) 컨텍스트 경로(Context Path) 를 반환함
       signupProcess.ko(사인업 프로세스)는 실제 요청을 처리할 엔드포인트(URL)--%>
   <div class="box">
    <label class="labelbox" for="name">이름</label>
    <input class="inputbox" type="text" name="name" id="name" maxlength="10" placeholder="이름" />
   </div>
   <div class="box">
    <label class="labelbox" for="id">아이디</label>
    <input class="inputbox" type="text" name="uid" id="uid" maxlength="10" placeholder="아이디" style="width:190px;" />
    
    <input class="inputbox" type="button" id="btn" value="중복" onclick="idcheck()" style="width:50px;height:30px" />
    <span id="result"></span>
  </div>
  <div class="box">
    <label class="labelbox" for="upw">비밀번호</label>
    <input class="inputbox" type="password" name="upw" id="upw" maxlength="20" placeholder="비밀번호" />
  </div>
  <div class="box">
    <label class="labelbox" for="confirm_upw">비밀번호 확인</label>
    <input class="inputbox" type="password" name="confirm_upw" id="confirm_upw" maxlength="20" placeholder="비밀번호 확인" />
  </div>
  <div class="box">
    <label class="labelbox" for="em">메일</label>
    <input class="inputbox" type="email" name="em" id="em" maxlength="50" placeholder="메일" />
  </div>
  <div class="box">
    <label class="labelbox" for="pho">휴대폰번호</label>
    <input class="inputbox" type="tel" name="pho" id="pho" maxlength="13" placeholder="휴대폰번호"
   pattern="010-[0-9]{3,4}-[0-9]{4}" onfocus="this.placeholder=''" oninput="autoHyphen(this)"
   autocomplete="off" />
  </div>
  <div class="box">
    <label class="labelbox" for="da">생년월일</label>
    <input class="inputbox" type="date" name="da" id="da" placeholder="생년월일" />
  </div>
  <div class="box">
    <label class="labelbox" for="add">주소</label>
    <input class="inputbox" type="text" name="add" id="add" placeholder="주소" />
  </div>
  <div class="box"> 
    <button type="submit" class="btn btn-primary"> 가입하기 </button>
  </div>
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

<jsp:include page="./footer.jsp"></jsp:include>
