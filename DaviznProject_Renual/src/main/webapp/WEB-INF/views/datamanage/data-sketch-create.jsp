<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


				
				<!-- content -->
				<div class="container">
				
					<div class="col-sm-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
		        			<li><a href="${pageContext.request.contextPath}/userStrg.dvn">저장소 목록</a></li>
		         			<li><a href="${pageContext.request.contextPath}/personalData/showPersonalDataList.dvn?strgseq=${strgseq}">데이터 목록</a></li>
							<li class="active">스케치형 데이터 만들기</li>
						</ol>
						
						<form action="${pageContext.request.contextPath}/sketch/writeSketchData.dvn?strgseq=${strgseq}" method="post" id="sketchForm">
						
							<div class="note-detail-option">
								<span class="glyphicon glyphicon-save sketch-save-btn" 
									data-toggle="tooltip" title="노트 저장하기" aria-hidden="true"></span>
								<span class="sketch-save-text"></span>
							</div>
						
							<input type="text" name="dataname" class="form-control input-lg sketch-title" placeholder="제목을 입력하세요">
							
							<br>
					
							<div class="sketch-box">
								<div id="my-sketch" class="my-drawing"></div>
							</div>
							
							<textarea id="sketchData" name="sketchData"></textarea>
							
						</form>
						
						<br>
						
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<!-- dependency: React.js -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react-with-addons.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react-dom.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/sketch/js/literallycanvas.js"></script>
<script type="text/javascript">
							
	$(function() {
		
		var lc = LC.init(
            document.getElementsByClassName('my-drawing')[0],
            {imageURLPrefix: '${pageContext.request.contextPath}/resources/lib/sketch/img'}
        );
		
		$(".sketch-save-btn").click(function() {
			var sketchTitle = $(".sketch-title").val();
			var sketchData = lc.getImage().toDataURL();
			
			$("#sketchData").val(sketchData);
			$("#sketchView").attr('src',sketchData);
			
			//alert($("#sketchData").val());
			
			$("#sketchForm").submit();
			
			//alert(sketchData);
			//var copyimg = new Image();
			//var copyCanvas = $("#test-box");
			//var copyContext = copyCanvas.get(0).getContext('2d'); 
			//copyimg.src = sketchData;
			//copyContext.drawImage(copyimg,0,0);
		});

	});
</script>


