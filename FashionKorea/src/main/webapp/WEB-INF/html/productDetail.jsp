<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="./css/headerfooter.css" rel="stylesheet" />
<link href="./css/productDetail.css" rel="stylesheet" />
<link href="./css/reviews.css" rel="stylesheet" />
<jsp:include page="./header.jsp"></jsp:include>

<head>
<title>제품상세</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet">
</script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js "></script>
<style>
tr {
	vertical-align: center;
}

a {
	text-decoration-line: none;
}
h1{
	font-size: 50px;
	text-align:center;
	margin: 35px;
	font-weight:bolder;
}
</style>
</head>

<body>
	<form action="cartInsertItem.ko?cno=${clothes.clothesNo}" method="post">
		<!-- Product section-->
		<section class="py-5">
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="images/product/${clothes.image}" alt="${clothes.image}" />
					</div>
					<div class="col-md-6">
						<h1 class="display-6 fw-bolder">${clothes.name}</h1>
						<div class="fs-5 mb-5">
							<input type="hidden" value="${clothes.price}" id="price"
								name="price"> <span class="text-decoration-none">${clothes.price}</span>원
						</div>
						<hr class="my-4">
						<div class="input-group fs-5 mb-5">
							<div class="input-group fs-5 mb-5">
								<div class="input-group-prepend">
									<input type="hidden" id="stockQuantity" name="stockQuantity">
									<span class="input-group-text">주문 수량</span>
								</div>
								<input class="form-control text-center me-3" id="quantity"
									name="quantity" type="number" value="1" style="max-width: 5rem" />
							</div>
							<div class="container bg-light">
								<h6>총 상품 금액</h6>
								<h4 name="totalPrice" id="totalPrice" class="font-weight-bold">
									<span>${clothes.price}</span>원
								</h4>
							</div>
						</div>
						<br>
						<div class="d-flex">
							&nbsp
							<button class="btn btn-outline-dark flex-shrink-0" type="submit" cno=${cloth.clothesNo} >
								<i class="bi-cart-fill me-1"></i>
								장바구니 바로가기
							</button>
							<button class="btn btn-outline-dark flex-shrink-0" type="button"
								id="liketoggle"></button>
						</div>
					</div>
				</div>

			</div>
		</section>

		<hr class="my-4">
		<div class="container">
			<div class="box">
				<a href="#description">상품상세</a>
			</div>
			<div class="box">
				<a href="#header">리뷰</a>
			</div>
			<div class="box">
			<a href="reviewList.ko">포텐 터진 게시판</a>
			</div>
		</div>
		<br> <br>
		<!-- Related items section-->
		<section class="py-5 bg-light">
			<div class="container">
				<p class="lead" id="description" style="text-align: center;">제품
					상세 설명</p>
			</div>
			<div class="container px-4 px-lg-5 mt-5">
				<div class="text-center">
					<img class="card-img-top rounded mb-5 mb-md-0"
						style="padding-bottom: 50px; width: 550px;"
						src="images/product/${clothes.imageDetail}">
				</div>
			</div>
		</section>
	</form>
	<form action="productDetailForm.ko?cno=${clothes.clothesNo}" method="post">
		
		<table class="table">
			<thead id="header">
				<!-- header는 리뷰의 헤더라는 뜻 -->
				<tr>
					<th scope="col">#</th>
					<th scope="col">이미지</th>
					<th scope="col">회원이름</th>
					<th scope="col">점수</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="body">
				<c:forEach var="reviews" items="${review}">
					<tr>
						<th scope="row">${reviews.reviewNo}</th>
						<td><img style="height: 80px;" src="images/product/${reviews.image}"></td>
						<td>${reviews.memberName}</td>
						<td>${reviews.score}</td>
						<td>${reviews.title}</td>
						<td>${reviews.comments}</td>
						<td>${reviews.wdateDate}</td>
						<td><button class="btn btn-md rounded-circle bg-light border mt-4">
									<i class="fa fa-times text-danger"></i>
								</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1> 리뷰 작성 </h1>
		<div class="review-detail">
			<table class="table">
				<tr>
					<th>이미지</th>
					<td><input type="file" name="image"></td>
				</tr>
				<tr>
					<th>회원이름</th>
					<td><input type="text" class="form-control" name="reviewName"></td>
				</tr>
				<tr>
					<th>점수</th>
					<td>
						<select name="score">
							<option value="★">★</option>
							<option>★★</option>
							<option>★★★</option>
							<option>★★★★</option>
							<option>★★★★★</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" class="form-control" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea type="text" class="form-control" name="comments"></textarea></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><input type="date" name="wDate"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="hidden" name="member_no" value="${sessionScope.member_no}">
						<button class="btn btn-outline-dark flex-shrink-0" type="submit">작성하기</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
<script>
toggleOnOff(${hasLike});

function toggleOnOff(onoff) {
	if(onoff == true) {
		liketoggle.innerHTML = "찜 해제";
		liketoggle.onclick = unlike;
	}
	else {
		liketoggle.innerHTML = "찜하기";
		liketoggle.onclick = like;
	}
}

function like() {
	fetch('likeItInsertForm.ko?cno=' + ${clothes.clothesNo})
	.then(result => result.json())
	.then(result => {
		if (result.retCode == 'OK') {
			console.log('is OK');
			toggleOnOff(true);
		}
	})
}

function unlike() {
	fetch('likeItDeleteForm.ko?cno=' + ${clothes.clothesNo})
	.then(result => result.json())
	.then(result => {
		if (result.retCode == 'OK') {
			console.log('is OK');
			toggleOnOff(false);
		}
	})
}

document.querySelectorAll('btn-outline-dark flex-shrink-0').forEach(item => {
	item.addEventListener('click', e => {
	     alert("상품을 장바구니에 담았습니다")
	});
});

// 삭제
document.querySelectorAll('i.fa-times').forEach(icon => {
	  icon.addEventListener('click', (e) => {
	    let pcode = e.target.closest('tr');
	    let pcode2 = pcode.getAttribute("data-pcode");
	    
	    removeCart(pcode2); 
	    pcode.remove();
	    
	  })
	})
	function removeCart(reviewNo){
		
		// get
		fetch('delReviewInfo.ko?reviewNo=' + reviewNo)
		
		.then(res => res.json())
		.then(result => {
			//실제 정상적으로 결과가 돌아올 경우
			if(result==true){	
			console.log(result);
				alert('삭제되었습니다')
			}else{
				alert('실패')
			} 
		})
		.catch(err => console.log(err)); 
		
}
	
</script>
</body>
</html>

<jsp:include page="./footer.jsp"></jsp:include>