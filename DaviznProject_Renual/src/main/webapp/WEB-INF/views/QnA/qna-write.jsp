<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">1:1 문의&건의</a></li>
							<li class="active">글쓰기</li>
						</ol>
						
						<div class="table-responsive">
					
						<table class="table" style=TABLE-layout:fixed>
							
							<form action="qnaWrite.dvn" method="post" name="boardform" id="writeform">
						
								<thead class="board-thead">
								
									<tr>
									
											<!-- <th scope="col" class="ellipsis board-w-title">제목</th>
											<th colspan="2" scope="col" class="board-w-title-input">
												<input type="text" name = "BOARD_SUBJECT" id="board_subject" class="form-control">
											</th> -->
										<td colspan="3" class="ellipsis board-w-title">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-1 control-label board-w-t">제목</label>
												<div class="col-sm-11">
													<input type="text" class="form-control" id="board-subject" name="boardsubject" placeholder="제목을 입력하세요." required="required">																										
												</div>
												<input type="hidden" class="form-control" name="userid" value="${userid}" readonly="true">
											</div>
										</td>
										
									</tr>
									
									<tr>
									
										<td colspan="3" class="ellipsis board-w-title">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-1 control-label board-w-t">비밀번호</label>
												<div class="col-sm-11">
													<input type="password" class="form-control" id="board-subject" name="boardpwd" required="required"
														placeholder="이 글의 비밀번호을 설정하세요.">
												</div>
											</div>
										</td>
										
									</tr>
									
									<tr>
									
										<div class="form-group">
											<th colspan="1" scope="col" class="">
												<input type="checkbox" id="notice_check" class="" name="boardnotice">
												&nbsp;&nbsp;공지
											</th>
										</div>
										
									</tr>
								
								</thead>
								
								<tbody>
									
									<tr>
									
										<div class="form-group">
											
											<td colspan="3">
												 <textarea id="summernote" class="summernote" name="boardcontent" rows="20" required="required"></textarea>			        
											</td>
										
										</div>
										
									</tr>
									
									<tr>
									
										<div class="form-group">
										
											<td colspan="3" scope="col" class="">
											
												<div class="text-center">
													<button type="submit" class="btn btn-success" id = "write_submit">완료</button>
													<a class="btn btn-default" href="qna-list.jsp" role="button">취소</a>
												</div>
												
											</td>
											
										</div>
									
									</tr>
								
								</tbody>
							
							</form>
						
						</table>
						
						<br>
					
						<div id="push"></div>
					
					</div>
					
				</div>
			
			</div>
			
		</div>
		

<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/qna.js"></script>
<script type="text/javascript">
	$('#summernote').summernote({		
		height: 300		
	});

</script>
