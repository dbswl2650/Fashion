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

<main>
	<!-- 상품 목록 -->
	<article>
		<div class="row">
		<c:if test="${clothesList.size() == 0}">
			<p>찾으시는 물품이 없는 것 같습니다...</p>
		</c:if>
		<c:forEach var="cloth" items="${clothesList}">
			<div class="card product__item">
				<div class="card-img-top product__item__pic set-bg" data-setbg="images/product/${cloth.image}" style="background-image: url(&quot;img/trending/trend-1.jpg&quot;);">
					<div class="ep">hamburger</div>
					<div class="comment"><i class="fa fa-comments"></i>pizza</div>
					<div class="view"><i class="fa fa-eye"></i>chicken waffle</div>
				</div>
				<div class="product__item__text">
					<ul>
						<li>Active</li>
						<li>Movie</li>
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
	</article>
</main>

<jsp:include page="./footer.jsp"></jsp:include>
