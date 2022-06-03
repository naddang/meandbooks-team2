function insertCart(){
    var qty = $('#qty').val();
    var book_no = $('#book_no').val();
    location.href="/mall/insertCart?book_no=" + book_no + "&cart_qty="+ qty;
}

function goOrder(){
    var qty = $('#qty').val();
    var book_no = $('#book_no').val();
    location.href="/orders/ordersPage?book_no=" + book_no + "&cart_qty="+ qty;
}
