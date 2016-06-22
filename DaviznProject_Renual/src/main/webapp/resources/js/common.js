$(function() {

	//본문 컨테이너 마진-탑 자동 조정
	var header_height = $(".navbar").height();
	$(".content-container").css('margin-top', header_height);
	$("#sidebar-wrapper").css('margin-top', header_height);
	$(window).resize(function() {
		var header_height = $(".navbar").height();
		$(".content-container").css('margin-top', header_height);
		$("#sidebar-wrapper").css('margin-top', header_height);
	});
	
	// 툴팁
	$('[data-toggle="tooltip"]').tooltip();
	
	// 프로필 사진 업로드
	$("#profile-thum-modi").click(function() {
		event.preventDefault();
		$("#uploadImage").click();
	});
	$("#uploadImage").change(function(){
	    readUploadImage(this);
	});
	
	// 데이터 저장소 마우스 오버 효과
	$(".data-repo-btn").hover(
		function() {
			$(this).children().remove();
			$(this).append().html(
				"<i class='fa fa-folder-open-o data-repo-icon' aria-hidden='true'></i>"	
			);
		},
		function() {
			$(this).children().remove();
			$(this).append().html(
				"<i class='fa fa-folder-o data-repo-icon' aria-hidden='true'></i>"	
			);
		}
	);
	$(".data-repo-create-btn, .data-dash-create-btn").hover(
		function() {
			$(this).children().css('color','#fff');
		},
		function() {
			$(this).children().css('color','#e3e3e3');
		}
	);
	
	// 대시보드 마우스 오버 효과
	$(".data-dash-btn").hover(
		function() {
			$(this).children().remove();
			$(this).append().html(
				"<i class='fa fa-object-group data-dash-icon' aria-hidden='true'></i>"	
			);
		},
		function() {
			$(this).children().remove();
			$(this).append().html(
					"<i class='fa fa-object-ungroup data-dash-icon' aria-hidden='true'></i>"	
			);
		}
	);
	
});







// 프로필 사진 업로드 호출 함수
function readUploadImage( inputObject ) {

	if ( window.File && window.FileReader ) {

		/* 입력된 파일이 1개 이상 있는지 확인 */
		if ( inputObject.files && inputObject.files[0]) {

			/* 이미지 파일인지도 체크  */
			if ( !(/image/i).test(inputObject.files[0].type ) ){
				alert("이미지 파일을 선택해 주세요!");
				return false;
			}

			/* FileReader */

			var reader = new FileReader();

			reader.onload = function (e) {
				$('#profile-preview').attr('src', e.target.result);
			}

			/* input file에 있는 파일 하나를 읽어온다. */
			reader.readAsDataURL(inputObject.files[0]);
			
		}

	} else {
		alert( "지원하지 않는 브라우저 입니다.");
	}

}