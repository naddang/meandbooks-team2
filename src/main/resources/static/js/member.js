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
            document.getElementById('mem_addr1').value = data.zonecode;

            if (roadAddr !== '') {
                document.getElementById('mem_addr2').value = roadAddr;
                document.getElementById('mem_addr3').value = "";
            }else if (jibunAddr !== '') {
                document.getElementById('mem_addr2').value = jibunAddr;
                document.getElementById('mem_addr3').value = "";
            }
        }
    }).open();
}


function registerCheck(){
    function fn_submit() {
        var email = document.getElementById('email').value;

        var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
        if (regEmail.test(text) === true) {
            alert('입력된 값은 이메일입니다.');
        }
    }
    // 아이디
    if(register.mem_uid.value.length == 0){
        alert("아이디를 입력해주세요.");
        register.mem_uid.focus();
        return;
    }

    // 비밀번호
    if(register.mem_pwd.value.length == 0){
        alert("비밀번호를 입력해주세요.");
        register.mem_pwd.focus();
        return;
    }


    // 이름
    if(register.mem_nm.value.length == 0){
        alert("이름을 입력해주세요.");
        register.mem_nm.focus();
        return;
    }


    // 전화번호
    if(register.mem_phoneno.value.length == 0){
        alert("전화번호를 입력해주세요.");
        register.mem_phoneno.focus();
        return;
    }

    // 주소
    if(register.mem_addr1.value.length == 0){
        alert("주소를 입력해주세요.");
        register.mem_addr1.focus();
        return;
    }
    if(register.mem_addr2.value.length == 0){
        alert("주소를 입력해주세요.");
        register.mem_addr2.focus();
        return;
    }
    if(register.mem_addr3.value.length == 0){
        alert("상세주소를 입력해주세요.");
        register.mem_addr3.focus();
        return;
    }

    // 이메일

    if(register.mem_email.value.length == 0){
        alert("이메일을 입력해주세요.");
        register.mem_email.focus();
        return;
    }

    if(!register.mem_uid.hasAttribute('readonly')){
        alert("아이디 중복체크를 해주세요.");
        register.mem_email.focus();
        return;
    }
    document.register.submit();

}
function loginCheck(){
    if(document.login.mem_uid.value.length == 0){
        alert("아이디를 입력하세요");
        login.mem_uid.focus();
        return;
    }

    if(document.login.mem_pwd.value.length == 0){
        alert("비밀번호를 입력하세요");
        login.mem_pwd.focus();
        return;
    }
    document.login.submit();
}

function updateCheck(){
    if(update.mem_pwd.value.length == 0){
        alert("현재 비밀번호를 입력해주세요");
        update.mem_pwd.focus();
        return;
    }

    if(update.new_mem_pwd.value.length == 0){
        alert("변경할 비밀번호를 입력해주세요");
        update.new_mem_pwd.focus();
        return;
    }

    if(update.mem_addr1.value.length == 0){
        alert("주소를 입력해주세요");
        update.mem_addr3.focus();
        return;
    }
    if(update.mem_addr2.value.length == 0){
        alert("주소를 입력해주세요");
        update.mem_addr3.focus();
        return;
    }
    if(update.mem_addr3.value.length == 0){
        alert("상세주소를 입력해주세요");
        update.mem_addr3.focus();
        return;
    }

    if(update.mem_email.value.length == 0){
        alert("변경할 이메일을 입력해주세요");
        update.new_mem_pwd.focus();
        return;
    }
    document.update.submit();
}

function winOpen() {
    var left = Math.ceil((window.screen.width - 400)/2);
    var top = Math.ceil((window.screen.height - 200)/2);
    //새창을 열어서 페이지를 오픈 후, 회원 아이디 정보를 가지고 중복체크
    if (register.mem_uid.value.trim() =="" || register.mem_uid.value.trim().length < 0) {
        alert("아이디는 반드시 입력해야합니다.")
        register.mem_uid.focus();
    }else {
        window.open("/member/registerCheckId?mem_uid="+register.mem_uid.value,"", "width="+400+", height="+200+", left="+left+", top="+top );
    }
}

function result() {
    opener.document.register.mem_uid.readOnly=true;

    window.close();
}





