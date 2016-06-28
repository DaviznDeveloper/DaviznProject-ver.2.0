<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


				
				<!-- content -->
				<div class="container">
				
					<div class="col-md-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
               				<li><a href="${pageContext.request.contextPath}/groupNavi.dvn">내 그룹</a></li>
							<li class="active">그룹에 공유된 데이터 히스토리</li>
						</ol>
						
						<div class="col-sm-6 margin-bottom-10">
						
							<h4>
								<a href="" class="btn btn-info">이 데이터를 원본 데이터로 변경</a>
							</h4>
						
							<div id="group-data-detail-history-showbox">
								<!-- 해당 데이터의 상세 내용 -->
								<div class="panel panel-purple-l note-detail-content">
									<div class="panel-heading note-detail-title">
										<h3 class="panel-title">
											목표관리 정의서&nbsp;&nbsp;&nbsp;&nbsp;
											<small class="note-detail-date">2016.06.21 에 'seulki' 님이 최종 수정.</small>
										</h3>
									</div>
									<div class="panel-body">
										누구나 한번쯤은 자기만의 세계로<br>
										빠져들게 되는 순간이 있지이~이이<br>
										<br>
										그렇지만 나는 제자리로 오지 못했어<br>
										되돌아 나오는 길을 모르니~이이이<br>
										<br>
										너무 많은 생각과 너무 많은 걱정에<br>
										온통 내자신을 가둬 두었지~이이이<br>
										<br>
										이젠 이런 내 모습 무진장 불안해보여~어어어?<br>
										다시 시작할 줄 모오르니~이이<br>
										<br>
										이제~에엔 세사~항에 나가고 싶어<br>
										당당히 내 모습을 보여줘야~아 해~애에<br>
									</div>
								</div>
								<!-- 해당 데이터의 상세 내용 -->
							</div>
							
						</div>
						
						<div class="col-sm-6 margin-bottom-10">

							<h4>데이터 히스토리</h4>
							
							<!-- 한 묶음 (첫번째 리스트는 active-purple 클래스 추가해야 함) -->
							<c:forEach items="${versionlist}" var="versionlist" varStatus="status">
								<c:choose>

    								<c:when test="${status.index eq 0}">
        								<div class="list-group">
										<a href="#" class="list-group-item active-purple">
											<p class="list-group-item-text margin-bottom-10">${versionlist.modifytime}</p>
											<h4 class="list-group-item-heading">
												<span class="text-bold">${versionlist.userid}</span> 님이 
												<span class="text-bold">[${versionlist.dataname}]</span> 원본 데이터를 수정.
											</h4>
											<p class="list-group-item-text">
												${versionlist.comments}
											</p>
										
										</a>
										</div>
   									</c:when>
								    <c:otherwise>
								        <div class="list-group">
											<a href="#" class="list-group-item">
												<p class="list-group-item-text margin-bottom-10">2016.06.20. 17:42</p>
												<h4 class="list-group-item-heading">
													<span class="text-bold">${versionlist.userid}</span> 님이 
													<span class="text-bold">[${versionlist.dataname}]</span> 원본 데이터를 수정.
												</h4>
												<p class="list-group-item-text">
													${versionlist.comments}
												</p>
										
											</a>
										</div>
								    </c:otherwise>
								</c:choose>
							</c:forEach>
							
					</div>	
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/js/group-info.js"></script>
