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
		
//		$(json).each(function(i) {
//
//			var rows = "row" + i
//			
//			jsonObject = {
//					rows : json[i]
//			}
//			
//		});
		
//		jsonObject = {
//				"rows1" : json[0],
//				"rows2" : json[1],
//				"rows3" : json[2]
//		};
		
		console.log(json);
		console.log(json[0][0]);
		
		
		/*
		$.ajax({
			url : '',
			type: 'POST',
			data: { 
				ajax: true,
				data: eTable.getJsonData()
			},
			beforeSend: function(){
		        $('.loading-container').removeClass('display-none');
		    },
		    complete: function(data){
		        //console.log(JSON.parse(data.responseText));
		        $('.loading-container').addClass('display-none');
		 
		    },
		    success: function(data){
		    	console.log(data);
		    },
		    error: function(e){
				
		    },
		    timeout: 10000
		});
		*/
		return false;
	});
	
	// amcharts 그리기
    var chart = AmCharts.makeChart("chartdiv", {
        "type": "serial",
        "theme": "light",
        "dataDateFormat": "YYYY-MM-DD",
        "dataProvider": [{
            "date": "2013-11-30",
            "value": 104
        }, {
            "date": "2013-12-01",
            "value": 108
        }, {
            "date": "2013-12-02",
            "value": 103
        }, {
            "date": "2013-12-03",
            "value": 105
        }, {
            "date": "2013-12-04",
            "value": 136
        }, {
            "date": "2013-12-05",
            "value": 138
        }, {
            "date": "2013-12-06",
            "value": 113
        }, {
            "date": "2013-12-07",
            "value": 131
        }, {
            "date": "2013-12-08",
            "value": 114
        }, {
            "date": "2013-12-09",
            "value": 124
        }],
        "valueAxes": [{
            "maximum": 140,
            "minimum": 100,
            "axisAlpha": 0,
            "guides": [{
                "fillAlpha": 0.1,
                "fillColor": "#CC0000",
                "lineAlpha": 0,
                "toValue": 120,
                "value": 0
            }, {
                "fillAlpha": 0.1,
                "fillColor": "#0000cc",
                "lineAlpha": 0,
                "toValue": 200,
                "value": 120
            }]
        }],
        "graphs": [{
            "bullet": "round",
            "dashLength": 4,
            "valueField": "value"
        }],
        "chartCursor": {
            "cursorAlpha": 0,
            "zoomable":false,
            "valueZoomable":true
        },
        "categoryField": "date",
        "categoryAxis": {
            "parseDates": true
        },
        "valueScrollbar":{

        }
    });
    
    $("#bar-chart-btn").click(function() {
    	
    });

	
});