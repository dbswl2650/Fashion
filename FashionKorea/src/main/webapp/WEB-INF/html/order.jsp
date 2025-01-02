<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/order.css" rel="stylesheet"/>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문/결제</title>

</head>
<body>

	<h2>주문/결제</h2>
	<div class="container">
		<div>
			<h4>주문자 정보</h4>
			<div>
				<p>이름:</p>
				<span class="form-control">${member.memberName}</span>
				<p>이메일:</p>
				<span class="form-control">${member.memberMail}</span>
				<p>연락처:</p>
				<span class="form-control">${member.memberPhone}</span>
				<p>배송주소:</p>
				<span class="form-control">${member.memberAdd}</span>
			</div>
		</div>
		<h4>주문 상품</h4>
		<table>
			<thead>
				<tr>
					<th>상품명</th>
					<th>수량</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.name}</td>
						<td>${item.quantity}</td>
						<td>${item.price * item.quantity}원</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><strong>총 결제금액</strong></td>
					<td><strong>${total}원</strong></td>
				</tr>
			</tfoot>
		</table>
		<button onclick="Order()">결제하기</button>
	</div>
</body>
</html>
<script>
   function Order() {
	   let total = ${total}; 
	   fetch('updateorderPage.ko?total=' + total) 
	   .then(res => res.json())
	   .then(result => {
	       if(result) {
	           alert('주문 완료');
	           location.href = 'main.ko';
	       } else {
	           alert('주문 실패');
	       }
	   })
	   .catch(err => console.log(err));
	}
   </script>
<jsp:include page="./footer.jsp"></jsp:include>