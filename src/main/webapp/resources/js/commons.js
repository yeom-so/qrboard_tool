$(document).ready(function() {

})

function login_chk(){
	//실패시
	alert("아이디나 비밀번호를 확인해주세요.");

	//성공시
	//location.href='';
}
//로그인 확인

function chk_agree(){
	if(!$("#chk_all").is(":checked")){
		alert('사용약관에 동의해주세요.');
	}else{
		location.href='join2.html';
	}
}
//회원가입 약관 동의체크

function join_result(){
	if($("#pwd").val()!=$("#pwdre").val()){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}else {
		alert("회원가입이 완료되었습니다.");
	}
}
//회원가입 결과

function fnMove(seq){
			var offset = $(seq).offset();
			$('html, body').animate({scrollTop : offset.top-130}, 400);
}

function fnback(n){
	history.back();
}
function loca(n){
	location.href=n;
}
