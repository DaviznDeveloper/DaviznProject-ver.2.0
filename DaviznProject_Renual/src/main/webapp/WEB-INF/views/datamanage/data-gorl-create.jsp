<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
				
					<div class="col-sm-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 데이터 관리</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-list.jsp">저장소 제목</a></li>
							<li class="active">목표달성 데이터 만들기</li>
						</ol>
							
							<div class="" data-toggle="modal" data-target="#gorl-create-modal">
								<span class="glyphicon glyphicon-plus gorl-create" 
									data-toggle="tooltip" title="목표 만들기" aria-hidden="true"></span>
							</div>

							<form action="" method="post" class="form-horizontal">
								<div id="gorl-create-modal" class="modal fade">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title">목표 만들기</h4>
											</div>
											<div class="modal-body">
											
												<h4 class="text-center">당신의 목표를 설정하고 실행하세요.</h4>
												
												<br>
												
												<div class="row">
													<label for="inputGorlTitle" class="col-sm-2 control-label">목표 이름</label>
													<div class="col-sm-10">
														<input type="text" name="gorlTitle" class="form-control" id="inputGorlTitle"
															placeholder="이루고 싶은 목표를 입력하세요">
													</div>
												</div>
												
												<br>
												
												<div class="row">
													<label class="col-sm-2 control-label gorl-check-create"><i class="fa fa-plus-circle" aria-hidden="true"></i> 목표 추가</label>
													<div class="col-sm-10  gorl-Check-List-Box">
														<div class="gorl-check-input-box">
															<input type="text" name="gorlCheckList" class="form-control gorlCheckList margin-bottom-10"
																placeholder="세부 목표를 입력하세요">
															<button type="button" class="close gorl-check-input-box-close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
														</div>
													</div>
												</div>
												
												<br>
												
												<div class="row">
													<label for="inputGorlTitle" class="col-sm-2 control-label">목표 날짜</label>
													<div class="col-sm-10">
														<label class="col-sm-2 control-label">시작일</label>
														<div class='col-sm-10 input-group date' id='datetimepicker1'>
											                <input type='text' name="gorlStartDate" class="form-control" placeholder="시작일을 설정하세요(우측의 달력 버튼)">
											                <span class="input-group-addon">
											                    <span class="glyphicon glyphicon-calendar"></span>
											                </span>
											            </div>
											            
											            <br>
											            
											            <label class="col-sm-2 control-label">종료일</label>
											            <div class='col-sm-10 input-group date' id='datetimepicker2'>
											                <input type='text' name="gorlEndDate" class="form-control" placeholder="종료일을 설정하세요(우측의 달력 버튼)">
											                <span class="input-group-addon">
											                    <span class="glyphicon glyphicon-calendar"></span>
											                </span>
											            </div>
													</div>
												</div>
												
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
												<button type="button" class="btn btn-primary gorl-save">저장</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
							</form>
					
							<hr>

							<a href="" class="gorl-atag">
								<div class="panel panel-success">
									<div class="panel-body">
										<div class="col-sm-12 no-padding">
											<div class="col-md-1 col-sm-2 no-padding">
												<div class="pieProgress" role="progressbar" data-goal="27" aria-valuemin="0" data-step="1" aria-valuemax="100">
											        <div class="progress__meter"><span class="pie_progress__number"></span></div>
											    </div>
											</div>
											<div class="col-sm-6 pull-left margin-top-10">
												<h3 class="gorl-list-title">3차 프로젝트</h3>
											</div>
											<div class="col-sm-5 pull-left">
												<h4>
													<span class="glyphicon glyphicon-check gorl-checklist" aria-hidden="true"></span>
													<span class="gorl-checklist">3</span> 개의 세부 목표
												</h4>
											</div>
											<div class="col-sm-5 pull-left">
												<h4>
													<span class="glyphicon glyphicon-time gorl-timeover" aria-hidden="true"></span>
													<span class="gorl-timeover">2016. 06. 24</span> 까지 완료
												</h4>
											</div>
										</div>
									</div>
								</div>
							</a>
							
							<br>
				
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/gorl/progress.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-gorl.js"></script>
