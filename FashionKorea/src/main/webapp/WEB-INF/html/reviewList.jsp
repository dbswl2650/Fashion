<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="./css/headerfooter.css"/>
<link rel="stylesheet" href="./css/reviewList.css"/>
<link rel="stylesheet" href="./css/font-awesome.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/elegant-icons.css" type="text/css"/>
<link rel="stylesheet" href="./css/plyr.css" type="text/css"/>
<link rel="stylesheet" href="./css/nice-select.css" type="text/css"/>
<link rel="stylesheet" href="./css/slicknav.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/style.css" type="text/css"/>

<jsp:include page="./header.jsp"></jsp:include>

<div class="review-board">
    <h1><i class="fa-solid fa-comments">게시글 목록</i></h1>

    <!-- 검색 폼 -->
    <form action="reviewList.ko" method="get" class="review-search">
        <input type="text" name="keyword" class="form-control" value="${param.keyword}" placeholder="검색어 입력">
        <button type="submit">검색</button>
    </form>

    <c:if test="${reviews.size() == 0}">
        <p class="no-reviews">검색된 게시글이 없습니다.</p>
    </c:if>
    <c:if test="${reviews.size() != 0}">
        <ul class="review-list">
            <c:forEach var="review" items="${reviews}">
                <li>
                    <a href="review.ko?review_no=${review.reviewNo}">${review.title}</a>
                    <span>(${review.wdateDate})</span>
                </li>
            </c:forEach>
        </ul>
    </c:if>

	<!-- 페이지 목록 탭 -->
	<nav aria-label="Page navigation example" style="background-color: white;">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="reviewList.ko?keyword=${keyword}&page=${minPage - 1}">Previous</a></li>
			<c:forEach var="p" begin="${minPage}" end="${maxPage}">
				<li class="page-item"><a class="page-link" href="reviewList.ko?keyword=${keyword}&page=${p}">${p}</a></li>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="reviewList.ko?keyword=${keyword}&page=${maxPage + 1}">Next</a></li>
		</ul>
	</nav>

    <!-- 게시글 작성 버튼 -->
    <a href="reviewForm.ko" class="create-review-btn">게시글 작성하기</a>
</div>
<jsp:include page="./footer.jsp"></jsp:include>