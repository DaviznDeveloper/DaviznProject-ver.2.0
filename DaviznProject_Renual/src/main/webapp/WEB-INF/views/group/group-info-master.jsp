<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
				<!-- content -->
				<div class="container">
				
					<div class="col-md-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 그룹</a></li>
							<li class="active">그룹 정보</li>
						</ol>
						
						<div class="col-sm-3 no-padding margin-bottom-10">

							<a href="#" class="thumbnail profile-thumbnail no-margin" data-toggle="tooltip" title="그룹정보 수정하기"> 
								<img id="profile-preview" src="${pageContext.request.contextPath}/resources/img/avatar.png" alt="...">
							</a>
							
							<div class="col-sm-12 no-padding">
								<span class="profile-nickname">DaviznDeveloper</span>
								<a href="">
									<span class="label label-primary">그룹정보 수정하기</span>
								</a>
							</div>
							
							<div class="col-sm-12 no-padding">
								<span class="profile-font">
									그룹장 : Davizn
								</span>
								<br><br>
							</div>
							
							<div class="col-sm-12 no-padding">
							
								<div class="col-sm-4 no-padding border-right">
													
									<div class="col-sm-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 멤버">
										<i class="fa fa-users vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-sm-12 center-block text-center">
										3
									</div>
									
								</div>
								
								<div class="col-sm-4 no-padding border-right">
									
									<div class="col-sm-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 데이터">
										<i class="fa fa-files-o vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-sm-12 center-block text-center">
										1
									</div>
									
								</div>
								
								<div class="col-sm-4 no-padding">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 목표">
										<i class="fa fa-list-alt vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-sm-12 center-block text-center">
										2
									</div>
									
								</div>
								
							</div>
					
						</div>
					
						<div class="col-sm-8 col-md-offset-1 no-padding">
	
							<div role="tabpanel">
					
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active">
										<a href="#groupMember" aria-controls="groupMember" role="tab" data-toggle="tab">그룹 인원</a>
									</li>
									<li role="presentation">
										<a href="#groupData" aria-controls="groupData" role="tab" data-toggle="tab">그룹 데이터</a>
									</li>
									<li role="presentation">
										<a href="#groupDataVersion" aria-controls="groupDataVersion" role="tab" data-toggle="tab">그룹 데이터 버전</a>
									</li>
									<li role="presentation">
										<a href="#groupGorl" aria-controls="groupGorl" role="tab" data-toggle="tab">그룹 목표</a>
									</li>
								</ul>
					
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="groupMember">
										<br>
										<div class="bs-example"
											data-example-id="panel-without-body-with-table">
											<div class="panel panel-info">
												<!-- Default panel contents -->
												<div class="panel-heading">
													<div class="checkbox no-margin">
														<label>
															<input type="checkbox" value="">
															<span class="group-info-member-selected">1</span>명 선택됨.
														</label>
													</div>
												</div>

												<div class="group-info-member-table">
													<table class="table">
														<tbody>
															<tr>
																<th scope="row">
																	<div class="checkbox no-margin">
																		<label>
																			<input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
																		</label>
																	</div>
																</th>
																<td>Davizn</td>
																<td>그룹장</td>
																<td>2016.06.19</td>
															</tr>
															<tr>
																<th scope="row">
																	<div class="checkbox no-margin">
																		<label>
																			<input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
																		</label>
																	</div>
																</th>
																<td>seulki</td>
																<td>그룹원</td>
																<td>2016.06.19</td>
															</tr>
															<tr>
																<th scope="row">
																	<div class="checkbox no-margin">
																		<label>
																			<input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
																		</label>
																	</div>
																</th>
																<td>nameLim</td>
																<td>그룹원</td>
																<td>2016.06.19</td>
															</tr>
															<tr>
																<th scope="row">
																	<div class="checkbox no-margin">
																		<label>
																			<input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
																		</label>
																	</div>
																</th>
																<td>jungjin</td>
																<td>그룹원</td>
																<td>2016.06.19</td>
															</tr>
															<tr>
																<th scope="row">
																	<div class="checkbox no-margin">
																		<label>
																			<input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
																		</label>
																	</div>
																</th>
																<td>wonsuk</td>
																<td>그룹원</td>
																<td>2016.06.19</td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
									
									<div role="tabpanel" class="tab-pane" id="groupData">
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
									
									<div role="tabpanel" class="tab-pane" id="groupDataVersion">
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
									
									<div role="tabpanel" class="tab-pane" id="groupGorl">
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
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-note.js"></script>

