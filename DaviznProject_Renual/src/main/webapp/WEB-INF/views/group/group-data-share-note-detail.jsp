<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
		<!-- content -->
		<div class="container">
			<div class="col-md-12 content-container">
		
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
					<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 그룹</a></li>
					<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">그룹 데이터</a></li>
					<li class="active">그룹에 공유된 데이터</li>
				</ol>
		
				<div class="note-detail-option">
					<a href="${pageContext.request.contextPath}/groupdata/modifyShareData.dvn?dataseq=${note.dataseq}">
						<span class="glyphicon glyphicon-pencil group-data-share-note-modi-btn" 
							data-toggle="tooltip" title="노트 수정하기" aria-hidden="true"></span>
					</a>
					<a href="${pageContext.request.contextPath}/groupdata/deletleShareData.dvn?dataseq=${note.dataseq}">
						<span class="glyphicon glyphicon-trash group-data-share-note-modi-btn" 
							data-toggle="tooltip" title="노트 삭제하기" aria-hidden="true"></span>
					</a>
				</div>
		
				<div class="panel panel-purple-l note-detail-content">
					<div class="panel-heading note-detail-title">
						<h3 class="panel-title">
							${note.dataname} &nbsp;&nbsp;&nbsp;&nbsp;
							<small class="note-detail-date">${note.datacreate} 에 '${note.userid}' 이 최종 수정.</small>
						</h3>
					</div>
					<div class="panel-body">${note.datahtml}</div>
				</div>
		
				<div id="push"></div>
						
			</div>
			
		</div>
		
	</div>
	
</div>

<script src="${pageContext.request.contextPath}/resources/js/data-note-detail.js"></script>


