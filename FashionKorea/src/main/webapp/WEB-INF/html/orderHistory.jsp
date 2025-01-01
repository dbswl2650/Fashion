<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<jsp:include page="./sidebar.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/orderHistory.css" rel="stylesheet" />
<div class="order-history-body">
	<div class="order-history-container">
		<h2>구매 내역</h2>

		<table class="order-history-table" border="1">
			<thead>
				<tr>
					<th>주문 번호</th>
					<th>주문 날짜</th>
					<th>총 금액</th>
					<th>주문 상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orderList}">
					<tr>
						<td>${order.ordersNo}</td>
						<td>${order.orDate}</td>
						<td>${order.orTotal}원</td>
						<td>${order.orStatus}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br> <a href="main.ko">홈으로 돌아가기</a>
	</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>