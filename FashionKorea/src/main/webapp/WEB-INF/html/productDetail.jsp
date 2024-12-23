<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="./css/main.css" rel="stylesheet"/>
<script src="./js/main.js"></script>
<jsp:include page="./header.jsp"></jsp:include>

<form action="productDetail.ko" >

<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" class="form-control" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="25" rows="3" class="form-control" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" readonly class="form-control" name="writer" value="${logId}"></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" class="form-control" name="img" ></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="게시글등록">
			</td>
		</tr>
	</table>

</form>

<jsp:include page="./footer.jsp"></jsp:include>