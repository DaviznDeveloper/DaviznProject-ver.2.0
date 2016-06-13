<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
				
					<div class="content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/ui/profile.jsp">내 프로필</a></li>
							<li class="active">프로필 수정하기</li>
						</ol>
						
						<div class="col-md-4 col-md-offset-4 no-padding">
	
							<form action="" method="post" enctype="multipart/form-data">
	
								<a href="" id="profile-thum-modi" class="thumbnail profile-thumbnail no-margin" data-toggle="tooltip" title="프로필 사진 변경하기">
									<img id="profile-preview" src="${pageContext.request.contextPath}/resources/img/avatar2.png" alt="...">
								</a>
								<br>
								<input type='file' id="uploadImage" name="" />
								
								<br>
								
								<div class="col-md-12 no-padding">
									<input type="text" value ="${member.nickname}" name="" class="form-control" placeholder="변경하실 닉네임을 입력하세요.">
								</div>
								
								<div class="col-md-12 no-padding">
									<span class="profile-font">
										<i class="fa fa-envelope profile-font-icon" aria-hidden="true"></i>
										&nbsp;&nbsp;<input type="text" class="form-control" value="${member.userid}" disabled>
									</span>
								</div>
								
								<div class="col-md-12 no-padding">
									<span class="profile-font">
										<i class="fa fa-key profile-font-icon" aria-hidden="true"></i>
										&nbsp;&nbsp;<input type="password" value="${member.password}" class="form-control" placeholder="변경하실 비밀번호를 입력하세요.">
									</span>
								</div>
								
								<div class="col-md-12 no-padding">
									<span class="profile-font">
										<i class="fa fa-phone profile-font-icon" aria-hidden="true"></i>
										&nbsp;&nbsp;<input type="tel" value="${member.phone}" class="form-control" placeholder="변경하실 연락처를 입력하세요.">									
									</span>
									<hr>
								</div>
								
								<button type="submit" class="btn btn-primary form-control">프로필 변경 완료</button>
							
							</form>
					
						</div>
		
					</div>
					
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>