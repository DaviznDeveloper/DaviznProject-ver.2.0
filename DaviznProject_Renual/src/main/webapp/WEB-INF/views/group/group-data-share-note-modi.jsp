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
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">그룹에 공유된 데이터</a></li>
							<li class="active">그룹에 공유된 데이터 수정하기</li>
						</ol>
						
						<form action="" method="post">
							
							<div class="note-detail-option">
							
								<span data-toggle="modal" data-target="#group-data-push">
									<span class="glyphicon glyphicon-cloud-upload group-data-share-note-modi-btn" 
										data-toggle="tooltip" title="그룹 원본 데이터에 저장하기" aria-hidden="true"></span>
								</span>
								
								<!-- Modal -->
								<div class="modal fade" id="group-data-push" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
							
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">그룹 원본 데이터에 저장하기</h4>
											</div>
			
											<div class="modal-body">
												<div class="row col-xs-12 center-block">

													<div class="form-group">
														<label for="groupPushComment">원본 수정에 대한 코멘트</label>
														<textarea name="" id="groupPushComment" class="form-control textarea-size-fix"></textarea>
													</div>
												
												</div>
											</div>
			
											<div class="modal-footer">
												<div class="row col-sm-12 center-block">
												
													<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
													<button type="submit" class="btn btn-primary">확인</button>
													
												</div>
											</div>
				
										</div>
									</div>
								</div>
								<!-- Modal -->
								<a href="">
								<span data-toggle="modal" data-target="#group-data-pick">
									<span class="glyphicon glyphicon-cloud-download group-data-share-note-modi-btn" 
										data-toggle="tooltip" title="내 저장소에 저장하기" aria-hidden="true"></span>
								</span>
								</a>
								<a href="">
									<span class="group-data-share-note-modi-btn" data-toggle="tooltip" title="데이터 히스토리 보기" aria-hidden="true">
										<i class="fa fa-code-fork" aria-hidden="true"></i>
									</span>
								</a>
								
								<!-- Modal -->
								<div class="modal fade" id="group-data-pick" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
							
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">데이터를 저장할 저장소 선택하기</h4>
											</div>
			
											<div class="modal-body">
												<div class="row col-xs-12 center-block">
												
													<div class="col-sm-4">
														<div class="panel panel-purple">
															<div class="panel-heading">
																<div class="radio">
																	<label>
																		<!-- input[type=radio] name값 = 데이터일련번호 멤버필드명 / value값 = "데이터 일련번호값" -->
																		<input type="radio" name="optionsRadios"
																		id="optionsRadios1" value="option1">
																		데이터 저장소 제목
																	</label>
																</div>
															</div>
															<div class="panel-body">
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		총 3 건의 데이터가 있습니다.
																	</h4>
																	<p class="list-group-item-text">
																		7 건의 데이터 저장 가능.
																	</p>
																</div>
																
															</div>
														</div>
													</div>
													
													<div class="col-sm-4">
														<div class="panel panel-purple">
															<div class="panel-heading">
																<div class="radio">
																	<label>
																		<!-- input[type=radio] name값 = 데이터일련번호 멤버필드명 / value값 = "데이터 일련번호값" -->
																		<input type="radio" name="optionsRadios"
																		id="optionsRadios1" value="option1">
																		데이터 저장소 제목
																	</label>
																</div>
															</div>
															<div class="panel-body">
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		총 3 건의 데이터가 있습니다.
																	</h4>
																	<p class="list-group-item-text">
																		7 건의 데이터 저장 가능.
																	</p>
																</div>
																
															</div>
														</div>
													</div>
												
												</div>
											</div>
			
											<div class="modal-footer">
												<div class="row col-sm-12 center-block">
												
													<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
													<button type="submit" class="btn btn-purple">확인</button>
													
												</div>
											</div>
				
										</div>
									</div>
								</div>
								<!-- Modal -->
							</div>
						
							<input type="text" name="" class="form-control input-lg note-title" placeholder="제목을 입력하세요">
							
							<br>
							
							<textarea name="inputArticleContents" id="ckeditor" class="ckeditor-box" rows="50" cols="50"></textarea>
							
						</form>
				
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-note.js"></script>

