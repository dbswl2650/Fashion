<%@page import="com.fashion.dao.CartDAO"%>
<%@page import="com.fashion.vo.CartItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<jsp:include page="./header.jsp"></jsp:include>
=======

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
  <link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&display=swap" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<meta charset="UTF-8" />
<title>패션 코리아</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

  <!-- Libraries Stylesheet -->
  <link href="css/lightbox.min.css" rel="stylesheet">
  <link href="css/owl.carousel.min.css" rel="stylesheet">


  <!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
.display-6.mb-4{
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
h5{
    color: rgba(0, 0, 0, 0.993);
font-family: "Jua", sans-serif;
    }
.btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4{
    position: absolute;
    top:50%;
    background-color:#0a0a23;
    color: #fff;
    border:none;
    border-radius:10px;
    }
</style>
</head>
<%
//로그인 되어있는 아이디 가져오기
String id = (String)session.getAttribute("id");
//멤버 넘버에 맞는 장바구니 목록 불러오기
CartDAO cdao = new CartDAO();
List<CartItem> clist = cdao.selectCart("1");
%>
<body>
	<!-- 헤더 -->
	<header>
		<nav>
			<a href="http://localhost/FashionKorea">
				<div class="logo">
					<img src="./images/logo/태극기.jpg" alt="패션 코리아">
				</div>
			</a>
			<div class="menuBar">
				<a href="">검색</a>
				<a href="">상품 페이지</a>
				<span>|</span>
				<a href="">장바구니</a>
				<a href="">회원가입</a>
				<a href="loginForm.ko">로그인</a>
			</div>
		</nav>
	</header>
>>>>>>> branch 'main' of https://github.com/dbswl2650/Fashion.git



<<<<<<< HEAD
<div class="site-section">
    <div class="container" >
      <div class="row mb-5">
        <form class="col-md-12" method="post">
          <div class="site-blocks-table">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th class="product-thumbnail">제품 사진</th>
                  <th class="product-name">제품 이름</th>
                  <th class="product-price">가격</th>
                  <th class="product-quantity">수량</th>
                  <th class="product-total">금액</th>
                  <th class="product-remove">제품 삭제</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="product-thumbnail">
                    <img src="images/cloth_1.jpg" alt="Image" class="img-fluid">
                  </td>
                  <td class="product-name">
                    <h2 class="h5 text-black">Top Up T-Shirt</h2>
                  </td>
                  <td>$49.00</td>
                  <td>
                    <div class="input-group mb-3" style="max-width: 120px;">
                      <div class="input-group-prepend">
                        <button class="btn btn-outline-secondary js-btn-minus" type="button">&minus;</button>
                      </div>
                      <input type="text" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                      <div class="input-group-append">
                        <button class="btn btn-outline-secondary js-btn-plus" type="button">&plus;</button>
                      </div>
                    </div>

                  </td>
                  <td>$49.00</td>
                  <td><a href="#" class="btn btn-secondary btn-sm">X</a></td>
                </tr>

                <tr>
                  <td class="product-thumbnail">
                    <img src="images/cloth_2.jpg" alt="Image" class="img-fluid">
                  </td>
                  <td class="product-name">
                    <h2 class="h5 text-black">Polo Shirt</h2>
                  </td>
                  <td>$49.00</td>
                  <td>
                    <div class="input-group mb-3" style="max-width: 120px;">
                      <div class="input-group-prepend">
                        <button class="btn btn-outline-secondary js-btn-minus" type="button">&minus;</button>
                      </div>
                      <input type="text" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                      <div class="input-group-append">
                        <button class="btn btn-outline-secondary js-btn-plus" type="button">&plus;</button>
                      </div>
                    </div>

                  </td>
                  <td>$49.00</td>
                  <td><a href="#" class="btn btn-secondary btn-sm">X</a></td>
                </tr>
              </tbody>
            </table>
          </div>
        </form>
=======
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
          <tr data-pcode="${cart.pcode}">
                            <th scope="row">
                                <div class="d-flex align-items-center">
                                    <img src="./images/product/${prodInfo.image}" class="img-fluid me-5 rounded-circle"
                                        style="width: 80px; height: 80px;" alt="">
                                </div>
                            </th>
                            <td>
                                <p class="mb-0 mt-4">${prodInfo.pname}</p>
                            </td>
                            <td>
                                <p class="mb-0 mt-4">${prodInfo.price} 원</p>
                            </td>
                            <td>
                                <div class="input-group quantity mt-4" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-minus rounded-circle bg-light border">
                                            <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm text-center border-0"
                                        value="${cart.qty}">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-plus rounded-circle bg-light border">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <p class="mb-0 mt-4">${cart.qty * prodInfo.price}  원</p>
                            </td>
                            <td>
                                <button class="btn btn-md rounded-circle bg-light border mt-4">
                                    <i class="fa fa-times text-danger"></i>
                                </button>
                            </td>
                        </tr>
          </tbody>
        </table>
>>>>>>> branch 'main' of https://github.com/dbswl2650/Fashion.git
      </div>

<<<<<<< HEAD
      <div class="row">
        <div class="col-md-6">
          
          <div class="row">
            <div class="col-md-12">
              <label class="text-black h4" for="coupon">쿠폰</label>
              <p>쿠폰 번호를 입력하세요.</p>
            </div>
            <div class="col-md-8 mb-3 mb-md-0">
              <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
            </div>
            <div class="col-md-4">
              <button class="btn btn-secondary btn-sm">쿠폰 등록</button>
            </div>
          </div>
        </div>
        <div class="col-md-6 pl-5">
          <div class="row justify-content-end">
            <div class="col-md-7">
              <div class="row">
                <div class="col-md-12 text-right border-bottom mb-5">
                  <h3 class="text-black h4 text-uppercase">장바구니 총금액</h3>
=======

     
      <div class="row g-4 justify-content-end">
        <div class="col-8"></div>
        <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
          <div class="bg-light rounded">
            <div class="p-4">
              <a class="display-6 mb-4">장바구니 <span class="fw-normal">합계</span></a>
              <div class="d-flex justify-content-between mb-4">
                <h5 class="mb-0 me-4"></h5>
                <p class="mb-0">얼른 사주세요!</p>
              </div>
              <div class="d-flex justify-content-between">
                <h5 class="mb-0 me-4"></h5>
                <div class="">
                  <p class="mb-0"></p>
>>>>>>> branch 'main' of https://github.com/dbswl2650/Fashion.git
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  <span class="text-black">Subtotal</span>
                </div>
                <div class="col-md-6 text-right">
                  <strong class="text-black">$230.00</strong>
                </div>
              </div>
              <div class="row mb-5">
                <div class="col-md-6">
                  <span class="text-black">Total</span>
                </div>
                <div class="col-md-6 text-right">
                  <strong class="text-black">$230.00</strong>
                </div>
              </div>

              <div class="row">
                <div class="col-md-12">
                  <button class="btn btn-secondary btn-lg py-3 btn-block" onclick="window.location='checkout.html'">결재하기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>



<jsp:include page="./footer.jsp"></jsp:include>