<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
				<!-- content -->
				<div class="container">
				
					<div class="col-md-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 그룹</a></li>
							<li class="active">그룹 데이터</li>
						</ol>
						
						<div class="col-sm-12 no-padding margin-bottom-10">
							
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary"
								data-toggle="modal" data-target="#group-data-create">
								그룹 데이터 만들기
							</button>
			
							<!-- Modal -->
							<div class="modal fade" id="group-data-create" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
						
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">생성할 그룹 데이터 선택하기</h4>
										</div>
		
										<div class="modal-footer">
											<div class="row col-sm-12 center-block">
											
												<div class="col-sm-4">
													<div class="row">
														<div class="thumbnail">
															<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
															<div class="caption">
																<h3>아이디어 공유<br> 데이터</h3>
																<p>아이디어 공유 형 데이터는 도화지에 포스트잇(아이디어 또는 내용)을 붙일 수 있어요.</p>
																<p>
																	<a href="#" class="btn btn-primary" role="button">선택</a>
																</p>
															</div>
														</div>
													</div>
												</div>
												
												<div class="col-sm-4">
													<div class="row">
														<div class="thumbnail">
															<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
															<div class="caption">
																<h3>마인드맵 데이터</h3>
																<p>현재 열씸히 개발 중 입니다.^^</p>
																<p>
																	<a href="#" class="btn btn-primary" role="button">선택</a>
																</p>
															</div>
														</div>
													</div>
												</div>
												
											</div>
										</div>
			
									</div>
								</div>
							</div>
							<!-- Modal -->
							
							<!-- 내 데이터 가져오기 버튼 -->
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-purple"
								data-toggle="modal" data-target="#my-data-share">
								내 데이터 공유하기
							</button>
							
							<!-- Modal -->
							<form action="" method="post">
								<div class="modal fade" id="my-data-share" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
							
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">공유할 내 데이터 선택하기</h4>
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
																		데이터 제목
																	</h4>
																	<p class="list-group-item-text">
																		우주최강 번개돌이
																	</p>
																</div>
																
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		데이터 종류
																	</h4>
																	<p class="list-group-item-text">
																		노트형 데이터
																	</p>
																</div>
																
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		데이터 생성일
																	</h4>
																	<p class="list-group-item-text">
																		2016.06.20
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
																		데이터 제목
																	</h4>
																	<p class="list-group-item-text">
																		우주최강 번개돌이
																	</p>
																</div>
																
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		데이터 종류
																	</h4>
																	<p class="list-group-item-text">
																		노트형 데이터
																	</p>
																</div>
																
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		데이터 생성일
																	</h4>
																	<p class="list-group-item-text">
																		2016.06.20
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
																		데이터 제목
																	</h4>
																	<p class="list-group-item-text">
																		우주최강 번개돌이
																	</p>
																</div>
																
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		데이터 종류
																	</h4>
																	<p class="list-group-item-text">
																		노트형 데이터
																	</p>
																</div>
																
																<div class="list-group">
																	<h4 class="list-group-item-heading">
																		데이터 생성일
																	</h4>
																	<p class="list-group-item-text">
																		2016.06.20
																	</p>
																</div>
																
															</div>
														</div>
													</div>
													
												</div>
											</div>
			
											<div class="modal-footer">
												<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
												<button type="submit" class="btn btn-purple">확인</button>
											</div>
				
										</div>
									</div>
								</div>
							</form>
							<!-- Modal -->
							
							<hr>
							
							<div class="col-sm-6">
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">그룹 전용 데이터</h3>
									</div>
									<div class="panel-body">
										
										<a href="" class="a-font">
											<div class="col-sm-6">
												<div class="panel panel-primary">
													<div class="panel-heading">
														데이터 제목
													</div>
													<div class="panel-body">
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 종류
															</h4>
															<p class="list-group-item-text">
																아이디어 공유 데이터
															</p>
														</div>
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 생성자
															</h4>
															<p class="list-group-item-text">
																nameLim
															</p>
														</div>
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 최종 수정일
															</h4>
															<p class="list-group-item-text">
																2016.06.22
															</p>
														</div>
														
													</div>
												</div>
											</div>
										</a>
										
										<a href="" class="a-font">
											<div class="col-sm-6">
												<div class="panel panel-primary">
													<div class="panel-heading">
														데이터 제목
													</div>
													<div class="panel-body">
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 종류
															</h4>
															<p class="list-group-item-text">
																아이디어 공유 데이터
															</p>
														</div>
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 생성자
															</h4>
															<p class="list-group-item-text">
																nameLim
															</p>
														</div>
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 최종 수정일
															</h4>
															<p class="list-group-item-text">
																2016.06.22
															</p>
														</div>
														
													</div>
												</div>
											</div>
										</a>
										
									</div>
								</div>
							</div>
							
						
							<div class="col-sm-6">
								<div class="panel panel-purple-l">
									<div class="panel-heading">
										<h3 class="panel-title">그룹에 공유된 데이터</h3>
									</div>
									<div class="panel-body">
									<c:forEach var="sharedata" items="${sharedatalist}">
										<a href="${pageContext.request.contextPath}/sharedata/datailShareData.dvn" class="a-font">
											<div class="col-sm-6">
												<div class="panel panel-purple">
													<div class="panel-heading">
														${sharedata.dataname}
													</div>
													<div class="panel-body">
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 종류 ${sharedata.datatype}
															</h4>
															<p> 
																<c:choose>

   																	<c:when test="${sharedata.datatype eq '1'}">
        																노트형 데이터입니다.
    																</c:when>

																    <c:when test="${sharedata.datatype eq '2'}">
																        스케치형 데이터 입니다.
																    </c:when>
																
																    <c:otherwise>
																        다른 데이터입니다.
																    </c:otherwise>
																
																</c:choose>
															</p>
														</div>
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 공유자
															</h4>
															<p class="list-group-item-text">
																${sharedata.userid}
															</p>
														</div>
														
														<div class="list-group">
															<h4 class="list-group-item-heading">
																데이터 최종 수정일
															</h4>
															<p class="list-group-item-text">
																${sharedata.sharedate}
															</p>
														</div>
														
													</div>
												</div>
											</div>
										</a>
										</c:forEach>
										
										
									</div>
								</div>
							</div>
							
						</div>
						
					</div>	
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/js/group-info.js"></script>

