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
							
						<div class="col-sm-4">
							<h3>현재까지 가입한 회원 [] 명</h3>
						</div>
						
						<div class="col-sm-4">
							<h3>현재까지 생성된 데이터 [] 건</h3>
						</div>
						
						<div class="col-sm-4">
							<h3>현재까지 생성된 그룹 [] 그룹</h3>
						</div>
						
						<div class="col-sm-6">
							<div id="chartdiv" style="width: 100%; height: 400px; background-color: #FFFFFF;" ></div>
						</div>
						
						<div class="col-sm-6">
							
						</div>
				
					</div>
				
				</div>
				
				<div id="push"></div>

<script src="${pageContext.request.contextPath}/resources/lib/amcharts/amcharts.js"></script>

<script type="text/javascript">
	AmCharts.makeChart("chartdiv",
		{
			"type": "serial",
			"categoryField": "category",
			"plotAreaBorderColor": "#FFFFFF",
			"startDuration": 1,
			"borderColor": "#FFFFFF",
			"color": "#FFFFFF",
			"theme": "light",
			"categoryAxis": {
				"gridPosition": "start"
			},
			"trendLines": [],
			"graphs": [
				{
					"balloonText": "[[title]] of [[category]]:[[value]]",
					"bullet": "round",
					"id": "AmGraph-1",
					"minBulletSize": 3,
					"tabIndex": 0,
					"title": "graph 1",
					"type": "smoothedLine",
					"valueField": "column-1"
				},
				{
					"balloonText": "[[title]] of [[category]]:[[value]]",
					"bullet": "square",
					"id": "AmGraph-2",
					"title": "graph 2",
					"type": "smoothedLine",
					"valueField": "column-2"
				}
			],
			"guides": [],
			"valueAxes": [
				{
					"id": "ValueAxis-1",
					"title": "Axis title"
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
					"color": "#000000",
					"id": "Title-1",
					"size": 15,
					"text": "Chart Title"
				}
			],
			"dataProvider": [
				{
					"category": "category 1",
					"column-1": 8
				},
				{
					"category": "category 2",
					"column-1": 6
				},
				{
					"category": "category 3",
					"column-1": 2
				},
				{
					"category": "category 4",
					"column-1": 1
				},
				{
					"category": "category 5",
					"column-1": 2
				},
				{
					"category": "category 6",
					"column-1": 3
				},
				{
					"category": "category 7",
					"column-1": 6
				}
			]
		}
	);
</script>
