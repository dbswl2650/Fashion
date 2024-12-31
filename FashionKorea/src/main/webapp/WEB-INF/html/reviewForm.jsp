<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet"/>
<link href="./css/reviewForm.css" rel="stylesheet"/>
 <div class="form-container">
    <form action="review.ko" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="title">제목:</label>
            <input type="text" class="form-control" name="title" required>
        </div>
        <div class="form-group">
            <label for="comments">내용:</label>
            <textarea name="comments" class="form-control" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="image">이미지:</label>
            <input type="file" class="form-control" name="image">
        </div>
        <input type="hidden" name="member_no" value="${sessionScope.member_no}">
        <button type="submit">등록</button>
    </form>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
</div>
<jsp:include page="./footer.jsp"></jsp:include>