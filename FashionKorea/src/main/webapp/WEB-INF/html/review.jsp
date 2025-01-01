<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/review.css" rel="stylesheet" />
<div class="review-detailbody">
	<div class="review-detail">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td><c:out value="${review.reviewNo }" /></td>
				<th>작성일</th>
				<td><c:out value="${review.wdateDate}" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><c:out value="${review.title}" /></td>
				<c:if test="${not empty review.image}">
					<th>이미지</th>
					<td><img src="images/${review.image}" width="100px"></td>
				</c:if>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea rows="5" class="form-control"
						readonly name="content"><c:out
							value="${review.comments}" /></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit"
					class="btn btn-warning" value="수 정"> <input type="submit"
					class="btn btn-danger" value="삭 제"></td>
			</tr>
		</table>
	</div>
</div>
<jsp:include page="./footer.jsp"></jsp:include>