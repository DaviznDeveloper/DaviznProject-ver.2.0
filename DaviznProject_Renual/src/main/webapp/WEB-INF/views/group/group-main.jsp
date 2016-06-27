<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
				
				<!-- content -->
				<div class="container">
				
					<div class="col-md-12 content-container">

						<ol class="breadcrumb">
							<li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
							<li><a href="${pageContext.request.contextPath}/renual/data-repo.jsp">내 그룹</a></li>
							<li class="active">그룹 메인</li>
						</ol>
						
						<div class="col-sm-4">
						
							<div class="col-sm-12 no-padding">
								<button type="button" class="btn btn-success" data-toggle="modal" data-target="#group-create">
									<i class="fa fa-plus" aria-hidden="true"></i>
									그룹 만들기
								</button>
								<br><br>
								
								<form action="${pageContext.request.contextPath}/group/addGroup.dvn" method="post" class="form-horizontal">
									<div id="group-create" class="modal fade">
										<div class="modal-dialog modal-lg">
											<div class="modal-content">
											
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title">그룹 만들기</h4>
												</div>
												
												<div class="modal-body">
												
													<h4 class="text-center">당신의 그룹을 만들어보세요.</h4>
													
													<br>
													
													<div class="row">
														<label for="inputgroupName" class="col-sm-2 control-label">그룹 이름</label>
														<div class="col-sm-10">
															<input type="text" name="groupname" class="form-control" id="inputgroupName"
																placeholder="그룹 이름을 입력하세요">
														</div>
													</div>
													
													<br>
													
													<div class="row">
														<label for="inputgroupIntroduce" class="col-sm-2 control-label">그룹 소개</label>
														<div class="col-sm-10">
															<textarea name="g_introduce" class="form-control textarea-size-fix" rows="3" id="inputgroupIntroduce"
																placeholder="그룹에 대해 간략하게 소개하세요"></textarea>
														</div>
													</div>
												</div>
												<div class="modal-footer">
													<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
													<button type="submit" class="btn btn-primary gorl-save">확인</button>
												</div>
												
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
									<!-- /.modal -->
								</form>
								
							</div>
							
							
						
							
							<div class="col-sm-12 no-padding">
								<c:forEach var="grouplist" items="${groupList}">
                 		 		<a href="${pageContext.request.contextPath}/group/goGroupInfo.dvn?groupseq=${grouplist.groupseq}">
									<div class="panel panel-primary">
										<div class="panel-body">
										
											<div class="group-main-groupbox-groupname">
												${grouplist.groupname}
											</div>
											
											<div>
												그룹장 : ${grouplist.groupmaster}
											</div>
											
											<br>
											
											<div class="col-xs-4 no-padding border-right">
												
												<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 멤버">
													<i class="fa fa-users vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
												</div>
												
												<div class="col-xs-12 center-block text-center">
													${grouplist.g_membercount}
												</div>
												
											</div>
											
											<div class="col-xs-4 no-padding border-right">
												
												<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 데이터">
													<i class="fa fa-files-o vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
												</div>
												
												<div class="col-xs-12 center-block text-center">
													${grouplist.g_datacount}
												</div>
												
											</div>
											
											<div class="col-xs-4 no-padding">
												
												<div class="col-xs-12 center-block text-center margin-bottom-10" data-toggle="tooltip" title="그룹 목표">
													<i class="fa fa-list-alt vertical-middle group-main-icon-fonts" aria-hidden="true"></i>
												</div>
												
												<div class="col-xs-12 center-block text-center">
													${grouplist.g_goalcount}
												</div>
												
											</div>
										
										</div>
									</div>
								</a>
                 				
                 		 		
								<br><br>
								</c:forEach>
							</div>
							
						</div>
						
						<div class="col-sm-8">
						
							<div class="col-sm-12 no-padding">
								<div class="input-group">
									<span class="input-group-btn">
										
										<button class="btn btn-warning" type="button" id="searchBtn">
											<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										</button>
									</span>
									<input type="text" class="form-control" name="keyword" id="keyword" placeholder="그룹명">
								</div>
								<br>
							</div>
							
							
						<div id="removeList">
							<c:forEach items="${rlist}" var="rgroup">
							<a href="${pageContext.request.contextPath}/group/goGroupInfo.dvn?groupseq=${rgroup.groupseq}">
								<div class="col-sm-12 no-padding">
									<div class="panel panel-warning">
											<div class="panel-body">
												<div class="group-main-groupbox-groupname">
												${rgroup.groupname}
												</div>
											
												<div>
												그룹장 : ${rgroup.groupmaster}
												</div>
											</div>
									</div>
								</div>
							</a>
						
							</c:forEach>
						</div>
						</div>
						
					</div>
				
				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/js/group-main.js"></script>
<script type="text/javascript">

	$(function(){
		$('#searchBtn').click(function(){
			
			var contextPath='${pageContext.request.contextPath}' 
			var searchList="";
			$.ajax({
		        url : contextPath+"/group/searchGroupList.dvn",
		        type: "get",
		        data : { "keyword" : $('#keyword').val() },
		        success : function(data){
		        	$('#removeList').empty();
		        	//동적으로 검색 리스트 만들기
		        	$(data).each(function(index,element){
		        	  
		        	    searchList +='<a href="">';
		        	    searchList +='<div class="col-sm-12 no-padding">';
		        	    searchList += '<div class="panel panel-warning">';
		        	    searchList += '<div class="panel-body">';
		        	    searchList += '<div class="group-main-groupbox-groupname">';
		        	    searchList += element.groupname+'</div><div>';
		        	    searchList += '그룹장 :'+element.groupmaster+'</div></div></div></div></a>';
		        	   
		        	   });
		        	
		        	$('#removeList').html(searchList);
		        	
		        },
		        error :function(data){
		        	alert('실패');
		        }
		    });
			
		});
	});

</script>

