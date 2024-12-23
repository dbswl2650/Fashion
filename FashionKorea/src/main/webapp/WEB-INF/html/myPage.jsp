<%@page import="com.fashion.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./header.jsp"></jsp:include>
<div class="col-4">
	<table class="w3-table w3-centered w3-card-4 w3-bordered"
		style="margin-top: 50px; width: 100%;">
		<thead class="w3-dark-grey">
			<tr>
				<td colspan="2">
					<h1>${ member.memberName }의 상세정보
					</h1>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>고객 ID</th>
				<td>${ member.memberId }</td>
			</tr>
			<tr>
				<th>고객 이름</th>
				<td>${ member.memberName }</td>
			</tr>
			<tr>
				<th>고객 휴대번호</th>
				<td>${ member.memberPhone }</td>
			</tr>
			<tr>
				<th>고객 주소</th>
				<td>${ member.memberAdd }</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${ member.memberAge }</td>
			</tr>
			<tr>
				<th>메일</th>
				<td>${ member.memberMail }</td>
			</tr>
			<tr>
				<td width="50%;"><a class="a-to-button"
					href="/shop/customer/checkInfoUpdateCustomer.jsp"
					style="width: 100%;">회원정보 수정</a></td>
				<td width="50%;"><a class="a-to-button"
					href="/shop/customer/deleteCustomerForm.jsp" style="width: 100%;">회원
						탈퇴</a></td>

			</tr>
		</tbody>
	</table>

</div>
<jsp:include page="./footer.jsp"></jsp:include>