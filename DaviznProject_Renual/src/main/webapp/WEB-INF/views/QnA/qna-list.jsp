<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/ui/index.jsp">홈</a></li>
							<li class="active">1:1 문의&건의</li>
						</ol>
						
						<div class="col-md-12 no-padding margin-bottom-10">
						
							<form action="" method="post">
	
								<div class="col-md-2 col-xs-2 no-padding margin-right-10">
									<select class="form-control">
										<option>작성자</option>
										<option>글제목</option>
										<option>글번호</option>
									</select>
								</div>
	
								<div class="col-md-3 col-xs-2 no-padding">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-info" type="button">
												<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
											</button>
										</span>
										<input type="text" class="form-control" placeholder="Search for...">
									</div>
									<!-- /input-group -->
								</div>
					
							</form>
								
							<div class="col-md-2 col-xs-2 no-padding pull-right">
								<select class="form-control">
									<option>5개씩 보기</option>
									<option>10개씩 보기</option>
									<option>15개씩 보기</option>
									<option>20개씩 보기</option>
								</select>
							</div>
							
						</div>
						
						<div class="col-md-12 table-responsive no-padding">
					
							<table class="table" style=TABLE-layout:fixed>
							
								<thead class="board-thead">
								
									<tr>
									
										<th scope="col" class="board-l-no">번호</th>
										<th scope="col" class="board-l-title">제목</th>
										<th scope="col" class="board-l-writer">작성자</th>
										<th scope="col" class="board-l-date">작성일</th>
										<th scope="col" class="board-l-lookup">조회</th>
										
									</tr>
								
								</thead>
								
								<tbody>
									
									<c:forEach items="${list}" var="n">
										<tr>
											<td class="boardseq">${n.boardseq}</td>								
											<td class="boardsubject"><a href="${pageContext.request.contextPath}/QnA/Qnadetail.dvn?boardseq=${n.boardseq}">${n.boardsubject}</a></td>
											<td class="nickname">${n.nickname}</td>
											<td class="boarddate">${n.boarddate}</td>
											<td class="boardreadcount">${n.boardreadcount}</td>
										</tr>
									</c:forEach>
								
								</tbody>
							
							</table>
						
						</div>
						
						<div class="col-md-12">
							<a href="${pageContext.request.contextPath}/QnA/qnaWrite.dvn" class="btn btn-success pull-right">글쓰기</a>
						</div>

						<div class="text-center">
							<ul class="pagination">
								<li>
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<c:forEach begin="${fromPage}" end="${toPage}" var="i">
										<c:if test="${i==pg}"><li>${i}</li></c:if>
										<c:if test="${i!=pg}">
											<li><a  class="board-pager" href="${pageContext.request.contextPath}/QnA.dvn?pg=${i}">${i}</a></li>
										</c:if>
								</c:forEach>			
								<li>
									<a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</div>
						
						<br>
					
						<div id="push"></div>
					
					</div>
					
				</div>
			
			</div>
			
		</div>
		
<script src="${pageContext.request.contextPath}/resources/js/community.js"></script>
