<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/ui/data-repo.jsp">데이터 관리</a></li>
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
																<a href="${pageContext.request.contextPath}/userStrg/moveNoteCreate.dvn?strgseq=${strgseq}" class="btn btn-primary" role="button">선택</a>
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
															<h3>차트형 데이터</h3>
															<p>차트형 데이터는 표에 숫자를 입력할 수 있어요.</p>
															<p>
																<a href="${pageContext.request.contextPath}/renual/data-create-chart.jsp" class="btn btn-primary" role="button">선택</a>
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
																<a href="${pageContext.request.contextPath}/sketch/*.dvn" class="btn btn-primary" role="button">선택</a>
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
																<a href="${pageContext.request.contextPath}/schedule/*.dvn" class="btn btn-primary" role="button">선택</a>
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
																<a href="${pageContext.request.contextPath}/goal/*.dvn" class="btn btn-primary" role="button">선택</a>
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
							<h3 class="col-md-9">내가 저장한 데이터 (4)</h3>
							<div  class="col-md-3">
								<select class="form-control data-m-repo-select">
									<option>내 저장소 선택</option>
									<option>2</option>
									<option>3</option>
								</select>
							</div>
						</div>
						<table class="table table-hover data-list-table">
							<colgroup>
								<col width="" data-key="title">
								<col width="200" data-key="buttons">
							</colgroup>
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
						</table>
		
					</div>
					
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

