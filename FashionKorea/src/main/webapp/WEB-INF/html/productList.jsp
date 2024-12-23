<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="./header.jsp"></jsp:include>

<link href="./css/headerfooter.css" rel="stylesheet"/>

<main>
	<!-- 상품 목록 -->
	<article>
		
	</article>
</main>
<style>

</style>
<script>
	let clothlist = <%=request.getAttribute("clothesList")%>;
	
	console.log(clothlist);
	
	// 옷 카드를 보여준다
	function selectCard(cloth) {
		let cardHtml = `<div class="card" style="width: 18rem;">
							<img src="${cloth.image}" class="card-img-top" alt="${cloth.name}">
							<div class="card-body">
								<h5 class="card-title">${cloth.name}</h5>
								<h5 class="card-title" style="color:red">가격 : ${cloth.price}</h5>
								<p class="card-text">색상 : ${cloth.color}<p>
								<p class="card-text">사이즈 : ${cloth.clothesSize}<p>
								<p class="card-text">카테고리 : ${cloth.category}<p>
								<p class="card-text">${cloth.about}</p>
								<a href="#" class="btn btn-primary">Go somewhere</a>
							</div>
						</div>`;
		document.querySelector('article').insertAdjacentHTML('afterbegin', cardHtml);
	}
	
	document.querySelector('article').insertAdjacentHTML('afterbegin', '<div>');
	let count = 0;
	for (let cloth of clothlist) {
		selectCard(cloth);
		if (count % 5 == 4) {
			document.querySelector('article').insertAdjacentHTML('afterbegin', '</div><div>');
		}
	}
	document.querySelector('article').insertAdjacentHTML('afterbegin', '</div>');
</script>

<jsp:include page="./footer.jsp"></jsp:include>
