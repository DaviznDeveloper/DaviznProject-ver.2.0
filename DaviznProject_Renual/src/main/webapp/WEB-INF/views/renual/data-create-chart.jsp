<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/renual/header2.jsp"%>
				<!-- content -->
				<div class="loading-container">
					<img class="loading-img" src="${pageContext.request.contextPath}/resources/img/davizn-loading.gif">
				</div>
				
				<div class="container">
				
					<div class="col-md-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/ui/data-repo.jsp">데이터 관리</a></li>
							<li><a href="${pageContext.request.contextPath}/ui/data-repo.jsp">저장소 제목</a></li>
							<li class="active">차트형 데이터 만들기</li>
						</ol>

						<div id="chartdiv-box"></div>
						
						<button type="button" class="btn btn-info sendjson button" data-loading-text="저장중.." autocomplete=”off“>저장</button>
						<a href="#" class="btn btn-danger reset button">리셋</a>
						
						<div class="pull-right">
							<button id="bar-chart-btn" class="btn btn-chart-type chart-type-btn margin-right-10" data-toggle="tooltip" title="막대 차트">
								<i class="fa fa-bar-chart chart-list-option" aria-hidden="true"></i>
							</button>
							<button id="line-chart-btn" class="btn btn-chart-type chart-type-btn margin-right-10" data-toggle="tooltip" title="라인 차트">
								<i class="fa fa-line-chart chart-list-option" aria-hidden="true"></i>
							</button>
							<button id="area-chart-btn" class="btn btn-chart-type chart-type-btn margin-right-10" data-toggle="tooltip" title="영역 차트">
								<i class="fa fa-area-chart chart-list-option" aria-hidden="true"></i>
							</button>
							<button id="pie-chart-btn" class="btn btn-chart-type chart-type-btn margin-right-10" data-toggle="tooltip" title="파이 차트">
								<i class="fa fa-pie-chart chart-list-option" aria-hidden="true"></i>
							</button>
						</div>
						<div id="edittable"></div>
				
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/editTable/jquery.edittable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/lib/amcharts/amcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/lib/amcharts/serial.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/lib/amcharts/themes/light.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-create-chart.js" type="text/javascript"></script>		

<%@include file="/WEB-INF/views/renual/footer.jsp"%>