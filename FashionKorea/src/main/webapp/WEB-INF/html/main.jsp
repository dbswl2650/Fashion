<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="./header.jsp"></jsp:include>

<main>
	<!-- 머찐 캐러셀 -->
	<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/main/slide1.jpg" class="d-block w-100" alt="slide1">
			</div>
			<div class="carousel-item">
				<img src="images/main/slide2.jpg" class="d-block w-100" alt="slide2">
			</div>
			<div class="carousel-item">
				<img src="images/main/slide3.jpg" class="d-block w-100" alt="slide3">
			</div>
		</div>
		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Next</span>
		</button>
	</div>
	<div>
		<div class="headline">
			<div class="first-headline">fashion korea</div>
		</div>
		<div class="button-area">
			<!-- dummy "location.href='../product/product.html'" -->
			<button onclick="" class="button-style">상품 보러가기</button>
		</div>
	</div>
	
	<!-- 상품 목록 -->
	<article>
		
	</article>
</main>
<link href="./css/main.css" rel="stylesheet"/>
<script src="./js/main.js"></script>

<jsp:include page="./footer.jsp"></jsp:include>
