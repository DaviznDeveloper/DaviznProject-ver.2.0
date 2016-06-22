<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
								<!-- content -->
				<div class="container">
				
					<div class="content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/ui/profile.jsp">내 그룹</a></li>
							<li class="active">그룹정보 수정하기</li>
						</ol>
						
						<form action="" method="post" class="form-horizontal">
						
							<div class="col-sm-4 no-padding">
		
									<a href="" id="profile-thum-modi" class="thumbnail profile-thumbnail no-margin" data-toggle="tooltip" title="그룹 사진 변경하기">
										<img id="profile-preview" src="${pageContext.request.contextPath}/resources/img/avatar.png" alt="...">
									</a>
									<br>
									<input type='file' id="uploadImage" name="" />
									
									<br>
									
							</div>
							
							<div class="col-sm-8">
								<div class="form-group">
									<label for="inputGroupName" class="col-sm-3 control-label">그룹명</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="inputGroupName"
											placeholder="변경하실 그룹명을 입력하세요" value="DaviznDeveloper">
									</div>
								</div>
								
								<div class="form-group">
									<label for="inputGroupIntroduce" class="col-sm-3 control-label">그룹 소개</label>
									<div class="col-sm-9">
										<textarea id="inputGroupIntroduce" class="form-control textarea-size-fix" 
											placeholder="변경하실 그룹 소개 내용을 입력하세요" rows="3">데이비즌 개발팀의 작업 공간</textarea>
									</div>
								</div>
								
								<div class="form-group">
									<label for="inputGroupOwner" class="col-sm-3 control-label">그룹장</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="inputGroupOwner"
											value="Davizn" disabled>
									</div>
								</div>
								
								<div class="form-group">
									<label for="inputGroupCreateDate" class="col-sm-3 control-label">그룹 생성일</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="inputGroupCreateDate"
											value="2016.06.16" disabled>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3">
										<button type="submit" class="btn btn-primary form-control">그룹 정보 변경 완료</button>
									</div>
								</div>
							</div>
						
						</form>
		
					</div>
					
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>


