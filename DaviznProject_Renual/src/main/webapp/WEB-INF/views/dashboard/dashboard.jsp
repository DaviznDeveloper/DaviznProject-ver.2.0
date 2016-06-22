<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li class="active">대시보드</li>
						</ol>
						
						<div class="data-dash-box" data-toggle="tooltip" title="대시보드 제목">
							<a href="${pageContext.request.contextPath}/data-insert.jsp" type="button" class="btn data-dash-btn">
								<i class="fa fa-object-ungroup data-dash-icon" aria-hidden="true"></i>
							</a>
						</div>
						
						<!-- Button trigger modal -->
						<div class="data-dash-box" data-toggle="tooltip" title="대시보드 확장하기">
							<button type="button" class="btn btn-default data-dash-create-btn"
								data-toggle="modal" data-target="#data-dash-create">
								<i class="fa fa-plus data-repo-create-icon" aria-hidden="true"></i>
							</button>
						</div>
		
						<!-- Modal -->
						<div class="modal fade" id="data-dash-create" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
					
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">대시보드 확장하기</h4>
									</div>
									
									<div class="modal-body">
									
										<div class="row col-md-12 center-block">
										
											<form action="" method="post">
												
							                	<div class="form-group">
							                		<input type="text" name="" class="form-control" 
							                			placeholder="대시보드 제목을 입력하세요">
							                	</div>
							                	
							                	<div class="form-group">
							                		<button type="submit" name="" class="form-control btn btn-info">
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
			
		</div>