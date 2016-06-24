<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   
      <!-- content -->
      <div class="container">
      
      <c:forEach items="${gdata}" var="goal" begin="0" end="0">
         <c:set var="dataname" value="${goal.dataname}" />
         <c:set var="goaldate" value="${goal.goaldate}" />
         <c:set var="strgseq" value="${goal.strgseq}" />
         <c:set var="dataseq" value="${goal.dataseq}"/>
         <c:set var="startdate" value="${goal.startdate}" />
         <c:set var="finaldate" value="${goal.finaldate}" />
      </c:forEach>
      
         <div class="col-md-12 content-container">
            <ol class="breadcrumb">
               <li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
               <li><a href="${pageContext.request.contextPath}/userStrg.dvn">저장소 목록</a></li>
               <li><a href="${pageContext.request.contextPath}/personalData/showPersonalDataList.dvn?strgseq=${strgseq}">데이터 목록</a></li>
               <li><a href="${pageContext.request.contextPath}/goal/goGoalList.dvn?strgseq=${strgseq}">목표 목록</a></li>
               <li class="active">${dataname}</li>

				</ol>
		
				<div class="note-detail-option">
					<span class="goal-detail-modi-btn" data-toggle="modal" data-target="#goal-modi-modal">
						<span class="glyphicon glyphicon-pencil note-detail-modi" 
							data-toggle="tooltip" title="목표 수정하기" aria-hidden="true"></span>
					</span>
					
					<a href="${pageContext.request.contextPath}/personalData/deletePersonalData.dvn?dataseq=${dataseq}&strgseq=${strgseq}">
						<span class="glyphicon glyphicon-trash note-detail-modi" 
							data-toggle="tooltip" title="목표 삭제하기" aria-hidden="true"></span>
					</a>
				</div>
				
				<form action="${pageContext.request.contextPath}/goal/updateGoal.dvn?dataseq=${dataseq}&strgseq=${strgseq}" method="post" class="form-horizontal" id="goalcreateForm">
					<input type="hidden" name="goalhtml" id="goalhtml" value="">
					<input type="hidden" name="datatype" value="3">
					<div id="goal-modi-modal" class="modal fade">
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
										<label for="inputgoalTitle" class="col-sm-2 control-label">목표 이름</label>
										<div class="col-sm-10">
											<input type="hidden" id="dataseq" value="${dataseq}">
											<input type="text" name="dataname" class="form-control" id="inputgoalTitle"
												placeholder="이루고 싶은 목표를 입력하세요" value="${dataname}">
										</div>
									</div>
									
									<br>
									
									<div class="row">
										<label class="col-sm-2 control-label goal-check-create"><i class="fa fa-plus-circle" aria-hidden="true"></i>목표 추가</label>
										
										<div class="col-sm-10  goal-Check-List-Box">
										<c:forEach items="${gdata}" var="goal">
											<div class="goal-check-input-box">
												<input type="text" name="detailnames" class="form-control goalCheckList margin-bottom-10"
													placeholder="세부 목표를 입력하세요" value="${goal.goalname}">
												<button type="button" class="close goal-check-input-box-close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
											</div>
											</c:forEach>
										</div>
										
									</div>
									
									<br>
									
									<div class="row">
										<label for="inputgoalTitle" class="col-sm-2 control-label">목표 날짜</label>
										<div class="col-sm-10">
											<label class="col-sm-2 control-label">시작일</label>
											<div class='col-sm-10 input-group date' id='datetimepicker1'>
								                <input type='text' name="startdate" class="form-control" placeholder="${startdate}">
								                <span class="input-group-addon">
								                    <span class="glyphicon glyphicon-calendar"></span>
								                </span>
								            </div>
								            
								            <br>
								            
								            <label class="col-sm-2 control-label">종료일</label>
								            <div class='col-sm-10 input-group date' id='datetimepicker2'>
								                <input type='text' name="finaldate" class="form-control" placeholder="${finaldate}">
								                <span class="input-group-addon">
								                    <span class="glyphicon glyphicon-calendar"></span>
								                </span>
								            </div>
										</div>
									</div>
									
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
									<button type="button" id="sendgoaldata" class="btn btn-primary goal-save">저장</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</form>
				
				<hr>
				<div id="wholehtml">
				<div class="col-sm-8 col-sm-offset-2">
					<h2 class="text-center goal-detail-title">${dataname}</h2>
					<br>
				</div>
				
				
				<div class="col-sm-8 col-sm-offset-2">
					<div id="CountDownTimer" data-timer="${goaldate}"></div>
					<br>
				</div>
				
				
				<div class="col-sm-8 col-sm-offset-2">
				
					<div class="col-sm-3 goal-pie">
						<div class="pieProgress" role="progressbar" data-goal="27" aria-valuemin="0" data-step="1" aria-valuemax="100">
					        <div class="progress__meter"><span class="pie_progress__number"></span></div>
					    </div>
					    <h3 class="text-center">목표 달성률</h3>
					</div>
					
					<div class="col-sm-8 col-sm-offset-1">
					
						<!-- foreach item -->
						<c:forEach items="${gdata}" var="goal">
						<div class="goal-checklist-box">
							<div class="input-group">
								<span class="input-group-addon">
									<c:choose>
										<c:when test="${goal.state==0}">
										<input type="checkbox" class="goal-detail-checkbox" value="${goal.detailgoalseq}">
										</c:when>
										<c:otherwise>
										<input type="checkbox" class="goal-detail-checkbox" value="${goal.detailgoalseq}" checked="checked">
										</c:otherwise>
									</c:choose>
									
								</span>
								<input type="text" name="goal-detail-checklist" class="form-control goal-detail-checklist" value="${goal.goalname}" readonly>
							</div>
							
							<div id="goal-check-success" class="col-sm-12 height-30 margin-bottom-10 display-none">
								<span class="col-sm-10 no-padding goal-success-message"> 
	         						${goal.goalname}목표를 달성하였습니다.
	         					</span>
	         					<span class="col-sm-2 no-padding">
	         						<span class="glyphicon glyphicon-pencil goal-success-message-modi"
										data-toggle="tooltip" title="내용 수정하기" aria-hidden="true"></span>
								</span>
							</div>
							
							<div id="goal-check-success-mody-box" class="col-sm-12 no-padding margin-vertical display-none">
								<textarea class="goal-success-message-modi-area" name="" rows="2" placeholder="${goal.goalname}"></textarea>
								<button type="button" class="btn btn-primary goal-success-message-modi-save">저장</button>
								<input type="hidden" value="${goal.detailgoalseq}">
							</div>
						</div>
						
						<br>
						</c:forEach>
					
						
					</div>
					
				</div>
				</div>		
			</div>
			
		</div>
		
		<div id="push"></div>
		<div id="push"></div>
		
	</div>
	
</div>

<script src="${pageContext.request.contextPath}/resources/lib/goal/progress.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/TimeCircles/inc/TimeCircles.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-goal.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/manage-file.js"></script>
<script type="text/javascript">


	$(function() {
		// goal-countdown
		$("#CountDownTimer").TimeCircles();
		
		   $(".goal-detail-checkbox").each(function(index,element){
				
			   if($(element).is(":checked")){

		            $(element).parent().css('background','#9cff80');
		            $(element).parent().css('border','1px solid #2dbe60');
		            $(element).parent().siblings().css('border','1px solid #2dbe60');
		            
		         	$(element).attr('disabled','disabled');
		            
		         	$(element).parent().parent().siblings('#goal-check-success').show();
		         	
		            goalChecking();
		            
		            $(".goal-detail-modi-btn").fadeOut();
		        
		        } else {
		        	$(element).parent().css('background','#eee');
		        	$(element).parent().css('border','1px solid #ccc');
		        	$(element).parent().siblings().css('border','1px solid #ccc');
		        	goalChecking();
		        }
			   
			});
		
		
		// goal-detail-checklist
		$(".goal-detail-checkbox").change(function(){
		
			var contextPath='${pageContext.request.contextPath}'
			$.ajax({
		        url : contextPath+"/goal/updateDetailState.dvn",
		        type: "get",
		        data : { "detailgoalseq" : $(this).val() },
		        success : function(responseData){
		        	
		        	
		        }
		   });
			
			
			//체크 리스트 클릭 시 달성 퍼센트 비동기로 update
			
			$.ajax({
		        url : contextPath+"/goal/updateGoalpercent.dvn",
		        type: "get",
		        data : { "dataseq" : $('#dataseq').val()},
		        success : function(responseData){
		        
		        },
		        error :function(data){
		        	
		        }
		    });
			
	        if($(this).is(":checked")){

	            $(this).parent().css('background','#9cff80');
	            $(this).parent().css('border','1px solid #2dbe60');
	            $(this).parent().siblings().css('border','1px solid #2dbe60');
	            
	         	$(this).attr('disabled','disabled');
	            
	         	$(this).parent().parent().siblings('#goal-check-success').show();
	         	
	            goalChecking();
	            
	            $(".goal-detail-modi-btn").fadeOut();
	        
	        } else {
	        	$(this).parent().css('background','#eee');
	        	$(this).parent().css('border','1px solid #ccc');
	        	$(this).parent().siblings().css('border','1px solid #ccc');
	        	goalChecking();
	        }
		});
		
	
		
		$(".goal-success-message-modi").click(function() {
			$(this).parent().parent().siblings('#goal-check-success-mody-box').show();
			$(this).parent().parent().hide();
		});
		
		 // 체크리스트 완료 시, 내용 수정 코드
		$(".goal-success-message-modi-save").click(function() {
			//ajax 함수 호출
			var contextPath='${pageContext.request.contextPath}'
			
			$.ajax({
		        url : contextPath+"/goal/updateDetailComment.dvn",
		        type: "get",
		        data : { "detailgoalseq" : $(this).next().val(),
		        		 "commentmsg" : $(this).prev().val() },
		        success : function(responseData){
		        
		        },
		        error :function(data){
		        	
		        }
		    });
			
			
			// ajax 성공 시, (success)
			$(this).parent().siblings('#goal-check-success').show();
			$(this).parent().hide();
			
			var goalSuccessModyContent = $(this).siblings(".goal-success-message-modi-area").val();
			$(this).parent().siblings('#goal-check-success').children('.goal-success-message').text(goalSuccessModyContent);
		}); 
		
		 
	});
	
	function goalChecking() {
		var checklist = $("input[type=checkbox]").length;
		var checked = $("input:checked").length;
		var goalPercent = Math.round(eval((checked / checklist) * 100));
		
		$(".pieProgress").asPieProgress('go',goalPercent);
	}
</script>

