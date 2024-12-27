<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/productDetail.css" rel="stylesheet" />
<jsp:include page="./header.jsp"></jsp:include>

<head>
<title>제품상세</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" ></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js "></script>
<style>
tr{
vertical-align:center;}
</style>
</head>

<body>
	<form action="cartForm.ko" method="post">
		<!-- Product section-->
		<section class="py-5">
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="images/product/${clothes.image}" alt="${clothes.image}" />
					</div>
					<div class="col-md-6">
						<h1 class="display-6 fw-bolder">${clothes.name }</h1>
						<div class="fs-5 mb-5">
							<input type="hidden" value="${clothes.price}" id="price"
								name="price"> <span class="text-decoration-none">${clothes.price}</span>원
						</div>
						<hr class="my-4">
						<div class="input-group fs-5 mb-5">
							<div class="input-group fs-5 mb-5">
								<div class="input-group-prepend">
									<input type="hidden" id="stockQuantity" name="stockQuantity">
									<span class="input-group-text">주문 수량</span>
								</div>
								<input class="form-control text-center me-3" id="count"
									name="count" type="number" value="1" style="max-width: 5rem" />
							</div>

							<div class="container bg-light">
								<h6>총 상품 금액</h6>
								<h4 name="totalPrice" id="totalPrice" class="font-weight-bold">
									<span>${clothes.price}</span>원
								</h4>
							</div>
						</div>
						<br>

						<div class="d-flex">

							<button class="btn btn-outline-dark" type="submit">바로
								구매하기</button>
							&nbsp
							<button class="btn btn-outline-dark flex-shrink-0" type="button">
								<i class="bi-cart-fill me-1"></i> 장바구니 담기
							</button>
						</div>
					</div>
				</div>

			</div>
		</section>

		<hr class="my-4">

		<div class="container">
			<div class="box"><a href="#description">상품상세</a></div>
			<div class="box">
				<a href="#header">리뷰</a>
			</div>
			<div class="box">상품문의</div>
		</div>
		<br> <br>
		<!-- Related items section-->
		<section class="py-5 bg-light">
			<div class="container">
				<p class="lead" id="description" style="text-align: center;">제품
					상세 설명</p>
			</div>

			<div class="container px-4 px-lg-5 mt-5">
				<div class="text-center">
					<img class="card-img-top rounded mb-5 mb-md-0"
						style="padding-bottom: 50px; width: 550px;"
						src="images/product/${clothes.imageDetail}">
				</div>
			</div>
		</section>

		<table class="table">
			<thead id="header">
				<tr>
					<th scope="col">#</th>
					<th scope="col">이미지</th>
					<th scope="col">회원이름</th>
					<th scope="col">점수</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">날짜</th>
				</tr>
			</thead>
			<tbody id="body">
				<c:forEach var="reviews" items="${review}">
					<tr>
						<th scope="row">${reviews.reviewNo}</th>
						<td><img style="height:80px;" src="images/product/${reviews.image}"></td>
						<td>${reviews.memberName}</td>
						<td>${reviews.score}</td>
						<td>${reviews.title}</td>
						<td>${reviews.comments}</td>
						<td>${reviews.wdateDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</form>
</body>
</html>


<jsp:include page="./footer.jsp"></jsp:include>