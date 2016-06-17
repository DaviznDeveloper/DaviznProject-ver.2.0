$(function() {
	// 로그인 페이지 - 연락처 중복 체크 및 유효성 검사
	$('#nickname').keyup(function() {
		$.ajax({
			type : 'post',
			url : 'join/checkNickname.dvn',
			data : {
				nickname : $('#nickname').val()
			},
			success : function(data) {
				console.log(data);
				$('#checknickname').text(data);
			},
			error : function(){
				alert("Check Error");
			}
		});
	});
	
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
	
	
});