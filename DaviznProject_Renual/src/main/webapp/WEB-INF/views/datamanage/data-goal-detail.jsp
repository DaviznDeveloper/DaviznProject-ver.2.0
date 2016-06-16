<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
		<!-- content -->
		<div class="container">
		
			<div class="col-md-12 content-container">
		
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
					<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 데이터 관리</a></li>
					<li><a href="${pageContext.request.contextPath}/renual/data-list.jsp">저장소 제목</a></li>
					<li class="active">노트형 데이터  제목</li>
				</ol>
		
				<div class="note-detail-option">
					<span class="" data-toggle="modal" data-target="#gorl-modi-modal">
						<span class="glyphicon glyphicon-pencil note-detail-modi" 
							data-toggle="tooltip" title="목표 수정하기" aria-hidden="true"></span>
					</span>
					
					<span class="glyphicon glyphicon-trash note-detail-modi" 
						data-toggle="tooltip" title="목표 삭제하기" aria-hidden="true"></span>
				</div>
				
				<form action="" method="post" class="form-horizontal">
					<div id="gorl-modi-modal" class="modal fade">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">목표 수정하기</h4>
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
				
				<div class="col-sm-8 col-sm-offset-2">
					<h2 class="text-center gorl-detail-title">3차 프로젝트</h2>
					<br>
				</div>
				
				
				<div class="col-sm-8 col-sm-offset-2">
					<div id="CountDownTimer" data-timer="900000"></div>
					<br>
				</div>
				
				
				<div class="col-sm-8 col-sm-offset-2">
				
					<div class="col-sm-3 gorl-pie">
						<div class="pieProgress" role="progressbar" data-goal="27" aria-valuemin="0" data-step="1" aria-valuemax="100">
					        <div class="progress__meter"><span class="pie_progress__number"></span></div>
					    </div>
					    <h3 class="text-center">목표 달성률</h3>
					</div>
				
					<div class="col-sm-8 col-sm-offset-1">
					
						<div class="input-group">
							<span class="input-group-addon">
								<input type="checkbox" class="gorl-detail-checkbox">
							</span>
							<input type="text" name="gorl-detail-checklist" class="form-control gorl-detail-checklist" value="데이터 관리" readonly>
						</div>
						
						<br>
						
						<div class="input-group">
							<span class="input-group-addon">
								<input type="checkbox" class="gorl-detail-checkbox">
							</span>
							<input type="text" name="gorl-detail-checklist" class="form-control gorl-detail-checklist" value="그룹 기능" readonly>
						</div>
						
						<br>
						
						<div class="input-group">
							<span class="input-group-addon">
								<input type="checkbox" class="gorl-detail-checkbox">
							</span>
							<input type="text" name="gorl-detail-checklist" class="form-control gorl-detail-checklist" value="통계" readonly>
						</div>
						
					</div>
					
				</div>
						
			</div>
			
		</div>
		
		<div id="push"></div>
		<div id="push"></div>
		
	</div>
	
</div>

<script src="${pageContext.request.contextPath}/resources/lib/gorl/progress.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/TimeCircles/inc/TimeCircles.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-gorl.js"></script>
<script type="text/javascript">
	$(function() {
		// gorl-countdown
		$("#CountDownTimer").TimeCircles();
		
		// gorl-detail-checklist
		$(".gorl-detail-checkbox").change(function(){
	        if($(this).is(":checked")){
	            $(this).parent().css('background','#9cff80');
	            $(this).parent().css('border','1px solid #2dbe60');
	            $(this).parent().siblings().css('border','1px solid #2dbe60');
	            gorlChecking();
	        }else{
	        	$(this).parent().css('background','#eee');
	        	$(this).parent().css('border','1px solid #ccc');
	        	$(this).parent().siblings().css('border','1px solid #ccc');
	        	gorlChecking();
	        }
		});
	});
	
	function gorlChecking() {
		var checklist = $("input[type=checkbox]").length;
		var checked = $("input:checked").length;
		var gorlPercent = Math.round(eval((checked / checklist) * 100));
		
		$(".pieProgress").asPieProgress('go',gorlPercent);;
		
	}
</script>
