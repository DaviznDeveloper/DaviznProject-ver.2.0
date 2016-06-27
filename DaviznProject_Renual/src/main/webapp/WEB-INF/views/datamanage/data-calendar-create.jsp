<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


				
				<!-- content -->
				<div class="container">
				
					<div class="col-sm-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/userStrg.dvn">저장소 목록</a></li>
				           	<li><a href="${pageContext.request.contextPath}/personalData/showPersonalDataList.dvn?strgseq=${strgseq}">데이터 목록</a></li>
							<li class="active">일정관리 데이터 만들기</li>
						</ol>
							
							<div class="" data-toggle="modal" data-target="#schedule-create-modal">
								<span class="glyphicon glyphicon-plus goal-create" 
									data-toggle="tooltip" title="일정 만들기" aria-hidden="true"></span>
							</div>

							<form action="${pageContext.request.contextPath}/schedule/createSchedule.dvn" method="post" class="form-horizontal">
								<input type="hidden" name="datatype" value="4">
								<input type="hidden" name="strgseq" value="${strgseq}">
								<input type="hidden" name="origin" value="personal"> 
								<div id="schedule-create-modal" class="modal fade">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title">일정 만들기</h4>
											</div>
											<div class="modal-body">
											
												<h4 class="text-center">당신의 일정을 계획하세요.</h4>
												
												<br>
												
												<div class="row">
													<label for="inputscheduleTitle" class="col-sm-2 control-label">일정 이름</label>
													<div class="col-sm-10">
														<input type="text" name="dataname" class="form-control" id="inputscheduleTitle"
															placeholder="일정 이름을 입력하세요">
													</div>
												</div>
												
												<br>
												
												<div class="row">
													<label for="inputscheduleContent" class="col-sm-2 control-label">일정 내용</label>
													<div class="col-sm-10">
														<textarea name="schcontext" class="form-control" rows="3" id="inputscheduleContent"
															placeholder="일정 내용을 입력하세요"></textarea>
													</div>
												</div>
												
												<br>
												
												<div class="row">
													<label for="inputgoalTitle" class="col-sm-2 control-label">일정 날짜</label>
													<div class="col-sm-10">
														<label class="col-sm-2 control-label">시작일</label>
														<div class='col-sm-10 input-group date' id='datetimepicker1'>
											                <input type='text' name="startdate" class="form-control" placeholder="시작일을 설정하세요(우측의 달력 버튼)">
											                <span class="input-group-addon">
											                    <span class="glyphicon glyphicon-calendar"></span>
											                </span>
											            </div>
											            
											            <br>
											            
											            <label class="col-sm-2 control-label">종료일</label>
											            <div class='col-sm-10 input-group date' id='datetimepicker2'>
											                <input type='text' name="finaldate" class="form-control" placeholder="종료일을 설정하세요(우측의 달력 버튼)">
											                <span class="input-group-addon">
											                    <span class="glyphicon glyphicon-calendar"></span>
											                </span>
											            </div>
													</div>
												</div>
												
												<br>
												
												<div class="row">
													<label for="inputgoalTitle" class="col-sm-2 control-label">알림 설정</label>
													<div id="notice-box" class="col-sm-10">
														<div class='col-sm-2'>
															<div id="calendar-notice-btn" class="pull-right margin-top-5">
										                		<input type="checkbox" id="myswitch" name="state" checked="checked" value="1">
											            	</div>
											            </div>
											             <div class='col-sm-10 input-group date' id='datetimepicker3'>
											                <input type='text' class="form-control" name="alramdate">
											                <span class="input-group-addon">
											                    <i class="fa fa-bell-o" aria-hidden="true"></i>
											                </span>
											            </div>
													</div>
												</div>
												
												<br>
												
												<div class="row">
													<label for="inputscheduleContent" class="col-sm-2 control-label">우선순위</label>
													<div class="col-sm-10">
														<div class="col-sm-2"></div>

														<div class="btn-group" data-toggle="buttons">
															<label class="btn btn-default calender-priority">
																<input type="radio" name="priority" value="5" id="priority1" autocomplete="off">
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
															</label> 
															<label class="btn btn-default calender-priority">
																<input type="radio" name="priority" value="4" id="priority2" autocomplete="off">
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
															</label>
															<label class="btn btn-default calender-priority active">
																<input type="radio" name="priority" value="3" id="priority3" autocomplete="off" checked>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
															</label>
															<label class="btn btn-default calender-priority">
																<input type="radio" name="priority" value="2" id="priority4" autocomplete="off">
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
															</label>
															<label class="btn btn-default calender-priority">
																<input type="radio" name="priority" value="1" id="priority5" autocomplete="off">
																<i class="fa fa-star calendar-star" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
																<i class="fa fa-star-o" aria-hidden="true"></i>
															</label>
														</div>
														
													</div>
												</div>
												
												<br>
												
												<div class="row">
													
												</div>
												
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
												<button type="submit" class="btn btn-primary goal-save">저장</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
							</form>
					
							<hr>

							
							<div class="col-sm-6">
								<h5>진행중인 일정</h5>
															
							<c:forEach items="${clist}" var="cschedule">
								<a href="${pageContext.request.contextPath}/schedule/detailSchedule.dvn?dataseq=${cschedule.dataseq}">
									<div class="panel panel-info">
										<div class="panel-body">
											
											<div class="col-sm-9 no-padding">
												<div class="calendar-title word-ellipsis">
													${cschedule.dataname}
												</div>
												
												<div class="calendar-date word-ellipsis">
													${cschedule.startdate} ~ ${cschedule.finaldate}
												</div>
											</div>
											
											<div class="col-sm-3 no-padding margin-top-10">
												<div class="text-center">
												 	<c:forEach var="i" begin="1" end="${cschedule.priority}">
														<i class="fa fa-star calendar-star" aria-hidden="true"></i>
													</c:forEach>
													
													<c:if test="${5-cschedule.priority}>0">
													<c:forEach var="i" begin="1" end="${5-cschedule.priority}">
														<i class="fa fa-star-o" aria-hidden="true"></i>
													</c:forEach>
													</c:if>
													
												</div>
											</div>
											
										</div>
									</div>
								</a>						
								</c:forEach> 
								
							</div>
							
							<div class="col-sm-6">
								<h5>완료된 일정</h5>
															
						 		 <c:forEach items="${elist}" var="eschedule">
						 		
								<a href="${pageContext.request.contextPath}/schedule/detailSchedule.dvn?dataseq=${eschedule.dataseq}">
									<div class="panel panel-danger">
										<div class="panel-body">
											
											<div class="col-sm-9 no-padding">
												<div class="calendar-title word-ellipsis">
													${eschedule.dataname}
												</div>
												
												<div class="calendar-date word-ellipsis">
													${eschedule.startdate} ~ ${eschedule.finaldate}
												</div>
											</div>
											
											<div class="col-sm-3 no-padding margin-top-10">
												<div class="text-center">
												
												<c:forEach var="i" begin="1" end="${eschedule.priority}">
														<i class="fa fa-star calendar-star" aria-hidden="true"></i>
												</c:forEach>
													
													<c:if test="${5-eschedule.priority}>0">
													<c:forEach var="i" begin="1" end="${5-eschedule.priority}">
														<i class="fa fa-star-o" aria-hidden="true"></i>
													</c:forEach>
													</c:if>
												
												</div>
											</div>
											
										</div>
									</div>			
								</a>						
								</c:forEach>  
								
							</div>
							
							<br>
				
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/lib/switch/switchable.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/calendar.js"></script>

