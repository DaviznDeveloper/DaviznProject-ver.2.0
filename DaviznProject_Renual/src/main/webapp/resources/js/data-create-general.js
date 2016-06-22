$(function() {

	// 차트 데이터 생성
	var eTable = $('#edittable').editTable({
		data: [
			["칸 또는 줄에 있는 +버튼을 클릭하여 추가해보세요"]
		]
	});

	// Load json data trough an ajax call
	$('.loadjson').click(function () {
		var _this = $(this),text = $(this).text();
		$(this).text('Loading...');
		$.ajax({
			url : '',
			type: 'POST',
			data: { ajax: true },
			complete: function (result) {
				_this.text(text);
				eTable.loadJsonData(result.responseText);
			}
		});
		return false;
	});

	// Reset table data
	$('.reset').click(function () {
		eTable.reset();
		return false;
	});

	// Send JSON data trough an ajax call
	$('.sendjson').click(function () {
		
		var json = eTable.getJsonData();
		
		var jsonObject = {};
		

		console.log(json);
		console.log(json[0][0]);
		
		

		return false;
	});

});