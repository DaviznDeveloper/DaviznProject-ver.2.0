
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
	
	var d = new Date();

	var month = d.getMonth()+1;
	var day = d.getDate();

	var output = d.getFullYear() + '/' +
	(month<10 ? '0' : '') + month + '/' +
	(day<10 ? '0' : '') + day;
	

	var Now = new Date();
	var NowTime = Now.getHours();
	NowTime += ':' + Now.getMinutes();
	NowTime += ':' + Now.getSeconds();

	// bootstrap-datepicker
	$('#datetimepicker1').datetimepicker({
		format : 'MM/DD/YYYY HH:mm',
		defaultDate : output + " " + NowTime
	});
	   
	$('#datetimepicker2').datetimepicker({
		format: 'MM/DD/YYYY HH:mm',
		defaultDate: output + " 23:59:00"
	});
	
	$("#datetimepicker1").on("dp.change", function (e) {
        $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker2").on("dp.change", function (e) {
        $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
    });
	
	$(".goal-check-create").click(function() {
		var goalCheckList = $(".goal-Check-List-Box").children();
		console.log(goalCheckList);
		console.log(goalCheckList.length);
		
		if(goalCheckList.length < 10) {
			
			$('<div class="goal-check-input-box">' +
					'<input type="text" name="detailnames" class="form-control goalCheckList margin-bottom-10" placeholder="세부 목표를 입력하세요">' +
					'<button type="button" class="close goal-check-input-box-close" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
					'</div>').appendTo(".goal-Check-List-Box").click(function() {
				$('.goal-check-input-box-close').click(function() {
					$(this).parent().remove();
				});
			});
			
		}
	});
	
	$(".goal-check-input-box-close").click(function() {
		var close = $(".goal-check-input-box-close");
		console.log(close);
		
		if(close > 1) {
			$(this).parent().remove();
		} else {
			return false;
		}
	});
	
	// goal-save
	$(".goal-save").click(function() {
		var checklist = $("input[name=detailnames]");
		console.log(checklist);
		console.log(checklist.length);
		/*
		$.each(checklist, function(index, obj) {
			$(obj).attr('name','goalCheckList'+index);
		});
		*/
	});
	
	// goal-detail-checklist
	$(".goal-detail-checkbox").change(function(){
        if($(this).is(":checked")){
            $(this).parent().css('background','#9cff80');
            $(this).parent().css('border','1px solid #2dbe60');
            $(this).parent().siblings().css('border','1px solid #2dbe60');
            goalChecking();
        }else{
        	$(this).parent().css('background','#eee');
        	$(this).parent().css('border','1px solid #ccc');
        	$(this).parent().siblings().css('border','1px solid #ccc');
        	goalChecking();
        }
	});
	
});