$(function() {
	// 로그인 페이지 - 연락처 중복 체크 및 유효성 검사
	$('#userid').keyup(function() {
		$.ajax({
			type : 'post',
			url : 'join/checkUserid.dvn',
			data : {
				userid : $('#userid').val()
			},
			success : function(data) {
				console.log(data);
				$('#checkuserid').text(data);
			},
			error : function(){
				alert("Check Error");
			}
		});
	});
	
	$('#account').keyup(function() {
		$.ajax({
			type : 'post',
			url : 'join/checkAccount.dvn',
			data : {
				account : $('#account').val()
			},
			success : function(data) {
				console.log(data);
				$('#checkaccount').text(data);
			},
			error : function(){
				alert("Check Error");
			}
		});
	});
	
	
});