<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>				
				<!-- content -->
				<div class="col-md-10 content-container">

					<ol class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
						<li class="active">데이터 관리(경로 체크)</li>
					</ol>
					
					
					<security:authorize access="!hasRole('ROLE_USER')">
    					
    					
						<div class="data-repo-box" data-toggle="tooltip" title="저장소 제목">
							<a href="${pageContext.request.contextPath}/data-list.jsp" type="button" class="btn btn-info data-repo-btn">
								<i class="fa fa-folder-o data-repo-icon" aria-hidden="true"></i>
							</a>
						</div>
					
   					</security:authorize> 
   					
					<security:authorize access="hasRole('ROLE_USER')">
    					<c:forEach var="b" items="${list}">
    						
    							
								<div class="data-repo-box" data-toggle="tooltip" title="${b.strgname}">
									<a href="${pageContext.request.contextPath}/datamanage/showDataList.dvn?userstrg=${b.userstrg} " type="button" class="btn btn-info data-repo-btn">
										<i class="fa fa-folder-o data-repo-icon" aria-hidden="true"></i>
									</a>
								</div>
							
							
						</c:forEach>
   					</security:authorize>
		
					<!-- Button trigger modal -->
					<div class="data-repo-box" data-toggle="tooltip" title="저장소 확장하기">
						<button type="button" class="btn btn-default data-repo-create-btn"
							data-toggle="modal" data-target="#data-repo-create">
							<i class="fa fa-plus data-repo-create-icon" aria-hidden="true"></i>
						</button>
					</div>
	
					<!-- Modal -->
					<div class="modal fade" id="data-repo-create" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
				
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">데이터 저장소 확장하기</h4>
								</div>
								
								<div class="modal-body">
								
									<div class="row col-md-12 center-block">
									
										<form action="${pageContext.request.contextPath}/datamanage/addStorage.dvn" method="post">
											
						                	<div class="form-group">
						                		<input type="text" name="strgname" class="form-control" 
						                			placeholder="저장소 제목을 입력하세요">
						                	</div>
						                	
						                	<div class="form-group">
						                		<button type="submit" class="form-control btn btn-info">
						                			확장하기
						                		</button>
						                	</div>
										
										</form>
										
									</div>
								
								</div>

								<div class="modal-footer">
									<div class="row col-md-12 center-block">
									
										<div class="">
											<div class="col-md-8 no-padding">
												현재 보유 포인트 : 
											</div>
											
											<div class="col-md-4 no-padding">
												<span class="">100</span> 
											</div>
										</div>
										
										<div class="">
											<div class="col-md-8 no-padding">
												차감될 포인트 : 
											</div>
											
											<div class="col-md-4 no-padding">
												<span class="">1000</span> 
											</div>
										</div>
										
										<hr>
										
										<div class="">
											<div class="col-md-8 no-padding">
												합계 : 
											</div>
											
											<div class="col-md-4 no-padding">
												<span class="">-900</span> 
											</div>
										</div>
										
									</div>
								</div>
	
							</div>
						</div>
					</div>
					<!-- Modal -->
	
					<br>
				
					<div id="push"></div>
				
				</div>
			
			</div>
			
		</div>