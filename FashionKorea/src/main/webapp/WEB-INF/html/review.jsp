<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<link href="./css/review.css" rel="stylesheet"/>
<div class="review-detail">
    <h1>제목: ${review.title}</h1>
    <p>내용: ${review.comments}</p>
    <c:if test="${not empty review.image}">
        <img src="images/${review.image}" alt="이미지">
    </c:if>
    <span>작성일: ${review.wdateDate}</span>
</div>
<jsp:include page="./footer.jsp"></jsp:include>