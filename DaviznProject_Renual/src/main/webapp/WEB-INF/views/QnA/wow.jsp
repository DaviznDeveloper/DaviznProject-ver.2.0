<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<title>Albumize - jQuery Plugin</title>
	
	<link href="resources/lib/albumize-master/css/albumize.css" rel="stylesheet" />
	<script src="resources/lib/albumize-master/js/analytics.js"></script>
	<script src="resources/lib/albumize-master/js/jquery-1.10.2.min.js"></script>
	<script src="resources/lib/albumize-master/js/albumize.js"></script>
	


	
	<script>
		$(document).ready(function(){
		
			var sb = $('#show-albums-button');
			
			sb.click(function(){
				$.albumize();
			});
			
		});
	</script>

</head>

<body>
	
	
	<div id = "container">
	   <div class="col-md-12 content-container">	
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
			<li class="active">앨범</li>
		</ol>
		<div class="col-md-12 no-padding margin-bottom-10">
		<div id = "example-div">
			
			
			<button id = "show-albums-button">앨범 상세보기</button>
			
			
			<div class = "steps-c">
				
			</div>
			
			<div class = "steps-c">
				
			</div>
			
			<div id = "albums-holder">
				
				<div class = "bold">2조 사진</div>
				
				<div class = "albumize" title = "2조">
				
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_150048.jpg" title = "영선이형 메롱"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_150048.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_150057.jpg" title = "진지 영선이형"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_150057.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_155623.jpg" title = "정진이형 뺴고 단체샷 ^^"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_155623.jpg" class = "albumize-cover"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_155645.jpg" title = "혜림이 대두 컷"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_155645.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_155709.jpg" title = "내가 젤 잘나옴"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_155709.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_150048.jpg" title = "영선이형 메롱"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_150048.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_150057.jpg" title = "진지 영선이형"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_150057.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_155645.jpg" title = "혜림이 대두 컷"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_155645.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160602_155709.jpg" title = "내가 젤 잘나옴"><img src = "resources/lib/albumize-master/albumize-master/samples/20160602_155709.jpg"></img></a>
				
				</div>
				
				<div class = "bold">설정 샷</div>
				
				<div class = "albumize" title = "영선이형 위주">
				
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160603_142331.jpg" title = "부자연 스러운 손"><img src = "resources/lib/albumize-master/albumize-master/samples/20160603_142331.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160603_142339.jpg" title = "부자연 스러운 손+시선"><img src = "resources/lib/albumize-master/albumize-master/samples/20160603_142339.jpg"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/20160603_151610.jpg" title = "화이트 보드"><img src = "resources/lib/albumize-master/albumize-master/samples/20160603_151610.jpg" class = "albumize-cover"></img></a>
					<a href = "resources/lib/albumize-master/albumize-master/samples/h.jpg" title = "Heavenly Night"><img src = "resources/lib/albumize-master/albumize-master/samples/8.jpg" ></img></a>
				
				</div>
				
			</div>
			
		</div>
		
		
		<div id = "download-div">
			
			<header id = "download-label"><h1>Download</h1></header>	
			
			<a id = "download-button" href = "https://github.com/palerdot/albumize/archive/master.zip">
				<div>Albumize</div>
				<div id = "version">v1.0</div>
			</a>
				
				
		</div>
		</div>
	   </div>
	</div>

</body>

</html>
