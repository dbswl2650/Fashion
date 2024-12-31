<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fashion.vo.MemberVO"%>

<link rel="stylesheet" href="./css/headerfooter.css"/>
<link rel="stylesheet" href="./css/font-awesome.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/elegant-icons.css" type="text/css"/>
<link rel="stylesheet" href="./css/plyr.css" type="text/css"/>
<link rel="stylesheet" href="./css/nice-select.css" type="text/css"/>
<link rel="stylesheet" href="./css/slicknav.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/style.css" type="text/css"/>

<jsp:include page="./header.jsp"></jsp:include>
<jsp:include page="./sidebar.jsp"></jsp:include>

<!-- 찜 목록 완성 -->

<%
String loginInfo = (String) session.getAttribute("member_id");
MemberVO memberInfo = (MemberVO) session.getAttribute("loginInfo");
if (loginInfo != null) {
%>
<main class="overflow-x-hidden overflow-y-visible bg-body">
	<c:choose>
		<c:when test="${clothesList.size() == 0}">
			<article>
				<p>찜한 목록이 없습니다...</p>
			</article>
		</c:when>
		<c:otherwise>
			<div class="body center row row-gap-3 column-gap-3 d-flex justify-content-center">
				<h2 class="m-4 text-center">찜 된 옷 넘버 리스트</h2>
				<br>
					<c:forEach var="i" begin="0" end="${clothesList.size() - 1}">
						<c:set var="cloth" value="${clothesList.get(i)}"></c:set>
						<c:set var="category" value="${categoryList.get(i)}"></c:set>
						<div class="card product__item col-md-2">
							<div class="card-img-top product__item__pic set-bg" data-setbg="images/product/${cloth.image}" style="background-image: url('images/product/${cloth.image}');">
							<c:if test="${isFamousList.get(i) == true}">
								<div class="ep">인기</div>
							</c:if>
							<a href="productDetailForm.ko?cno=${cloth.clothesNo}#header">
							<div class="comment"><i class="fa fa-comments"></i>${reviewCntList.get(i)} 개의 리뷰</div>
								</a>
								<!--- div class="view"><i class="fa fa-eye"></i>chicken waffle</div --->
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
				</br>
			</div>
		</c:otherwise>
	</c:choose>
</main>
<%
} else {
%>
<p>회원 정보를 불러오는 데 실패했습니다.</p>
<%
}
%>
<jsp:include page="./footer.jsp"></jsp:include>