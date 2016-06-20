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
							<li><a href="${pageContext.request.contextPath}/renual/data-list.jsp">일정관리 리스트</a></li>
							<li class="active">일정관리 데이터 상세보기</li>
						</ol>
						
						<div class="col-sm-10 col-sm-offset-1">
						
							<div class="calendar-detail-option">
	
								<form action="${pageContext.request.contextPath}/schedule/updateSchedule.dvn?dataseq=${schedule.dataseq}" method="post" id="scheduleForm">
													
									<br>
							
										<h4 class="text-center">당신의 일정을 계획하세요.</h4>
												
									<br>
							
									<div class="row">
										<label for="inputscheduleTitle" class="col-sm-2 control-label">일정 이름</label>
										<div class="col-sm-10">
											<input type="text" name="dataname" class="form-control" id="inputscheduleTitle"
											placeholder="일정 이름을 입력하세요" value="${schedule.dataname}">
										</div>
									</div>
							
									<br>
							
									<div class="row">
										<label for="inputscheduleContent" class="col-sm-2 control-label">일정 내용</label>
										<div class="col-sm-10">
											<textarea name="schcontext" class="form-control" rows="3" id="inputscheduleContent"
												placeholder="일정 내용을 입력하세요">${schedule.schcontext}</textarea>
										</div>
									</div>
							
									<br>
							
									<div class="row">
										<label for="inputGorlTitle" class="col-sm-2 control-label">일정 날짜</label>
										<div class="col-sm-10">
											<label class="col-sm-2 control-label">시작일</label>
											<div class='col-sm-10 input-group date' id='datetimepicker1'>
						                		<input type='text' name="startdate" class="form-control" placeholder="${schedule.startdate}" value="${schedule.startdate}">
						               	 		<span class="input-group-addon">
						                    		<span class="glyphicon glyphicon-calendar"></span>
						               			</span>
						            		</div>
						            
						            		<br>
						            
						           		 	<label class="col-sm-2 control-label">종료일</label>
						            		<div class='col-sm-10 input-group date' id='datetimepicker2'>
						                		<input type='text' name="finaldate" class="form-control" placeholder="${schedule.finaldate}" value="${schedule.finaldate}">
						                		<span class="input-group-addon">
						                    		<span class="glyphicon glyphicon-calendar"></span>
						                		</span>
						            		</div>
										</div>
									</div>
							
									<br>
							
									<div class="row">
										<label for="inputGorlTitle" class="col-sm-2 control-label">알림 설정</label>
										<div id="notice-box" class="col-sm-10">
											<div class='col-sm-2'>
												<div id="calendar-notice-btn" class="pull-right margin-top-5">
					                				<input type="checkbox" id="myswitch" name="state" checked="checked">
						            			</div>
						            		</div>
						            		<div class='col-sm-10 input-group date' id='datetimepicker3'>
						                		<input type="text" class="form-control" name="alramdate" placeholder="${schedule.alramdate}" value="${schedule.alramdate}">
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
									<span class="glyphicon glyphicon-floppy-saved font-icon-green" 
										data-toggle="tooltip" title="일정 저장하기" aria-hidden="true" id="Updateschedule"></span>		
									
									<a href="${pageContext.request.contextPath}/schedule/deleteSchedule.dvn?dataseq=${schedule.dataseq}&strgseq=${schedule.strgseq}">
										<span class="glyphicon glyphicon-trash font-icon-green" data-toggle="tooltip" title="일정 삭제하기" aria-hidden="true">
										</span>
									</a>
								</form>
							</div>	
						</div>		
					</div>
				
					<div id="push"></div>
					<div id="push"></div>	
				</div>	

<script src="${pageContext.request.contextPath}/resources/lib/switch/switchable.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/calendar.js"></script>
<<script type="text/javascript">

	$(function(){
		$('#Updateschedule').click(function(){
			$('#scheduleForm').submit();
		});
	});
</script>

<!--

//-->

