// 옷 정보 카드 읽기
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
	document.querySelector('article').innerHTML += cardHtml;
}

// 옷 정보 카드 삭제
function deleteCard(rno) {
	fetch('removeReply.do?rno=' + rno)
	.then(result => result.json())
	.then(result => {
		if (result.retCode == 'OK') {
			alert("삭제에 성공했습니다.");
			document.querySelector('li[data-rno="' + rno + '"]').remove();
		}
		else {
			alert("삭제에 실패했습니다.");
		}
	})
	.catch(err => console.log(err));
}


/* fetch('main.ko')
.then(result => result.json())
.then(result => {
	document.querySelector('article').innerHTML += '<div>';
	
	let count = 0;
	for (let cloth of result) {
		selectCard(cloth);
		if (count % 5 == 4) {
			document.querySelector('article').innerHTML += '</div><div>';
		}
	}
	
	document.querySelector('article').innerHTML += '</div>';
})
.catch(err => console.log(err)); */