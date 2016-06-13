<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  		
  		<!-- jQery-ui -->
  		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  		<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		
		<!-- font-awesome -->
		<link href="${pageContext.request.contextPath}/resources/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- summernote -->
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
		
		<!-- ipgrid -->
		<link href="${pageContext.request.contextPath}/resources/lib/ipgrid-master/ip.grid.css" rel="stylesheet" />
		
		<!-- editTable -->
		<link href="${pageContext.request.contextPath}/resources/lib/editTable/jquery.edittable.css" rel="stylesheet" />
		
		<!-- angular-gridster -->
		<link href="${pageContext.request.contextPath}/resources/lib/angular-gridster/jquery.grid-test.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/resources/lib/angular-gridster/style.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/resources/lib/angular-gridster/grid-test.css" rel="stylesheet" />
		
		<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sideBar.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css">
		
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