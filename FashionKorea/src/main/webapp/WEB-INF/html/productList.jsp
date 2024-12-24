<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="./css/headerfooter.css"/>
<link rel="stylesheet" href="./css/font-awesome.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/elegant-icons.css" type="text/css"/>
<link rel="stylesheet" href="./css/plyr.css" type="text/css"/>
<link rel="stylesheet" href="./css/nice-select.css" type="text/css"/>
<link rel="stylesheet" href="./css/slicknav.css" type="text/css"/>
<link rel="stylesheet" href="./css/style.css" type="text/css"/>

<jsp:include page="./header.jsp"></jsp:include>

<main class="overflow-x-hidden overflow-y-visible bg-body">
	<!-- 상품 목록 -->
	<c:choose>
	<c:when test="${clothesList.size() == 0}">
		<article>
			<p>찾으시는 물품이 없는 것 같습니다...</p>
		</article>
	</c:when>
	<c:otherwise>
		<div class="row row-gap-3 column-gap-3 d-flex justify-content-center">
			<c:forEach var="i" begin="0" end="${clothesList.size() - 1}">
				<c:set var="cloth" value="${clothesList.get(i)}"></c:set>
				<c:set var="category" value="${categoryList.get(i)}"></c:set>
				<div class="card product__item col-md-2">
					<div class="card-img-top product__item__pic set-bg" data-setbg="images/product/${cloth.image}" style="background-image: url('images/product/${cloth.image}');">
						<div class="ep">인기</div>
						<div class="comment"><i class="fa fa-comments"></i>n개의 리뷰</div>
						<!-- div class="view"><i class="fa fa-eye"></i>chicken waffle</div -->
					</div>
					<div class="product__item__text">
						<ul>
							<li style="background-color: grey;">${category.sex} </li>
							<li style="background-color: grey;">${category.type} </li>
						</ul>
						<div class="card-body">
							<h5 class="card-title">${cloth.name}</h5>
							<h5 class="card-title" style="color:red">가격 : ${cloth.price}</h5>
							<p class="card-text">색상 : ${cloth.color}<p>
							<p class="card-text">사이즈 : ${cloth.clothesSize}<p>
							<p class="card-text">카테고리 : ${cloth.category}<p>
							<p class="card-text">${cloth.about}</p>
							<a class="btn btn-dark" href="productDetailForm.ko?cno=${cloth.clothesNo}" >상세보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:otherwise>
	</c:choose>
</main>

<jsp:include page="./footer.jsp"></jsp:include>
