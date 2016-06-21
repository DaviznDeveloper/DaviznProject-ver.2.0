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
								<!-- 그룹 정보 수정 페이지 경로 설정 -->
								<a href="">
									<span class="label label-primary">그룹정보 수정하기</span>
								</a>
								<div>데이비즌 개발팀의 작업 공간</div>
								<br>
							</div>
							
							<div class="col-sm-12 no-padding">
								<span class="profile-font">
									<i class="fa fa-user-secret profile-font-icon" aria-hidden="true"></i>
									&nbsp;&nbsp;Davizn
								</span>
							</div>
							
							<div class="col-sm-12 no-padding">
								<span class="profile-font">
									<i class="fa fa-clock-o profile-font-icon" aria-hidden="true"></i>
									&nbsp;&nbsp;2016.06.16 에 창설.
								</span>
								<br><br>
							</div>
							
							<div class="col-sm-12 no-padding">
							
								<div class="col-sm-4 no-padding border-right">
													
									<div class="col-sm-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 멤버">
										<i class="fa fa-users vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-sm-12 center-block text-center">
										5
									</div>
									
								</div>
								
								<div class="col-sm-4 no-padding border-right">
									
									<div class="col-sm-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 데이터">
										<i class="fa fa-files-o vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-sm-12 center-block text-center">
										3
									</div>
									
								</div>
								
								<div class="col-sm-4 no-padding">
									
									<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 목표">
										<i class="fa fa-list-alt vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
									</div>
									
									<div class="col-sm-12 center-block text-center">
										78
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
										<a href="#groupGorl" aria-controls="groupGorl" role="tab" data-toggle="tab">그룹 목표</a>
									</li>
									<li role="presentation">
										<a href="#groupData" aria-controls="groupData" role="tab" data-toggle="tab">그룹 데이터</a>
									</li>
									<li role="presentation">
										<a href="#groupDataHistory" aria-controls="groupDataHistory" role="tab" data-toggle="tab">그룹 데이터 히스토리</a>
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
													
													<div class="pull-right">
														<!-- form(#group-info-member-list) 강제 서브밋 버튼 -->
														<!-- 중간에 폼이 껴있어서 스크립트로 강제 전송 시켜줘야 함. -->
														<button type="button" id="group-info-member-delete" class="btn btn-danger btn-xs">
															<i class="fa fa-user-times" aria-hidden="true"></i>
															멤버 추방
														</button>
													</div>
													
													<!-- form(#group-info-member-list) 강제 서브밋 버튼 -->
													<!-- 중간에 폼이 껴있어서 스크립트로 강제 전송 시켜줘야 함. -->
													<div class="pull-right margin-right-10">
														<button type="button" class="btn btn-primary btn-xs">
															<i class="fa fa-user-secret" aria-hidden="true"></i>
															그룹장 위임
														</button>
														
													</div>
												
													<div id="group-info-member-header" class="checkbox no-margin">
														<div class="checkbox no-margin">
															<label>
																<input type="checkbox" id="checkall">
																<span class="group-info-member-selected">1</span>명 선택됨.
															</label>
														</div>
													</div>
												</div>
												
												<!-- 멤버 추방 및 그룹장 위임 클릭시 강제 submit 예정.  -->
												<form action="" id="group-info-member-list" method="post">
													<div class="group-info-member-table">
														<table class="table">
															<tbody>
																<tr>
																	<th scope="row">
																		<div class="checkbox no-margin">
																			<label>
																				<input type="checkbox" class="blankCheckbox" name="userid" value="Davizn" aria-label="...">
																			</label>
																		</div>
																	</th>
																	<td>Davizn</td>
																	<td class="text-center">그룹장</td>
																	<td class="text-center">2016.06.19</td>
																</tr>
																<tr>
																	<th scope="row">
																		<div class="checkbox no-margin">
																			<label>
																				<input type="checkbox" class="blankCheckbox" name="userid" value="seulki" aria-label="...">
																			</label>
																		</div>
																	</th>
																	<td>seulki</td>
																	<td class="text-center">그룹원</td>
																	<td class="text-center">2016.06.19</td>
																</tr>
																<tr>
																	<th scope="row">
																		<div class="checkbox no-margin">
																			<label>
																				<input type="checkbox" class="blankCheckbox" name="userid" value="nameLim" aria-label="...">
																			</label>
																		</div>
																	</th>
																	<td>nameLim</td>
																	<td class="text-center">그룹원</td>
																	<td class="text-center">2016.06.19</td>
																</tr>
																<tr>
																	<th scope="row">
																		<div class="checkbox no-margin">
																			<label>
																				<input type="checkbox" class="blankCheckbox" name="userid" value="jungjin" aria-label="...">
																			</label>
																		</div>
																	</th>
																	<td>jungjin</td>
																	<td class="text-center">그룹원</td>
																	<td class="text-center">2016.06.19</td>
																</tr>
																<tr>
																	<th scope="row">
																		<div class="checkbox no-margin">
																			<label>
																				<input type="checkbox" class="blankCheckbox" name="userid" value="wonsuk" aria-label="...">
																			</label>
																		</div>
																	</th>
																	<td>wonsuk</td>
																	<td class="text-center">그룹원</td>
																	<td class="text-center">2016.06.19</td>
																</tr>
															</tbody>
														</table>
													</div>
												</form>	
											</div>
											
											<!-- 가입 승인 또는 회원  -->
											<form action="" method="post">
												<div class="panel panel-success">
													<div class="panel-heading">
														
														<div class="pull-right">
															<button type="submit" id="group-info-member-delete" class="btn btn-success btn-xs">
																<i class="fa fa-user-plus" aria-hidden="true"></i>
																가입 승인
															</button>
														</div>
														
														<div class="pull-right margin-right-10">
															<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#group-create">
																<i class="fa fa-street-view" aria-hidden="true"></i>
																회원 검색
															</button>
															
															<!-- modal -->
															<form action="" method="post" class="form-horizontal">
																<div id="group-create" class="modal fade">
																	<div class="modal-dialog modal-sm">
																		<div class="modal-content">
																		
																			<div class="modal-header">
																				<button type="button" class="close" data-dismiss="modal"
																					aria-label="Close">
																					<span aria-hidden="true">&times;</span>
																				</button>
																				<h4 class="modal-title">회원 검색</h4>
																			</div>
																			
																			<div class="modal-body">
																			
																				<h4 class="text-center">당신의 그룹에 회원을 초대하세요.</h4>
																				
																				<br>
																				
																				<div class="row">
																					<div class="col-sm-12">
																						<div class="input-group">
																							<span class="input-group-btn">
																								<button class="btn btn-primary" type="button" id="inviteBtn">
																									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
																								</button>
																							</span>
																							<input type="text" id="group-info-member-search" class="form-control" placeholder="회원 아이디 또는 이메일">
																						</div>
																					</div>
																				</div>
																				
																				<div class="row">
																					<div class="col-sm-12">
																						<br>
																					</div>
																				</div>
																				
																				<div class="row">
																					<div class="col-sm-12">
																						<div class="panel panel-primary">
																							<div class="panel-heading">
																								검색 결과
																							</div>
																							
																							<ul class="list-group">
																								<li class="list-group-item">
																									<span class="checkbox group-info-member-search-check no-margin">
																										<label>
																											<input type="checkbox" id="blankCheckbox" name="userid" value="option1" aria-label="...">
																											kglim (kglim@gmail.com)
																										</label>
																									</span>
																								</li>
																								<li class="list-group-item">
																									<span class="checkbox group-info-member-search-check no-margin">
																										<label>
																											<input type="checkbox" id="blankCheckbox" name="userid" value="option1" aria-label="...">
																											egoing (egoing@gmail.com)
																										</label>
																									</span>
																								</li>
																								<li class="list-group-item">
																									<span class="checkbox group-info-member-search-check no-margin">
																										<label>
																											<input type="checkbox" id="blankCheckbox" name="userid" value="option1" aria-label="...">
																											alphago (alphago@gmail.com)
																										</label>
																									</span>
																								</li>
																								<li class="list-group-item">
																									<span class="checkbox group-info-member-search-check no-margin">
																										<label>
																											<input type="checkbox" id="blankCheckbox" name="userid" value="option1" aria-label="...">
																											Zuckerberg (Zuckerberg@gmail.com)
																										</label>
																									</span>
																								</li>
																								<li class="list-group-item">
																									<span class="checkbox group-info-member-search-check no-margin">
																										<label>
																											<input type="checkbox" id="blankCheckbox" name="userid" value="option1" aria-label="...">
																											tobi (tobi@gmail.com)
																										</label>
																									</span>
																								</li>
																							</ul>
																								
																						</div>
																					</div>
																				</div>
																				
																			</div>
																			
																			<div class="modal-footer">
																				<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
																				<button type="submit" class="btn btn-primary">초대</button>
																			</div>
																			
																		</div>
																		<!-- /.modal-content -->
																	</div>
																	<!-- /.modal-dialog -->
																</div>
															</form>
															<!-- /.modal -->
														</div>
															
														가입 신청한 회원
													</div>
													
													<ul class="list-group">
														<li class="list-group-item">
															<span class="checkbox group-info-member-search-check no-margin">
																<label>
																	<input type="checkbox" id="blankCheckbox" name="userid" value="kglim" aria-label="...">
																	kglim (kglim@gmail.com)
																</label>
															</span>
														</li>
														<li class="list-group-item">
															<span class="checkbox group-info-member-search-check no-margin">
																<label>
																	<input type="checkbox" id="blankCheckbox" name="userid" value="egoing" aria-label="...">
																	egoing (egoing@gmail.com)
																</label>
															</span>
														</li>
														<li class="list-group-item">
															<span class="checkbox group-info-member-search-check no-margin">
																<label>
																	<input type="checkbox" id="blankCheckbox" name="userid" value="alphago" aria-label="...">
																	alphago (alphago@gmail.com)
																</label>
															</span>
														</li>
														<li class="list-group-item">
															<span class="checkbox group-info-member-search-check no-margin">
																<label>
																	<input type="checkbox" id="blankCheckbox" name="userid" value="Zuckerberg" aria-label="...">
																	Zuckerberg (Zuckerberg@gmail.com)
																</label>
															</span>
														</li>
														<li class="list-group-item">
															<span class="checkbox group-info-member-search-check no-margin">
																<label>
																	<input type="checkbox" id="blankCheckbox" name="userid" value="tobi" aria-label="...">
																	tobi (tobi@gmail.com)
																</label>
															</span>
														</li>
													</ul>
														
												</div>
											</form>
											
										</div>
									</div>
									
									<div role="tabpanel" class="tab-pane" id="groupGorl">

										<br>

										<div class="col-sm-12 no-padding margin-bottom-10">
											<div class="group-info-gorl-persent">전체 달성률</div>
											<div class="progress">
												<div class="progress-bar progress-bar-info" role="progressbar"
													aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
													style="width: 20%">20%
												</div>
											</div>
										</div>
				
										<br>
										
										<div class="col-sm-12 no-padding margin-bottom-10">
											<a href="">
												<i class="fa fa-chevron-circle-right" aria-hidden="true"></i> 그룹 목표 페이지로 이동
											</a>
										</div>
										
										<div class="col-sm-12 no-padding">
											<div class="list-group">
												<a href="#" class="list-group-item">
													<span class="badge">7</span>
													<i class="fa fa-check-square-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;사용자 요구사항 정의서
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">38</span>
													<i class="fa fa-check-square-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;유스케이스 명세서
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">1</span>
													<i class="fa fa-check-square-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;시스템 요구사항 명세서
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">1</span>
													<i class="fa fa-check-square-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;클래스 설계서
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">3</span>
													<i class="fa fa-check-square-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;엔티티 관계 모형 정의서
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">3</span>
													<i class="fa fa-check-square-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;데이터베이스 설계서
												</a>
											</div>
										</div>
										
									</div>
									
									<div role="tabpanel" class="tab-pane" id="groupData">
										<br>
										
										<div class="col-sm-12 no-padding margin-bottom-10">
											<a href="">
												<i class="fa fa-chevron-circle-right" aria-hidden="true"></i> 그룹 데이터 페이지로 이동
											</a>
										</div>
										
										<div class="col-sm-12 no-padding margin-bottom-10">
											<div class="list-group">
												<a href="#" class="list-group-item">
													<span class="badge">7</span>
													<i class="fa fa-file-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;kosta 112기 활동 내역
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">4</span>
													<i class="fa fa-calendar profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;java 일일 강의 내용
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">6</span>
													<i class="fa fa-trophy profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;web - client 일일 강의 내용
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">0</span>
													<i class="fa fa-file-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;Database
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">0</span>
													<i class="fa fa-file-o profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;Spring
												</a>
											</div>
										</div>
										
									</div>
									
									<div role="tabpanel" class="tab-pane" id="groupDataHistory">
										<br>
										
										<div class="col-sm-12 no-padding margin-bottom-10">
											<a href="">
												<i class="fa fa-chevron-circle-right" aria-hidden="true"></i> 그룹 데이터 히스토리 페이지로 이동
											</a>
										</div>
										
										<div class="col-sm-12 no-padding margin-bottom-10">
											<div class="list-group">
												<a href="#" class="list-group-item">
													<span class="badge">7</span>
													<i class="fa fa-code-fork profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;kosta 112기 활동 내역
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">4</span>
													<i class="fa fa-code-fork profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;java 일일 강의 내용
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">6</span>
													<i class="fa fa-code-fork profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;web - client 일일 강의 내용
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">0</span>
													<i class="fa fa-code-fork profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;Database
												</a>
												<a href="#" class="list-group-item">
													<span class="badge">0</span>
													<i class="fa fa-code-fork profile-font-icon" aria-hidden="true"></i>
													&nbsp;&nbsp;Spring
												</a>
											</div>
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

<script src="${pageContext.request.contextPath}/resources/js/group-info-master.js"></script>
<script type="text/javascript">
	$(function(){
		
		var contextPath='${pageContext.request.contextPath}'
		
		$('#inviteBtn').click(function(){
			$.ajax({
		        url : contextPath+"/groupNavi/searchGroupList.dvn",
		        type: "get",
		        data : { "keyword" : $('#keyword').val() },
		        success : function(data){
		        	
		        	
		        },
		        error :function(data){
		        	alert('실패');
		        }
		    });
		});
	});
	
</script>
