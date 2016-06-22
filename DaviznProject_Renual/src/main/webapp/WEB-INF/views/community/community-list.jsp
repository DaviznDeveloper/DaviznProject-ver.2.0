<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<!-- content -->
				<div class="container">
					<div class="col-md-12 content-container">
	
						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
							<li class="active">커뮤니티</li>
						</ol>
						
						<div class="col-md-12 no-padding margin-bottom-10">
							
							<!-- 게시글 조회 -->
							<form action=<c:url value="/community/search.dvn"/>>
	
								<div class="col-md-2 col-xs-2 no-padding margin-right-10">
									<select id="searchValue" name="keyfield" class="form-control">
										<option value="userid" selected="selected" >작성자</option>
										<option value="boardsubject">글제목</option>
										<option value="boardseq">글번호</option>
									</select>
								</div>
								
								<script type="text/javascript">
								$(function(){
										$("#searchValue").change(function(){
											console.log($(this).val());
										});
									});
								</script> 
								
								
								<div class="col-md-3 col-xs-2 no-padding">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-info" type="submit">
												<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
											</button>
										</span>
										<input type="text" name="keyword" class="form-control" placeholder="Search for..." required="required">
									</div>
									<!-- /input-group -->
								</div>
					
							</form>
							<!-- 게시글 조회  끝 -->
								
							<!-- 게시글 개수 조절 -->
							<form action=<c:url value="communityList.dvn"/> name="sizeForm" method="post">
							
								<div class="col-md-2 col-xs-2 no-padding pull-right">
									<select class="form-control search-select" name="rowSize" onchange="sizeForm.submit()" >
										<option value="5" <c:if test="${rSize == 5 }">selected="selected"</c:if>>5개씩 보기</option>
										<option value="10" <c:if test="${rSize == 10 }">selected="selected"</c:if>>10개씩 보기</option>
										<option value="15" <c:if test="${rSize == 15}">selected="selected"</c:if>>15개씩 보기</option>
										<option value="20" <c:if test="${rSize == 20 }">selected="selected"</c:if>>20개씩 보기</option>
									</select>
								</div>
							</form>
							<!-- 게시글 개수 조절 끝 -->
							
						
							<script type="text/javascript">
								$(function(){
										$(".search-select").on("change", function(){
											console.log($(this).val());
										});
								});
							</script> 
							
							
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
									
										<!-- 글 번호 -->
										<td scope="col" class="ellipsis board-l-no boardseq">${n.boardseq}</td>
										<td scope="col" id="board-title" name="auth" class="ellipsis board-l-title boardsubject">
											<a href="${pageContext.request.contextPath}/community/communitydetail.dvn?boardseq=${n.boardseq}">
											<%-- <c:if test="${n.boardlev eq '1'}">
											
											</c:if>  --%>
											<c:forEach begin="0" end="${n.boardlev}" step="1">
												&nbsp;&nbsp;&nbsp;
											</c:forEach>
											<c:if test="${n.boardlev ne 0}">
												<img src="${pageContext.request.contextPath}/resources/img/board-re.gif" />
											</c:if> 
											${n.boardsubject}</a>
										</td>
							
										<td scope="col" class="ellipsis board-l-writer userid">${n.userid}</td>
										<td scope="col" class="ellipsis board-l-date boarddate">${n.boarddate}</td>
										<td scope="col" class="ellipsis board-l-lookup boardreadcount">${n.boardreadcount}</td>
										
									</tr>
									</c:forEach>
																	
								</tbody>
							
							</table>
						
						</div>
						
						<div class="col-md-12">
							<a href="${pageContext.request.contextPath}/community/communitywrite.dvn" class="btn btn-success pull-right">글쓰기</a>
						</div>

						<div class="text-center">
							<ul class="pagination">
                        <c:if test="${pg gt 5}">
                           <li>
                              <a href="${pageContext.request.contextPath}/communityList.dvn?pg=${fromPage-1}&rowSize=${rSize}" aria-label="Previous">
                                 <span aria-hidden="true">&laquo;</span>
                              </a>
                           </li>
                        </c:if>
                        <c:forEach begin="${fromPage}" end="${toPage}" var="i">
                           <c:choose>
                              <c:when test="${i==pg}">
                                 <li class="active"><a class="board-pager">${i}</a></li>
                              </c:when>
                              <c:when test="${i!=pg}">
                                 <li><a class="board-pager" href="${pageContext.request.contextPath}/communityList.dvn?pg=${i}&rowSize=${rSize}">${i}</a></li>
                              </c:when>
                           </c:choose>
                        </c:forEach>
                        <c:if test="${toPage lt allPage}">         
                           <li>
                              <a href="${pageContext.request.contextPath}/communityList.dvn?pg=${toPage+1}&rowSize=${rSize}" aria-label="Next" >
                                 <span aria-hidden="true">&raquo;</span>
                              </a>
                           </li>
                        </c:if>
                     </ul>
						</div>
				
						
						<br>
					
						<div id="push"></div>
					
					</div>
					
				</div>
			
			</div>
			
		</div>
		
<script src="${pageContext.request.contextPath}/resources/js/community.js"></script>
