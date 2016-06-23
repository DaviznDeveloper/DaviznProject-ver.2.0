<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/userStrg.dvn">데이터 관리</a></li>
							<li class="active">저장소 제목</li>
						</ol>
						
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-success"
							data-toggle="modal" data-target="#data-create">
							데이터 만들기
						</button>
		
						<!-- Modal -->
						<div class="modal fade" id="data-create" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
					
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">생성할 데이터 선택하기</h4>
									</div>
	
									<div class="modal-footer">
										<div class="row col-md-12 center-block">
										
											<div class="col-md-4">
												<div class="row">
													<div class="thumbnail">
														<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
														<div class="caption">
															<h3>노트형 데이터</h3>
															<p>노트형 데이터는 글과 사진, 동영상 등을 입력할 수 있어요.</p>
															<p>
																<a href="${pageContext.request.contextPath}/note/moveNoteCreate.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
															</p>
														</div>
													</div>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="row">
													<div class="thumbnail">
														<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
														<div class="caption">
															<h3>포스트잇 데이터</h3>
															<p>포스트 잇형 데이터는 간단하게 메모가 가능해요 .</p>
															<p>
																<a href="${pageContext.request.contextPath}/postit/movePostItCreate.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
															</p>
														</div>
													</div>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="row">
													<div class="thumbnail">
														<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
														<div class="caption">
															<h3>스케치형 데이터</h3>
															<p>스케치형 데이터는 스케치북에 그림이나 글을 펜으로 그리듯이 작성할 수 있어요.</p>
															<p>
																<a href="${pageContext.request.contextPath}/sketch/moveSketchCreate.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
															</p>
														</div>
													</div>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="row">
													<div class="thumbnail">
														<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
														<div class="caption">
															<h3>앨범형 데이터</h3>
															<p>앨범형 데이터는 사진을 앨범처럼 저장할 수 있어요.</p>
															<p>
																<a href="${pageContext.request.contextPath}/datamanage/goStoreData.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
															</p>
														</div>
													</div>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="row">
													<div class="thumbnail">
														<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
														<div class="caption">
															<h3>일정관리형 데이터</h3>
															<p>일정관리형 데이터는 날짜를 지정하고 그 날에 해야할 일을 등록할 수 있어요.</p>
															<p>
																<a href="${pageContext.request.contextPath}/schedule/goScheduleList.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
															</p>
														</div>
													</div>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="row">
													<div class="thumbnail">
														<img src="${pageContext.request.contextPath}/resources/img/data-image.jpg" alt="..." height="150">
														<div class="caption">
															<h3>목표달성형 데이터</h3>
															<p>목표달성형 데이터는 D-day를 지정하고 목표를 등록할 수 있어요.</p>
															<p>
																<a href="${pageContext.request.contextPath}/goal/goGoalList.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
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
		
						<br>
		
						<div class="row no-padding">
							<h3 class="col-md-9">내가 저장한 데이터 (${listsize})</h3>
							<div  class="col-md-3">
								<select class="form-control data-m-repo-select" name="selectStrg">
									<option>내 저장소 선택</option>
									<option>2</option>
									<option>3</option>
								</select>
							</div>
						</div>
						<%-- <table class="table table-hover data-list-table">
							<colgroup>
							<tbody>
									<c:forEach var="d" items="${list2}">
							<tr>
								<td>
									<div class="data-list-div">
										<i class="fa fa-language chart-list-type" aria-hidden="true"></i>
										<a href="#" data-toggle="tooltip" title="데이터 수정하기">
											<span class="data-list-span">${d.dataname}</span>
										</a>
										<span class="data-list-span">${d.createdate}</span>
									</div>
								</td>
								<td>
									<a href="" class="btn btn-warning chart-list-option-btn" data-toggle="tooltip" title="데이터 수정하기">
										<i class="fa fa-pencil chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-info chart-list-option-btn" data-toggle="tooltip" title="데이터 공유하기">
										<i class="fa fa-share-alt chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-success chart-list-option-btn chr-list-btn-dash" data-toggle="tooltip" title="대시보드에 추가하기">
										<i class="fa fa-tachometer chart-list-option" aria-hidden="true" ></i>
									</a>
									<a href="" class="btn btn-danger chart-list-option-btn" data-toggle="tooltip" title="데이터 삭제하기">
										<i class="fa fa-trash-o chart-list-option" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
							</tbody>
						</table> --%>
						
						<table class="table table-hover data-list-table">
						<colgroup>
							<col width="" data-key="title">
							<col width="200" data-key="buttons">
						</colgroup>
						<tbody>
						
							<c:forEach items="${pdatalist}" var="pdata" varStatus="status">
							
								<tr>
									<td>
										<div class="data-list-div">
											<i class="fa fa-language chart-list-type" aria-hidden="true"></i>
											<a href="${pageContext.request.contextPath}/personalData/detailPersonalData.dvn?datatype=${pdata.datatype}&strgseq=${pdata.strgseq}&dataseq=${pdata.dataseq}" data-toggle="tooltip" title="데이터 상세하기">
												<span class="data-list-span">${pdata.dataname}</span>
											</a>
											<span class="data-list-span">${pdata.datacreate}</span>
										</div>
									</td>
								
									<td>
									<span class="pull-right margin-right-10">
										<a href="${pageContext.request.contextPath}/personalData/deletePersonalData.dvn?strgseq=${pdata.strgseq}&dataseq=${pdata.dataseq}" class="btn btn-danger chart-list-option-btn" data-toggle="tooltip" title="데이터 삭제하기">
											<i class="fa fa-trash-o chart-list-option" aria-hidden="true"></i>
										</a>
									</span>
											
									<span class="pull-right margin-right-10" data-toggle="tooltip" title="데이터 공유하기">
										<div class="btn btn-info chart-list-option-btn" data-toggle="modal" data-target="#data-share${status.index}">
											<i class="fa fa-share-alt chart-list-option" aria-hidden="true"></i>
										</div>
									</span>
									<!-- modal -->
									<form action="${pageContext.request.contextPath}/sharedata/addShareData.dvn" method="post">
										<input type="hidden" id="dataseq" name="dataseq" value="${pdata.strgseq}">
										<input type="hidden" id="datatype" name="datatype" value="${pdata.datatype}">
										<input type="hidden" id="dataname" name="dataname" value="${pdata.dataname}">
	                     				<div class="modal fade" id="data-share${status.index}" tabindex="-1" role="dialog"
											aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog modal-lg">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">데이터 공유하기
																strseq   :	${pdata.strgseq}
																datatype :  ${pdata.datatype}
																dataname :  ${pdata.dataname}
														</h4>
													</div>
													<div class="modal-body">
														<div class="row col-xs-12 center-block">
											 				<c:forEach var="group" items="${groupList}">
																<div class="col-sm-4">
																	<div class="panel panel-info">
																		<div class="panel-heading">
																			<div class="radio">
																				<label>
																				<!-- input[type=radio] name값 = 데이터일련번호 멤버필드명 / value값 = "데이터 일련번호값" -->
																					<input type="radio" name="groupseq"
																						id="groupseq" value="${group.groupseq}">
																						<h3>${group.groupname}</h3>
																				</label>
																			</div>
																		</div>
																		<div class="panel-body">
																			<div class="list-group">
																				<h4 class="list-group-item-heading">
																					그룹장 : ${group.groupmaster}
																				</h4>
																				
																				<p class="list-group-item-text">
																					현재 ${group.g_datacount}건의 데이터가 저장되어있습니다.
																				</p>
																			</div>
																		</div>
																	</div>
																</div>
															</c:forEach>
														</div>
													</div>
						
													<div class="modal-footer">
														<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
														<button type="submit" class="btn btn-info">확인</button>
													</div>
												</div>
											</div>
										</div>
	                				</form>
										<!-- modal -->
									</td>
							</tr>
							
							</c:forEach>
							
							<!-- <tr>
								<td>
									<div class="data-list-div">
										<i class="fa fa-bar-chart chart-list-type" aria-hidden="true"></i>
										<a href="#" data-toggle="tooltip" title="데이터 수정하기">
											<span class="data-list-span">여기는 제목입니다.</span>
										</a>
										<span class="data-list-span">2016-05-09 00:31:19</span>
									</div>
								</td>
								<td>
									<a href="" class="btn btn-warning chart-list-option-btn" data-toggle="tooltip" title="데이터 수정하기">
										<i class="fa fa-pencil chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-info chart-list-option-btn" data-toggle="tooltip" title="데이터 공유하기">
										<i class="fa fa-share-alt chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-success chart-list-option-btn chr-list-btn-dash" data-toggle="tooltip" title="대시보드에 추가하기">
										<i class="fa fa-tachometer chart-list-option" aria-hidden="true" ></i>
									</a>
									<a href="" class="btn btn-danger chart-list-option-btn" data-toggle="tooltip" title="데이터 삭제하기">
										<i class="fa fa-trash-o chart-list-option" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
							
							<tr>
								<td>
									<div class="data-list-div">
										<i class="fa fa-pie-chart chart-list-type" aria-hidden="true"></i>
										<a href="#" data-toggle="tooltip" title="데이터 수정하기">
											<span class="data-list-span">여기는 제목입니다.</span>
										</a>
										<span class="data-list-span">2016-05-09 00:31:19</span>
									</div>
								</td>
								<td>
									<a href="" class="btn btn-warning chart-list-option-btn" data-toggle="tooltip" title="데이터 수정하기">
										<i class="fa fa-pencil chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-info chart-list-option-btn" data-toggle="tooltip" title="데이터 공유하기">
										<i class="fa fa-share-alt chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-success chart-list-option-btn chr-list-btn-dash" data-toggle="tooltip" title="대시보드에 추가하기">
										<i class="fa fa-tachometer chart-list-option" aria-hidden="true" ></i>
									</a>
									<a href="" class="btn btn-danger chart-list-option-btn" data-toggle="tooltip" title="데이터 삭제하기">
										<i class="fa fa-trash-o chart-list-option" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
							
							<tr>
								<td>
									<div class="data-list-div">
										<i class="fa fa-area-chart chart-list-type" aria-hidden="true"></i>
										<a href="#" data-toggle="tooltip" title="데이터 수정하기">
											<span class="data-list-span">여기는 제목입니다.</span>
										</a>
										<span class="data-list-span">2016-05-09 00:31:19</span>
									</div>
								</td>
								<td>
									<a href="" class="btn btn-warning chart-list-option-btn" data-toggle="tooltip" title="데이터 수정하기">
										<i class="fa fa-pencil chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-info chart-list-option-btn" data-toggle="tooltip" title="데이터 공유하기">
										<i class="fa fa-share-alt chart-list-option" aria-hidden="true"></i>
									</a>
									<a href="" class="btn btn-success chart-list-option-btn chr-list-btn-dash" data-toggle="tooltip" title="대시보드에 추가하기">
										<i class="fa fa-tachometer chart-list-option" aria-hidden="true" ></i>
									</a>
									<a href="" class="btn btn-danger chart-list-option-btn" data-toggle="tooltip" title="데이터 삭제하기">
										<i class="fa fa-trash-o chart-list-option" aria-hidden="true"></i>
									</a>
								</td>
							</tr> -->
						</tbody>
					</table>
		
					</div>
					
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

