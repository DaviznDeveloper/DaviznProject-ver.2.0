<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="${pageContext.request.contextPath}/resources/lib/Demo/css/jquery.stickynote.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/lib/Demo/css/StickyNoteDemo.css" rel="stylesheet" />

				
				<!-- content -->
				<div class="container">
				
					<div class="col-sm-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 데이터 관리</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-list.jsp">저장소 제목</a></li>
							<li class="active">스케치형 데이터 만들기</li>
						</ol>
						
						<form action="" method="post">
						
							<div class="note-detail-option">
								<span class="glyphicon glyphicon-save sketch-save-btn" 
									data-toggle="tooltip" title="노트 저장하기" aria-hidden="true"></span>
							</div>
						
							<input type="text" name="" class="form-control input-lg sketch-title" placeholder="제목을 입력하세요">
							
							<br>
					
							<div class="sketch-box">
								<div id="divStickyNotesContainer">
							</div>
							
						</form>
						
						<br>
						
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/Demo/js/jquery.stickynote.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/Demo/js/StickyNotes.js"></script>
<script type="text/javascript">
							
	$(function() {

		var note = noteBox.data("coaStickyNote");
		console.log(note);
		
	});
	
</script>
