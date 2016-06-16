
$(function() {
	$(".pieProgress").asPieProgress({
		namespace: 'asPieProgress',
	    min: 0,
	    max: 100,
	    goal: 100,
	    speed: 30,
	    easing: 'linear',
	    barcolor: '#2dbe60'
	});
	
	$(".pieProgress").asPieProgress("start");
	
	// bootstrap-datepicker
	$('#datetimepicker1').datetimepicker();
	$('#datetimepicker2').datetimepicker();
	
	$("#datetimepicker1").on("dp.change", function (e) {
        $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker2").on("dp.change", function (e) {
        $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
    });
	
	$(".gorl-check-create").click(function() {
		var gorlCheckList = $(".gorl-Check-List-Box").children();
		console.log(gorlCheckList);
		console.log(gorlCheckList.length);
		
		if(gorlCheckList.length < 10) {
			
			$('<div class="gorl-check-input-box">' +
					'<input type="text" name="gorlCheckList" class="form-control gorlCheckList margin-bottom-10" placeholder="세부 목표를 입력하세요">' +
					'<button type="button" class="close gorl-check-input-box-close" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
					'</div>').appendTo(".gorl-Check-List-Box").click(function() {
				$('.gorl-check-input-box-close').click(function() {
					$(this).parent().remove();
				});
			});
			
		}
	});
	
	$(".gorl-check-input-box-close").click(function() {
		var close = $(".gorl-check-input-box-close");
		console.log(close);
		
		if(close > 1) {
			$(this).parent().remove();
		} else {
			return false;
		}
	});
	
	// gorl-save
	$(".gorl-save").click(function() {
		var checklist = $("input[name=gorlCheckList]");
		console.log(checklist);
		console.log(checklist.length);
		
		$.each(checklist, function(index, obj) {
			$(obj).attr('name','gorlCheckList'+index);
		});
		
	});
	
	// gorl-detail-checklist
	$(".gorl-detail-checkbox").change(function(){
        if($(this).is(":checked")){
            $(this).parent().css('background','#9cff80');
            $(this).parent().css('border','1px solid #2dbe60');
            $(this).parent().siblings().css('border','1px solid #2dbe60');
            gorlChecking();
        }else{
        	$(this).parent().css('background','#eee');
        	$(this).parent().css('border','1px solid #ccc');
        	$(this).parent().siblings().css('border','1px solid #ccc');
        	gorlChecking();
        }
	});
	
});