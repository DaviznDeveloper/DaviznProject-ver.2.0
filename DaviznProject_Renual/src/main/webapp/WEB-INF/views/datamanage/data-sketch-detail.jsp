<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


				
				<!-- content -->
				<div class="container">
				
					<div class="col-sm-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 데이터 관리</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-list.jsp">저장소 제목</a></li>
							<li class="active">스케치형 데이터 만들기</li>
						</ol>
						
						
		
						<div class="note-detail-option">
							<a href="${pageContext.request.contextPath}/sketch/ModifySketchView.dvn?dataseq=${sketch.dataseq}&strgseq=${sketch.strgseq}">
								<span class="glyphicon glyphicon-pencil sketch-save-btn" 
									data-toggle="tooltip" title="스캐치 수정하기" aria-hidden="true"></span>
							</a>
							<a href="${pageContext.request.contextPath}/personalData/deletePersonalData.dvn?dataseq=${sketch.dataseq}&strgseq=${sketch.strgseq}">
								<span class="glyphicon glyphicon-trash sketch-save-btn" 
									data-toggle="tooltip" title="스캐치 삭제하기" aria-hidden="true"></span>
							</a>
						</div>
						
						<div class="panel panel-info note-detail-content">
							<div class="panel-heading note-detail-title">
								<h3 class="panel-title">
									<!-- 여기에 제목이랑 작성일 el 추가 -->
									${sketch.dataname}&nbsp;&nbsp;&nbsp;&nbsp;
									<small class="note-detail-date">${sketch.datacreate}</small>
								</h3>
							</div>
							<div class="panel-body">
								<!-- 여기에 src 경로로 el 추가 -->
								<img src="${sketch.value}" id="sketchView">
							</div>
						</div>
						
						<br>
						
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>


