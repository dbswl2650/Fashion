<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="./css/main.css" rel="stylesheet" />
<script src="./js/main.js"></script>
<jsp:include page="./header.jsp"></jsp:include>
<form action="productDetail.ko">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="description" content="" />
<meta name="author" content="" />
<title>제품상세</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<link href="/css/styles.css" rel="stylesheet" />
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>

<body>

	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0" alt="..." />
				</div>
				<div class="col-md-6">
					<h1 class="display-5 fw-bolder">Shop item template</h1>
					<div class="fs-5 mb-5">
						<input type="hidden" id="price"	name="price">
						<span class="text-decoration-none"></span>원
					</div>
					<hr class="my-4">
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
						<h4 name="totalPrice" id="totalPrice" class="font-weight-bold"></h4>
					</div>
					<br>

					<div class="d-flex">
						<button class="btn btn-outline-dark flex-shrink-0" type="button">
							<i class="bi-cart-fill me-1"></i> 장바구니 담기
						</button>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container">
			<p class="lead" id="description" style="text-align: center">제품 상세 설명</p>
		</div>
		<hr class="my-4">
		<div class="container px-4 px-lg-5 mt-5">
			<div th:each=""	class="text-center">
				<img class="card-img-top rounded mb-5 mb-md-0"
				 style="padding-bottom: 50px; width: 550px; height: 700px">
			</div>
		</div>
	</section>
	
	
</body>
	</html>

</form>

<jsp:include page="./footer.jsp"></jsp:include>