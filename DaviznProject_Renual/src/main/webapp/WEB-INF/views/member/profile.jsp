<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				<!-- content -->
				<div class="col-md-10 content-container">

					<ol class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
						<li class="active">내 프로필</li>
					</ol>
					
					<div class="col-md-3 no-padding">

						<a href="" class="thumbnail profile-thumbnail no-margin" data-toggle="tooltip" title="프로필 수정하기"> 
							<c:set var="profile_img" value="${member.profile_img}" />
							<c:if test="${empty profile_img}">
								<img id="profile-preview" src="${pageContext.request.contextPath}/resources/img/avatar2.png" alt="...">
							</c:if>
									
							<c:if test="${!empty profile_img}">
								<img id="profile-preview" src="${pageContext.request.contextPath}/resources/upload/${member.profile_img}" alt="...">
							</c:if>
							
						</a>
						
						<div class="col-md-12 no-padding">
							<span class="profile-nickname">${member.account}</span>
							<a href="${pageContext.request.contextPath}/member/profileModi.dvn">
								<span class="label label-primary">프로필 수정하기</span>
							</a>
						</div>
						
						<div class="col-md-12 no-padding">
							<span class="profile-font">
								<i class="fa fa-envelope profile-font-icon" aria-hidden="true"></i>
								&nbsp;&nbsp;${member.userid}
							</span>
						</div>
						
						<div class="col-md-12 no-padding">
							<span class="profile-font">
								<i class="fa fa-phone profile-font-icon" aria-hidden="true"></i>
								&nbsp;&nbsp;${member.phone}
							</span>
							<hr>
						</div>
						
						<div class="col-md-12 no-padding">
							<span class="profile-font">
								<i class="fa fa-product-hunt profile-font-icon" aria-hidden="true"></i>
								&nbsp;&nbsp;${member.point}
							</span>
							<hr>
						</div>
						
						<div class="col-md-12 no-padding">
							<span class="profile-font">
								<i class="fa fa-clock-o profile-font-icon" aria-hidden="true"></i>
								&nbsp;&nbsp;${member.joindate}에 가입
							</span>
						</div>
				
					</div>
					
					<div class="col-md-8 col-md-offset-1 no-padding">

						<div role="tabpanel">
				
							<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active">
									<a href="#mydash" aria-controls="mydash" role="tab" data-toggle="tab">내 대시보드</a>
								</li>
								<li role="presentation">
									<a href="#myrepo" aria-controls="myrepo" role="tab" data-toggle="tab">내 데이터 저장소</a>
								</li>
							</ul>
				
							<!-- Tab panes -->
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="mydash">
									<br>
									<div class="list-group">
										<a href="#" class="list-group-item">
											<span class="badge">7</span>
											<i class="fa fa-tachometer profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;kosta 112기 활동 내역
										</a>
										<a href="#" class="list-group-item">
											<span class="badge">4</span>
											<i class="fa fa-tachometer profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;java 일일 강의 내용
										</a>
										<a href="#" class="list-group-item">
											<span class="badge">6</span>
											<i class="fa fa-tachometer profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;web - client 일일 강의 내용
										</a>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane" id="myrepo">
									<br>
									<div class="list-group">
										<a href="#" class="list-group-item">
											<span class="badge">7</span>
											<i class="fa fa-database profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;kosta 112기 활동 내역
										</a>
										<a href="#" class="list-group-item">
											<span class="badge">4</span>
											<i class="fa fa-database profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;java 일일 강의 내용
										</a>
										<a href="#" class="list-group-item">
											<span class="badge">6</span>
											<i class="fa fa-database profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;web - client 일일 강의 내용
										</a>
										<a href="#" class="list-group-item">
											<span class="badge">0</span>
											<i class="fa fa-database profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;Database
										</a>
										<a href="#" class="list-group-item">
											<span class="badge">0</span>
											<i class="fa fa-database profile-font-icon" aria-hidden="true"></i>
											&nbsp;&nbsp;Spring
										</a>
									</div>
								</div>
							</div>
				
						</div>
				
					</div>
	
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>
