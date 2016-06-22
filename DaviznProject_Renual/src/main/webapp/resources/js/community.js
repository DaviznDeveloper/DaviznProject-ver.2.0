$(function() {
	
	var pager = $(".pagination").children('.board-pager');
	
	pager.click(function() {
		$(this).addClass('active');
		pager.not($(this)).removeClass('active');
	});
	
});

