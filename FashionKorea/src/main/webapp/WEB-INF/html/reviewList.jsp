<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<link href="./css/reviewList.css" rel="stylesheet"/>

<div class="review-board">
    <h1><i class="fa-solid fa-comments">게시글 목록</i></h1>

    <!-- 검색 폼 -->
    <form action="reviewList.ko" method="get" class="review-search">
        <input type="text" name="keyword" class="form-control" value="${param.keyword}" placeholder="검색어 입력">
        <button type="submit">검색</button>
    </form>

    <c:if test="${not empty reviews}">
        <ul class="review-list">
            <c:forEach var="review" items="${reviews}">
                <li>
                    <a href="review.ko?review_no=${review.reviewNo}">${review.title}</a>
                    <span>(${review.wdateDate})</span>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty reviews}">
        <p class="no-reviews">검색된 게시글이 없습니다.</p>
    </c:if>

    <!-- 게시글 작성 버튼 -->
    <a href="reviewForm.ko" class="create-review-btn">게시글 작성하기</a>
</div>
<jsp:include page="./footer.jsp"></jsp:include>