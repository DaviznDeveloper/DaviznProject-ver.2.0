<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/communityList.dvn">커뮤니티</a></li>
							<li class="active">글 상세보기</li>
						</ol>
						
						<div class="col-md-12 no-padding margin-bottom-10">
						
							<article id="board-content" class="board-content">
			
								<div class="table-responsive">
								
									<table class="table" style=TABLE-layout:fixed>
									
										<thead class="board-thead">
										
											<tr>
											
												<th scope="col" class="ellipsis board-d-title">${notice.boardsubject}</th>
												<th scope="col" class="board-d-date">${notice.boarddate}</th>
												
											</tr>
											
											<tr>
												
												<th scope="col" class="board-d-writer">${notice.userid}</th>
												<th scope="col" class="board-d-lookup">${notice.boardreadcount}</th>
											
											</tr>
										
										</thead>
										
										<tbody>
											
											<tr>
											
												<td colspan="2" scope="col" class="">
													
													<div class="col-xs-12 col-md-12 board-d-content-box">
													
														<p class="board-d-content">${notice.boardcontent}</p>
													
													</div>
													
												</td>
												
											</tr>
											
											<tr>
											
												<td colspan="2" scope="col" class="">
													<div class="">
														
														<c:if test="${notice.userid == userid || userid == 'admin'}">
															<a class="btn btn-default"
																href="communityedit.dvn?boardseq=${notice.boardseq}"
																role="button">수정</a>
				
															<!-- delete modal -->
															<button type="button" class="btn btn-default"
																data-toggle="modal" data-target=".bs-example-modal-sm">삭제</button>
				
															<div class="modal fade bs-example-modal-sm" tabindex="-1"
																role="dialog" aria-labelledby="mySmallModalLabel"
																aria-hidden="true" style="display: none;">
																<div class="modal-dialog modal-sm">
																	<div class="modal-content">
				
																		<div class="modal-header">
																			<button type="button" class="close" data-dismiss="modal"
																				aria-label="Close">
																				<span aria-hidden="true">×</span>
																			</button>
																			<h4 class="modal-title" id="mySmallModalLabel">
																				정말 삭제하시겠습니까?<a class="anchorjs-link"
																					href="#mySmallModalLabel"> <span
																					class="anchorjs-icon"></span>
																				</a>
																			</h4>
																		</div>
				
																		<div class="modal-body">
																			<a class="btn btn-danger"
																				href="communitydel.dvn?boardseq=${notice.boardseq}"
																				role="button">삭제</a>
																			<button type="button" class="btn btn-default"
																				data-dismiss="modal">취소</button>
																		</div>
																	</div>
															 </c:if>
																<!-- /.modal-content -->												
															</div>
															<!-- /.modal-dialog -->
															
														</div>	
														<a class="btn btn-default" href="${pageContext.request.contextPath}/cmreplyReg.dvn?boardref=${notice.boardref}&boardseq=${notice.boardseq}&boardlev=${notice.boardlev}&boardorder=${notice.boardorder}" role="button">답글</a>												
														<a class="btn btn-default" href="${pageContext.request.contextPath}/communityList.dvn" role="button">목록</a>
													</div>
												</td>
											
											</tr>
				 								
			 								<!-- 댓 글 시작 -->
											<c:forEach items="${replylist}" var="n">	
											<tr>
												<td scope="col" class="ellipsis">
													
													<div class="row">
														<span class="reply-writer" name="">${n.userid}</span>
														<span class="reply-date" name="">${n.replydate}</span>
														<input type = "hidden" value = "1">
													</div>
													
													<div class="row">
														<p class="ellipsis reply-content" name="">
															<span>${n.replycontent}</span>
														</p>
													</div>
													
												</td>
												
												<td scope="col" class="">
												
													<div class="navbar-header">
														<button type="button" class="navbar-toggle collapsed"
															data-toggle="collapse" data-target="#reply-navbar" aria-expanded="false"
															aria-controls="navbar">
															<span class="sr-only">Toggle navigation</span>
															<span class="glyphicon glyphicon-option-vertical"></span>
														</button>
													</div>
												
													<div id="reply-navbar" class="navbar-collapse collapse">
														<ul class="nav navbar-nav navbar-right">
															<!-- <li class="nav_menu"><a href="#" class="btn btn-default">댓글</a></li>-->
															<!-- <li class="nav_menu"><a href="#" class="btn btn-default">수정</a></li>-->
															<c:if test="${notice.userid == user || user == 'admin'}">
															<li class="nav_menu"><a href="${pageContext.request.contextPath}/community/deleteReply.dvn?boardseq=${n.boardseq}&replynum=${n.replynum}" class="btn btn-default">삭제</a></li>
															</c:if>
														</ul>
													</div>
													
												</td> 
											<!-- 댓글 끝 -->
											</tr>
				 							</c:forEach>
				 							
											<tr>
											
												<form action="${pageContext.request.contextPath}/community/replyWrite.dvn" method="post">
											
													<td scope="col" class="">
														
														<div class="form-group">
															<textarea rows="" class="form-control" name="replycontent"
																placeholder="댓글을 입력하세요." required="required"></textarea>
															<input type="hidden" class="form-control" name="userid" value="${notice.userid}" >
															<input type="hidden" class="form-control" name="boardseq" value="${notice.boardseq}" >
														</div>
														
													</td>
													
													<td scope="col" class="">
													
														<div id="reply-navbar" class="navbar-collapse collapse">
															<ul class="nav navbar-nav navbar-right">
																<li class="nav_menu">
																<button type="submit" class="btn btn-success" id = "write_submit">확인</button>
															</ul>
														</div>
														
													</td>
													
												</form>
											
											</tr>
										
										</tbody>
									
									</table>
							
							</article>
						
						</div>	
						
						<br>
					
						<div id="push"></div>
					
					</div>
					
				</div>
			
			</div>
			
		</div>
		
<script src="${pageContext.request.contextPath}/resources/js/community.js"></script>