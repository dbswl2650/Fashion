// 더하기 아이콘 클릭 등록.
    document.querySelectorAll('i.fa-plus').forEach(plusIcon => {
      plusIcon.addEventListener('click', (e) => {
        // console.dir(e.target.closest('div.quantity').children[1].value);

        let pcode = e.target.closest('tr').getAttribute('data-pcode');

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
        saveQty(logId, pcode, 1);
		
		
      });
    });

    // 빼기 아이콘 클릭 등록.
    document.querySelectorAll('i.fa-minus').forEach(minusIcon => {
      minusIcon.addEventListener('click', (e) => {
        console.dir(e.target.closest('div.quantity').children[1].value);
        
        let pcode = e.target.closest('tr').getAttribute('data-pcode');

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
        saveQty(logId, pcode, -1);
      });
    });