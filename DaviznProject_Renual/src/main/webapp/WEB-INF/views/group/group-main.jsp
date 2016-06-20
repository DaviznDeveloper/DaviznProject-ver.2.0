<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
				
	<!-- content -->
<div class="container">
	<div class="col-md-12 content-container">
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
			<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 그룹</a></li>
			<li class="active">그룹 메인</li>
		</ol>
		<div class="col-sm-4">	
			<div class="col-sm-12 no-padding">
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#group-create">
					<i class="fa fa-plus" aria-hidden="true"></i>
						그룹 만들기
				</button>
				<br><br>
					
				<form action="" method="post" class="form-horizontal">
					<div id="group-create" class="modal fade">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">								
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">그룹 만들기</h4>
								</div>
								<div class="modal-body">
									<h4 class="text-center">당신의 그룹을 만들어보세요.</h4>
									<br>
									<div class="row">
										<label for="inputgroupName" class="col-sm-2 control-label">그룹 이름</label>
										<div class="col-sm-10">
											<input type="text" name="groupName" class="form-control" id="inputgroupName"
													placeholder="그룹 이름을 입력하세요">
										</div>
									</div>
									<br>
									<div class="row">
										<label for="inputgroupIntroduce" class="col-sm-2 control-label">그룹 소개</label>
										<div class="col-sm-10">
											<textarea name="groupIntroduce" class="form-control textarea-size-fix" rows="3" id="inputgroupIntroduce"
													placeholder="그룹에 대해 간략하게 소개하세요"></textarea>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
									<button type="submit" class="btn btn-primary gorl-save">확인</button>
								</div>									
							</div>
							<!-- /.modal-content -->
						</div>
							<!-- /.modal-dialog -->
					</div>
						<!-- /.modal -->
				</form>	
			
			
			
			
			
			
			
			
			
			
			
			</div>
				
				
				
				<div class="col-sm-12 no-padding">
					<security:authorize access="hasRole('ROLE_ADMIN')">
                					<a href="${pageContext.request.contextPath}/group/groupInfoMaster.dvn">
						<div class="panel panel-primary">
							<div class="panel-body">
								<div class="group-main-groupbox-groupname">
									DaviznDeveloper
								</div>
								
								<div>
									그룹장 : Davizn
								</div>
								
								<br>
								
								<div class="col-xs-4 no-padding border-right">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 멤버">
										<i class="fa fa-users vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-xs-12 center-block text-center">
										3
									</div>
									
								</div>
								
								<div class="col-xs-4 no-padding border-right">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 데이터">
										<i class="fa fa-files-o vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-xs-12 center-block text-center">
										1
									</div>
									
								</div>
								
								<div class="col-xs-4 no-padding">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 목표">
										<i class="fa fa-list-alt vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-xs-12 center-block text-center">
										2
									</div>
									
								</div>
							
							</div>
						</div>
					</a>
               				
               				</security:authorize>
               				<security:authorize access="hasRole('ROLE_USER')">
                					<a href="${pageContext.request.contextPath}/group/groupInfo.dvn">
						<div class="panel panel-primary">
							<div class="panel-body">
								<div class="group-main-groupbox-groupname">
									DaviznDeveloper
								</div>
								
								<div>
									그룹장 : Davizn
								</div>
								
								<br>
								
								<div class="col-xs-4 no-padding border-right">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 멤버">
										<i class="fa fa-users vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-xs-12 center-block text-center">
										3
									</div>
									
								</div>
								
								<div class="col-xs-4 no-padding border-right">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 데이터">
										<i class="fa fa-files-o vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-xs-12 center-block text-center">
										1
									</div>
									
								</div>
								
								<div class="col-xs-4 no-padding">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 목표">
										<i class="fa fa-list-alt vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-xs-12 center-block text-center">
										2
									</div>
									
								</div>
							
							</div>
						</div>
					</a>
               				
               				</security:authorize>
						
						
						<br><br>
						
					</div>
					
				</div>
				
				<div class="col-sm-8">
				
					<div class="col-sm-12 no-padding">
						<div class="input-group">
							<span class="input-group-btn">
								<button class="btn btn-warning" type="button">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span>
							<input type="text" class="form-control" placeholder="그룹명">
						</div>
						<br>
					</div>
					
					<a href="">
						<div class="col-sm-12 no-padding">
							<div class="panel panel-warning">
								<div class="panel-body">
									<div class="group-main-groupbox-groupname">
										한글이 제일 쉬웠어요
									</div>
									
									<div>
										그룹장 : 세종대왕
									</div>
								</div>
							</div>
						</div>
					</a>
						
					<a href="">
						<div class="col-sm-12 no-padding">
							<div class="panel panel-warning">
								<div class="panel-body">
								
									<div class="group-main-groupbox-groupname">
										남자의 불꽃 드리블 강좌
									</div>
									
									<div>
										그룹장 : 루니
									</div>
								
								</div>
							</div>
						</div>
					</a>
					
					<a href="">	
						<div class="col-sm-12 no-padding">
							<div class="panel panel-warning">
								<div class="panel-body">
								
									<div class="group-main-groupbox-groupname">
										혁신은 무엇인가
									</div>
									
									<div>
										그룹장 : 스티브 잡스
									</div>
								
								</div>
							</div>
						</div>
					</a>
						
					<a href="">
						<div class="col-sm-12 no-padding">
							<div class="panel panel-warning">
								<div class="panel-body">
								
									<div class="group-main-groupbox-groupname">
										가슴으로 외치는 샤우팅
									</div>
									
									<div>
										그룹장 : 우리동네 골목대장
									</div>
								
								</div>
							</div>
						</div>
					</a>
				
				</div>
				
			</div>
		
		</div>
		
		<div id="push"></div>
		
	</div>
	
</div>

<script src="${pageContext.request.contextPath}/resources/js/group-main.js"></script>

