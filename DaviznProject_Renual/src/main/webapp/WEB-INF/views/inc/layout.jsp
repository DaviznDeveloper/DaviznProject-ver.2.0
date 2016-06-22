<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>

<html lang="ko">

	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="Hwang.Young-sun">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon-152.png" sizes="152x152">
		
		<title>Davizn - 데이터 관리형 도구 사이트</title>
		
		
  		<!-- css - jQery-ui -->
  		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		
		<!-- css - Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		
  		<!-- css - Bootstrap-datepicker -->
  		<link href="${pageContext.request.contextPath}/resources/lib/datetimepicker/build/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
  		
		<!-- css - font-awesome -->
		<link href="${pageContext.request.contextPath}/resources/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- css - footable -->
		<link href="${pageContext.request.contextPath}/resources/lib/footable-bootstrap/css/footable.bootstrap.min.css" rel="stylesheet" />
		
		<!-- css - goal -->
		<link href="${pageContext.request.contextPath}/resources/lib/goal/progress.css" rel="stylesheet">
		
		<!-- css - TimeCircles -->
		<link href="${pageContext.request.contextPath}/resources/lib/TimeCircles/inc/TimeCircles.css" rel="stylesheet">
		
		<!-- css - include summernote css/js-->
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
		
		<!-- css - switch -->
		<link href="${pageContext.request.contextPath}/resources/lib/switch/switchable.css" rel="stylesheet">
		
		<!-- css - sketch -->
		<link href="${pageContext.request.contextPath}/resources/lib/sketch/css/literallycanvas.css" rel="stylesheet">
		
		<!-- css - Custom CSS -->
		<!-- css - Custom CSS -->
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/sideBar.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/group.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/data-sketch.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/data-note.css" rel="stylesheet">
		
		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		
  		<!-- jQery-ui -->
  		<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		
		<!-- Bootstrap -->
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  		
  		<!-- Bootstrap-datepicker -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/lib/datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
		
		<!-- Custom Script -->
		<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/sideBar.js"></script>
		

	</head>

	<body>
	
		<div id="wrap">
			<div id="main">
			
				<!-- Header  영역  -->
				<tiles:insertAttribute name="header" />
				
				<!-- Main 영역 -->
				<tiles:insertAttribute name="content" />
				
				<!-- Footer  영역  -->
				<tiles:insertAttribute name="footer" />
				
			</div>
		</div>
		
	</body>
</html>