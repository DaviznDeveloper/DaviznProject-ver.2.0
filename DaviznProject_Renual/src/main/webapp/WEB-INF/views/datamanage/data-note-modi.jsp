<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
				<!-- content -->
				<div class="container">
				
					<div class="col-md-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
              				<li><a href="${pageContext.request.contextPath}/userStrg.dvn">내 데이터 관리</a></li>
               				<li><a href="${pageContext.request.contextPath}/personalData/showPersonalDataList.dvn?strgseq=${note.strgseq}">저장소 제목</a></li>
							<li class="active">노트형 데이터 제목</li>
						</ol>
						
						<form action="${pageContext.request.contextPath}/note/modifyNoteAction.dvn?strgseq=${note.strgseq}&dataseq=${note.dataseq}" method="post" id="noteForm">
							
							<button type="button" id="sendNoteData" class="btn btn-info sendNoteData">저장</button>
							<button type="reset" class="btn btn-default">취소</button>
							
							<hr>
						
							<input type="text" name="dataname" class="form-control input-lg note-title" placeholder="제목을 입력하세요" value="${note.dataname}" required="required">
							
							<br>
							
							<textarea name="inputArticleContents" id="ckeditor" class="ckeditor-box" rows="50" cols="50"></textarea>
							
						</form>
				
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-note.js"></script>
<script type="text/javascript">

	$(function() {
		var sendNoteData='${note.value}'
		CKEDITOR.instances.ckeditor.setData(sendNoteData);
		$('#ckeditor').val(sendNoteData);
		
	});

</script>
