<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
		<!-- content -->
		<div class="container">
			<div class="col-md-12 content-container">

				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
					<li><a href="${pageContext.request.contextPath}/community.dvn">커뮤니티</a></li>
					<li class="active">글 수정하기</li>
				</ol>
				
				<div class="table-responsive">
			
				<table class="table" style=TABLE-layout:fixed>
					
					<form action="" method="get" name="boardform" id="writeform" enctype="multipart/form-data">
				
						<thead class="board-thead">
						
							<tr>
							
									<!-- <th scope="col" class="ellipsis board-w-title">제목</th>
									<th colspan="2" scope="col" class="board-w-title-input">
										<input type="text" name = "BOARD_SUBJECT" id="board_subject" class="form-control">
									</th> -->
								<td colspan="3" class="ellipsis board-w-title">
									<div class="form-group">
										<label for="inputTitle" class="col-sm-1 control-label board-w-t">제목</label>
										<div class="col-sm-11">
											<input type="text" class="form-control" id="board-subject"
												placeholder="제목을 입력하세요." value="안뇽하세용~">
										</div>
									</div>
								</td>
								
							</tr>
							
							<tr>
							
								<div class="form-group">
									<th colspan="1" scope="col" class="">
										<input type="checkbox" id="notice_check" class="" name="notice_check">
										&nbsp;&nbsp;공지
									</th>
								</div>
								
							</tr>
						
						</thead>
						
						<tbody>
							
							<tr>
							
								<div class="form-group">
									
									<td colspan="3">
										<div id="summernote">안녕하세요~오늘 가입했습니다 반가워요~</div>
									</td>
								
								</div>
								
							</tr>
							
							<tr>
							
								<div class="form-group">
								
									<td colspan="3" scope="col" class="">
									
										<div class="text-center">
											<button type="button" class="btn btn-success" id = "write_submit">수정</button>
											<a class="btn btn-default" href="" role="button">취소</a>
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
<script src="${pageContext.request.contextPath}/resources/js/community.js"></script>
<script type="text/javascript">
	$('#summernote').summernote({
		height: 300
	});
</script>
