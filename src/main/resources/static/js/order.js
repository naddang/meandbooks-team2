function iamport(){
    //가맹점 식별코드
    IMP.init('imp37252376');

    //폼에서 보내준 값들
    var userName = $("#orders_nm").val();
    var userPhoneNum = $("#orders_phoneno").val();
    var addr1 = $("#orders_addr1").val();
    var addr2 = $("#orders_addr2").val()+$("#orders_addr3").val();
    var email = $("#orders_email").val();
    var bookName = $("#book_nm").text();
    var orders_qty = $("#orders_qty").val();
    var bookPrice = $("#book_price").val();
    var amount = orders_qty * bookPrice

    IMP.request_pay({
        pg : 'inicis',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : bookName , //결제창에서 보여질 이름
        amount : amount, //실제 결제되는 가격
        buyer_email : email,
        buyer_name : userName,
        buyer_tel : userPhoneNum,
        buyer_addr : addr2,
        buyer_postcode : addr1,
    }, function(rsp) {
        console.log(rsp);
        if ( rsp.success ) {
            var msg = '결제가 완료되었습니다.';
            document.orderForm.submit();
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }

        alert(msg);

    });
}
function iAmPortPost(){
    //가맹점 식별코드
    IMP.init('imp37252376');

    //폼에서 보내준 값들
    var userName = $("#orders_nm").val();
    var userPhoneNum = $("#orders_phoneno").val();
    var addr1 = $("#orders_addr1").val();
    var addr2 = $("#orders_addr2").val()+$("#orders_addr3").val();
    var email = $("#orders_email").val();
    var bookName = $("#book_nm").text()+ ' 외 '+($("#amount").val() - 1) +'권';
    var sum = $("#sum").val();

    IMP.request_pay({
        pg : 'inicis',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : bookName , //결제창에서 보여질 이름
        amount : sum, //실제 결제되는 가격
        buyer_email : email,
        buyer_name : userName,
        buyer_tel : userPhoneNum,
        buyer_addr : addr2,
        buyer_postcode : addr1,
    }, function(rsp) {
        console.log(rsp);
        if ( rsp.success ) {
            var msg = '결제가 완료되었습니다.';
            document.orderForm.submit();
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }

        alert(msg);

    });
}
function findAddr(){
    new daum.Postcode({
        oncomplete: function(data) {

            console.log(data);
            //팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            //도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            //내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다
            var roadAddr = data.roadAddress; //도로명 주소 변수
            var jibunAddr = data.jibunAddress; //지번 주소 변수

            //우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('orders_addr1').value = data.zonecode;

            if (roadAddr !== '') {
                document.getElementById('orders_addr2').value = roadAddr;
                document.getElementById('orders_addr3').value = "-";
            }else if (jibunAddr !== '') {
                document.getElementById('orders_addr2').value = jibunAddr;
                document.getElementById('orders_addr3').value = "-";
            }
        }
    }).open();
}