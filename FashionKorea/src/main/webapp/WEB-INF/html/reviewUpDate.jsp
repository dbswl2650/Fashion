<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/reviewUpDate.css" rel="stylesheet" />
<div class="review-detailbody">
	<div class="review-detail">
		<form action="reviewUpDate.ko" method="POST">
			<input type="hidden" name="review_no" value="${review.reviewNo}">
			<input type="hidden" name="review_no" value="${review.memberNo}">
			<input type="hidden" name="clothes_no" value="${review.clothesNo}">
			<table class="table">
				<tr>
					<th>글번호</th>
					<td><c:out value="${review.reviewNo}" /></td>
					<th>작성일</th>
					<td><c:out value="${review.wdateDate}" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" class="form-control"
						value="${review.title}"></td>
					<c:if test="${not empty review.image}">
						<th>이미지</th>
						<td><img src="images/${review.image}" width="100px"></td>
					</c:if>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea rows="5" class="form-control"
							name="comments"><c:out value="${review.comments}" /></textarea></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<button	type="submit" class="btn btn-warning">수정</button>
					</td>
				</tr>
			</table>

			<a href="reviewList.ko" class="btn btn-secondary mt-3">목록으로 돌아가기</a>
		</form>
	</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>