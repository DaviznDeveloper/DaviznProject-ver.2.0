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
								<h3>현재까지 가입한 회원 [] 명</h3>
							</div>
							
							<div class="col-sm-4 no-padding">
								<h3>현재까지 생성된 데이터 [] 건</h3>
							</div>
							
							<div class="col-sm-4 no-padding">
								<h3>현재까지 생성된 그룹 [] 그룹</h3>
							</div>
						</div>
						
						<div class="col-sm-6">
							<div class="col-sm-12">
								<div class="panel panel-primary">
									<div class="panel-body">
										<select class="form-control width-200 pull-right">
											<option>일별 통계</option>
											<option>주별 통계</option>
											<option>월별 통계</option>
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
										<select class="form-control width-200 pull-right">
											<option>일별 통계</option>
											<option>주별 통계</option>
											<option>월별 통계</option>
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
		AmCharts.makeChart("chartdiv",
			{
				"type": "serial",
				"categoryField": "category",
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
						"title": "graph 1",
						"type": "smoothedLine",
						"valueField": "column-1"
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
				"dataProvider": [
					{
						"category": "1",
						"column-1": 8
					},
					{
						"category": "2",
						"column-1": 6
					},
					{
						"category": "3",
						"column-1": 2
					},
					{
						"category": "4",
						"column-1": 1
					},
					{
						"category": "5",
						"column-1": 2
					},
					{
						"category": "6",
						"column-1": 3
					},
					{
						"category": "7",
						"column-1": 6
					},
					{
						"category": "8",
						"column-1": "10"
					},
					{
						"category": "9",
						"column-1": "2"
					},
					{
						"category": "10",
						"column-1": "4"
					},
					{
						"category": "11",
						"column-1": "5"
					},
					{
						"category": "12",
						"column-1": "7"
					},
					{
						"category": "13",
						"column-1": "2"
					},
					{
						"category": "14",
						"column-1": "8"
					},
					{
						"category": "15",
						"column-1": "9"
					},
					{
						"category": "16",
						"column-1": "1"
					},
					{
						"category": "17",
						"column-1": "6"
					},
					{
						"category": "18",
						"column-1": "7"
					},
					{
						"category": "19",
						"column-1": "1"
					},
					{
						"category": "20",
						"column-1": "3"
					},
					{
						"category": "21",
						"column-1": "4"
					},
					{
						"category": "22",
						"column-1": "9"
					},
					{
						"category": "23",
						"column-1": "2"
					},
					{
						"category": "24",
						"column-1": "3"
					}
				]
			}
		);
		
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
				"dataProvider": [
					{
						"category": "노트형 데이터",
						"column-1": 8
					},
					{
						"category": "스케치형 데이터",
						"column-1": 6
					},
					{
						"category": "일정관리 데이터",
						"column-1": 2
					},
					{
						"category": "목표관리 데이터",
						"column-1": "3"
					}
				]
			}
		);
	});
	
</script>
