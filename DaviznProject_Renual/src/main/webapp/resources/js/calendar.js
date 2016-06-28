$(function() {
	$('#myswitch').switchable({
		
		click: function( ev, checked ) {
			if ($("#datetimepicker3").children('input').attr('disabled')) {
		        $("#datetimepicker3").children('input').removeAttr('disabled');
		    } else {
		        $("#datetimepicker3").children('input').attr('disabled', 'disabled');
		    }
            //$("#datetimepicker3").fadeToggle();
        }
		
	});
	
	$('.myswitch-list').switchable({
		
		
		
	});
	
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
		format: 'MM/DD/YYYY HH:mm',
		defaultDate: output + " " + NowTime
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
	
	$('#datetimepicker3').datetimepicker({
		format: 'MM/DD/YYYY HH:mm',
		defaultDate: output + " " + NowTime,
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            up: "fa fa-arrow-up",
            down: "fa fa-arrow-down"
        }
    });
	
	$(".calender-priority").click(function() {
		$(".calender-priority").children('input[type="radio"]').attr('checked',false);
		$(this).children('input[type="radio"]').attr('checked',true);
	});
});