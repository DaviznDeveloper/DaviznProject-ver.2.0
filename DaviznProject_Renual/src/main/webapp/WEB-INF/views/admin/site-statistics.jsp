<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
				
					<div class="col-sm-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
							<li class="active">사이트 통계</li>
						</ol>
						
						<div class="col-sm-12 margin-bottom-50">
							<div class="col-sm-4 no-padding">
								<h3>현재까지 가입한 회원 [${membercount}] 명</h3>
							</div>
							
							<div class="col-sm-4 no-padding">
								<h3>현재까지 생성된 데이터 [${datacount}] 건</h3>
							</div>
							
							<div class="col-sm-4 no-padding">
								<h3>현재까지 생성된 그룹 [${groupcount}] 그룹</h3>
							</div>
						</div>
						
						<div class="col-sm-6">
							<div class="col-sm-12">
								<div class="panel panel-primary">
									<div class="panel-body">
										<select class="form-control width-200 pull-right" id="Linechart">
											<option value="1">일별 통계</option>
											<option value="2">주별 통계</option>
											<option value="3">월별 통계</option>
										</select>
										<div id="chartdiv" style="width: 100%; height: 400px; background-color: #FFFFFF;" ></div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="col-sm-6">
							<div class="col-sm-12">
								<div class="panel panel-primary">
									<div class="panel-body">
										<select class="form-control width-200 pull-right" id="piechart">
											<option value="1">일별 통계</option>
											<option value="2">주별 통계</option>
											<option value="3">월별 통계</option>
										</select>
										<div id="chartdiv2" style="width: 100%; height: 400px; background-color: #FFFFFF;" ></div>
									</div>
								</div>
							</div>
						</div>
				
					</div>
				
				</div>
				
				<div id="push"></div>

<script src="${pageContext.request.contextPath}/resources/lib/amcharts/amcharts.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/amcharts/serial.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/amcharts/pie.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/amcharts/themes/light.js"></script>

<script type="text/javascript">
	$(function() {
		///////////페이지 로드되면 뿌려지는 파이차트 스크립트////////
		var loadLineChart=JSON.parse('${dailyLineChart}');
		
				AmCharts.makeChart("chartdiv2",
        						{
        							"type": "pie",
        							"balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
        							"titleField": "datatype",
        							"valueField": "datacount",
        							"accessibleTitle": "",
        							"theme": "light",
        							"allLabels": [],
        							"balloon": {},
        							"legend": {
        								"enabled": true,
        								"align": "center",
        								"markerType": "circle"
        							},
        							"titles": [
        								{
        									"id": "",
        									"text": "데이터 종류별 누계"
        								}
        							],
        							"dataProvider": [{
        								"datatype": "노트형 데이터",
        								"datacount": '${dailyPieChart[0].datacount}'
        							},
        							{
        								"datatype": "스케치형 데이터",
        								"datacount": '${dailyPieChart[1].datacount}'
        							},
        							{
        								"datatype": "일정관리 데이터",
        								"datacount": '${dailyPieChart[2].datacount}'
        							},
        							{
        								"datatype": "목표관리 데이터",
        								"datacount": '${dailyPieChart[3].datacount}'
        							}]
        						}
        					);
		////////////////////////////////////////////
		/////////페이지 로딩되면 뿌려지는 막대 차트 스크립트//////
		AmCharts.makeChart("chartdiv",
        						{
        							"type": "serial",
        							"categoryField": "day",
        							"dataDateFormat": "",
        							"startDuration": 1,
        							"theme": "light",
        							"categoryAxis": {
        								"gridPosition": "start"
        							},
        							"chartScrollbar": {
        								"enabled": true
        							},
        							"trendLines": [],
        							"graphs": [
        								{
        									"balloonText": "[[title]] of [[category]]:[[value]]",
        									"bullet": "round",
        									"fillAlphas": 0.12,
        									"fillColors": "#1457F4",
        									"fillColorsField": "category",
        									"gapPeriod": 3,
        									"id": "AmGraph-1",
        									"legendColor": "#FFFFFF",
        									"markerType": "square",
        									"periodSpan": 0,
        									"tabIndex": 0,
        									"title": "일 별 데이터 누계",
        									"type": "smoothedLine",
        									"valueField": "daycount"
        								}
        							],
        							"guides": [],
        							"valueAxes": [
        								{
        									"id": "ValueAxis-2"
        								}
        							],
        							"allLabels": [],
        							"balloon": {},
        							"legend": {
        								"enabled": true,
        								"useGraphSettings": true
        							},
        							"titles": [
        								{
        									"id": "Title-1",
        									"size": 15,
        									"text": "총 데이터 누계"
        								}
        							],
        							"dataProvider": loadLineChart
        						}
        					);
		/////////////////////////////////////////////
		$('#Linechart').change(function(){
			var LineValue=$('#Linechart').val();
			var contextPath='${pageContext.request.contextPath}' 
			var ControllerPath;
			var graphTitle;
			
			if(LineValue==1){
				ControllerPath="/admin/dailyLineChart.dvn"
				graphTitle='일 별 데이터 누계'
			}else if(LineValue==2){
				ControllerPath="/admin/weeklyLineChart.dvn"
				graphTitle='주 별 데이터 누계'
			}else{
				ControllerPath="/admin/monthlyLineChart.dvn"
				graphTitle='월 별 데이터 누계'
			}
			
		
		$.ajax({
       				url : contextPath+ControllerPath,
        			type: "post",
        			success : function(data){
        				var lineChart = data;
        				
        				AmCharts.makeChart("chartdiv",
        						{
        							"type": "serial",
        							"categoryField": "day",
        							"dataDateFormat": "",
        							"startDuration": 1,
        							"theme": "light",
        							"categoryAxis": {
        								"gridPosition": "start"
        							},
        							"chartScrollbar": {
        								"enabled": true
        							},
        							"trendLines": [],
        							"graphs": [
        								{
        									"balloonText": "[[title]] of [[category]]:[[value]]",
        									"bullet": "round",
        									"fillAlphas": 0.12,
        									"fillColors": "#1457F4",
        									"fillColorsField": "category",
        									"gapPeriod": 3,
        									"id": "AmGraph-1",
        									"legendColor": "#FFFFFF",
        									"markerType": "square",
        									"periodSpan": 0,
        									"tabIndex": 0,
        									"title": graphTitle,
        									"type": "smoothedLine",
        									"valueField": "daycount"
        								}
        							],
        							"guides": [],
        							"valueAxes": [
        								{
        									"id": "ValueAxis-2"
        								}
        							],
        							"allLabels": [],
        							"balloon": {},
        							"legend": {
        								"enabled": true,
        								"useGraphSettings": true
        							},
        							"titles": [
        								{
        									"id": "Title-1",
        									"size": 15,
        									"text": "총 데이터 누계"
        								}
        							],
        							"dataProvider": lineChart
        						}
        					);
        			}
    			});
			
			
			
		});
		
		///////////////파이 차트////////////////////////////////////
		$('#piechart').change(function(){
			
			var chartvalue=$('#piechart').val();
			var contextPath='${pageContext.request.contextPath}' 
			var ControllerPath;
			var piechartList;
			
			if(chartvalue==1){
				ControllerPath="/admin/dailyPieChart.dvn"
			}else if(chartvalue==2){
				ControllerPath="/admin/weekPiechart.dvn"
			}else{
				ControllerPath="/admin/monthPieChart.dvn"
			}
			
			
			$.ajax({
        			url : contextPath+ControllerPath,
        			type: "post",
        			success : function(data){
        				piechartList = data;
        				
        				AmCharts.makeChart("chartdiv2",
        						{
        							"type": "pie",
        							"balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
        							"titleField": "category",
        							"valueField": "column-1",
        							"accessibleTitle": "",
        							"theme": "light",
        							"allLabels": [],
        							"balloon": {},
        							"legend": {
        								"enabled": true,
        								"align": "center",
        								"markerType": "circle"
        							},
        							"titles": [
        								{
        									"id": "",
        									"text": "데이터 종류별 누계"
        								}
        							],
        							"dataProvider": [{
        								"category": "노트형 데이터",
        								"column-1": piechartList[0].datacount
        							},
        							{
        								"category": "스케치형 데이터",
        								"column-1": piechartList[1].datacount
        							},
        							{
        								"category": "일정관리 데이터",
        								"column-1": piechartList[2].datacount
        							},
        							{
        								"category": "목표관리 데이터",
        								"column-1": piechartList[3].datacount
        							}]
        						}
        					);
        				
        			}
    			});//ajax 종료
    			
			
		});//onchange 종료
		
	
	});
	
</script>
