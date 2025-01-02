<%@page import="com.fashion.vo.MemberVO"%>
<%@page import="com.fashion.vo.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="com.fashion.dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="./header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<meta charset="UTF-8" />
<title>패션 코리아</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="css/lightbox.min.css" rel="stylesheet">
<link href="css/owl.carousel.min.css" rel="stylesheet">


<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
.display-6.mb-4 {
	color: rgba(0, 0, 0, 0.993);
	font-family: "Jua", sans-serif;
	font-weight: 400;
	font-style: normal;
	font-size: 40px;
}

.rrrr {
	color: rgba(0, 0, 0, 0.993);
	font-family: "Jua", sans-serif;
}

h5 {
	color: rgba(0, 0, 0, 0.993);
	font-family: "Jua", sans-serif;
}

.btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4
	{
	position: absolute;
	top: 50%;
	background-color: #0a0a23;
	color: #fff;
	border: none;
	border-radius: 10px;
}
</style>
</head>

<body>
	<!-- 헤더 -->



	<div class="container py-5">
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">제품 사진</th>
						<th scope="col">제품 이름</th>
						<th scope="col">가격</th>
						<th scope="col">수량</th>
						<th scope="col">금액</th>
						<th scope="col">제품 삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cartItem" items="${cartItem}">
					
						<tr data-pcode="${cartItem.cartNo}">
							<th scope="row">
								<div class="d-flex align-items-center">
									<img src="images/product/${cartItem.image}">
									<class ="img-fluid me-5
										rounded-circle"
                                        style="width: 80px; height: 80px;"
										alt="${cartItem.name}">
								</div>
							</th>
							<td>
								<p class="mb-0 mt-4">${cartItem.name}</p>
							</td>
							<td>
								<p class="mb-0 mt-4">${cartItem.price}원</p>
							</td>
							<td>
								<div class="input-group quantity mt-4" style="width: 100px;">
									<div class="input-group-btn">
										<button
											class="btn btn-sm btn-minus rounded-circle bg-light border">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<input type="text"
										class="form-control form-control-sm text-center border-0"
										value="${cartItem.quantity}">
									<div class="input-group-btn">
										<button
											class="btn btn-sm btn-plus rounded-circle bg-light border">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
							</td>
							<td>
								<p class="mb-0 mt-4">${cartItem.quantity * cartItem.price}원</p>
							</td>
							<td>
								<button class="btn btn-md rounded-circle bg-light border mt-4">
									<i class="fa fa-times text-danger"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div class="row g-4 justify-content-end">
			<div class="col-8"></div>
			<div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
				<div class="bg-light rounded">
					<div class="p-4">
						<a class="display-6 mb-4">장바구니 <span class="fw-normal">합계</span></a>
						<div class="d-flex justify-content-between mb-4">
							<h5 class="mb-0 me-4"></h5>
							<p class="mb-0">얼른 주문해주세용</p>
						</div>
						<div class="d-flex justify-content-between">
							<h5 class="mb-0 me-4"></h5>
							<div class="">
								<p class="mb-0"></p>
							</div>
						</div>
						<p class="mb-0 text-end"></p>
					</div>
					<div
						class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
						<h5 class="mb-0 ps-4 me-4">총 금액</h5>
						<p class="mb-0 pe-4"></p>
					</div>
					<button
						class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4"
						type="button">
						<a href="orderPage.ko">구매하기</a>
					</button>
				</div>
			</div>
		</div>
	</div>

	</div>


	<link href="./css/cart.css" rel="stylesheet" />
	<script>
	
	
	
//삭제 
document.querySelectorAll('i.fa-times').forEach(icon => {
  icon.addEventListener('click', (e) => {
    let pcode = e.target.closest('tr');
    let pcode2 = pcode.getAttribute("data-pcode");
    
    removeCart(pcode2); 
    pcode.remove();
    
  })
})
function removeCart(cartNo){
	
	// get
	fetch('delCartInfo.ko?cartNo=' + cartNo)
	
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
	
	/* // post
	fetch('delCartInfo.ko', {
		method : 'post',
		headers : {
			'content-type' : 'application/x-www-form-urlencoded;charset=utf-8'
		},
		body : 'cartNo='+cartNo
	})
	.then(res => res.json())
	.then(result => {
		//실제 정상적으로 결과가 돌아올 경우
		console.log(result);
	})
	.catch(err => console.log(err));*/
} 
//더하기 아이콘 클릭 등록.
document.querySelectorAll('i.fa-plus').forEach(plusIcon => {
  plusIcon.addEventListener('click', (e) => {
    // console.dir(e.target.closest('div.quantity').children[1].value);

    let pcode = e.target.closest('tr');
    let pcode2 = pcode.getAttribute('data-pcode');

    // 현재수량 + 1
    let currentQty = parseInt(e.target.closest('div.quantity').children[1].value);
    if(currentQty<10){

    currentQty++;
    }else{
      return
    }
    e.target.closest('div.quantity').children[1].value = currentQty;
    // 가격.
    let price = e.target.closest('tr').children[2].firstElementChild.innerText;
    price = parseInt(price.replace('원', '')); // 2000 원 -> 2000
    console.log(price * currentQty);

    e.target.closest('tr').children[4].firstElementChild.innerText = price * currentQty + " 원";

    totalSum()
    updateCartQty(pcode2, currentQty);
  });
});



// 빼기 아이콘 클릭 등록.
document.querySelectorAll('i.fa-minus').forEach(minusIcon => {
  minusIcon.addEventListener('click', (e) => {
    console.dir(e.target.closest('div.quantity').children[1].value);
    
    let pcode = e.target.closest('tr');
    let pcode2 = pcode.getAttribute('data-pcode');

    // 현재수량 - 1
    let currentQty = parseInt(e.target.closest('div.quantity').children[1].value);
    
    if(currentQty>1){
      currentQty--
      //event.preventDefault()
    }else{
    return;
    }
    e.target.closest('div.quantity').children[1].value = currentQty;
    
    // 가격
    let price = e.target.closest('tr').children[2].firstElementChild.innerText;
    price = parseInt(price.replace('원', '')); // 2000 원 -> 2000
    console.log(price * currentQty);
    e.target.closest('tr').children[4].firstElementChild.innerText = price * currentQty + " 원";

    totalSum();
    updateCartQty(pcode2, currentQty);
  });
});

function updateCartQty(cartNo, quantity) {
	  fetch('updateCart.ko?cartNo='+cartNo+'&quantity='+quantity)
	    .then(res => res.json())
	    .then(result => {
	      // 실제 정상적으로 결과가 돌아올 경우
	      if (result == true) {
	        console.log('Cart updated successfully');
	        
	      } else {
	        alert('실패');
	      }
	    })
	    .catch(err => console.log(err));
	}

//합계금액 계산
function totalSum() {
  // 각 tr의 금액부분 ("4000 원") -> "4000" -> 4000 변경 후 합계.
  let sum = 0;
  document.querySelectorAll('tr>td:nth-of-type(4)')
    .forEach(item => {
      let subTotal = item.firstElementChild.innerText;
      subTotal = parseInt(subTotal.replace("원", ""));
      sum += subTotal;
    });
  // Cart Total 의 Total 의 위치에 합산결과 출력.
  document.querySelector('p.mb-0.pe-4').innerText = sum + " 원";
}
totalSum();
</script>
	<jsp:include page="./footer.jsp"></jsp:include>