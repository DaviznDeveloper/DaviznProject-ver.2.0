$(function() {
	// 회원가입 - 아이디 체크 및 유효성 검사
	$('#userid').keyup(function() {
		$.ajax({
			type : 'post',
			url : 'join/checkUserid.dvn',
			data : {
				userid : $('#userid').val()
			},
			success : function(data) {
				console.log(data);
				var reg = /^[A-Za-z0-9]{6,12}$/;
				var val_chk = $("#userid").val();
				if(data == "can id"){

					if (reg.test(val_chk)) {
						$('#checkuserid').html('<b>사용 가능한 아이디 입니다.</b>').css('color', 'blue');
					} else {
						$('#checkuserid').html('<b>6~12자리의 영어 또는 영어\+숫자를 입력하셔야 합니다.</b>').css('color', '#ff0053');
						$("#userid").focus();
					}
				}else if(data == "can't id"){
					if (reg.test(val_chk)) {
						$('#checkuserid').html('<b>이미 존재하는 아이디 입니다.</b>').css('color', 'red');
						$("#userid").focus();
					} else {
						$('#checkuserid').html('<b>6~12자리의 영어 또는 영어\+숫자를 입력하셔야 합니다.</b>').css('color', '#ff0053');
						$("#userid").focus();
					}
				}
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
				var reg = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
				var val_chk = $("#account").val();
				if(data == "can email"){
					if (reg.test(val_chk)) {
						$('#checkaccount').html('<b>사용 가능한 이메일입니다.</b>').css('color', 'blue');
					} else {
						$('#checkaccount').html('<b>올바른 이메일 형식을 입력하셔야 합니다.</b>').css('color', '#ff0053');
						$("#account").focus();
					}
				}else if(data == "can't email"){
					if (reg.test(val_chk)) {
						$('#checkaccount').html('<b>이미 존재하는 이메일입니다.</b>').css('color', 'red');
						$("#account").focus();
					} else {
						$('#checkaccount').html('<b>6~12자리의 영어 또는 영어\+숫자를 입력하셔야 합니다.</b>').css('color', '#ff0053');
						$("#account").focus();
					}
				}
			},
			error : function(){
				alert("Check Error");
			}
		});
	});
	
	
	$('#password').keyup(function() {
		var reg = /^[A-Za-z0-9]{7,14}$/;
		var val_chk = $("#password").val();
		
		if (reg.test(val_chk)) {
			$('#checkpwd').html('<b>사용 가능한 비밀번호 입니다.</b>').css('color', 'blue');
		} else {
			$('#checkpwd').html('<b>7~14자리의 영어 또는 영어\+숫자를 입력하셔야 합니다.</b>').css('color', '#ff0053');
			$("#password").focus();
		}
	});
	
	$('#phone').keyup(function() {
		var reg = /^[0-9]{8,11}$/;
		var val_chk = $("#phone").val();
		
		if (reg.test(val_chk)) {
			$('#checkphone').html('<b>사용 가능한 비밀번호 입니다.</b>').css('color', 'blue');
		} else {
			$('#checkphone').html('<b>\'-\'를 제외한 지역번호 또는 핸드폰 앞자리를 포함하는 올바른 번호를 입력하셔야 합니다.</b>' ).css('color', '#ff0053');
			$("#phone").focus();
		}
	});
	
	
	
});