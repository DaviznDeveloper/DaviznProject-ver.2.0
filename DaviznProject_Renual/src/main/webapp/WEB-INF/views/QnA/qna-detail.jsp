<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- content -->
<div class="container">
	<div class="col-md-12 content-container">

		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
			<li><a href="${pageContext.request.contextPath}/QnA.dvn">1:1
					문의&건의</a></li>
			<li class="active">글 상세보기</li>
		</ol>

		<div class="col-md-12 no-padding margin-bottom-10">

			<article id="board-content" class="board-content">

				<div class="table-responsive">
					<table class="table" style="TABLE-layout: fixed">

						<thead class="board-thead">

							<tr>

								<th scope="col" class="ellipsis board-d-title">${notice.boardsubject}</th>
								<th scope="col" class="board-d-date">${notice.boarddate}</th>

							</tr>

							<tr>

								<th scope="col" class="board-d-writer">${notice.nickname}</th>
								<th scope="col" class="board-d-lookup">${notice.boardreadcount}</th>

							</tr>

						</thead>

						<tbody>

							<tr>

								<td colspan="2" scope="col" class="">

									<div class="col-xs-12 col-md-12 board-d-content-box">

										<p class="board-d-content">${notice.boardcontent}</p>

									</div>

								</td>

							</tr>

							<tr>

								<td colspan="2" scope="col" class="">
									<div class="">
										<a class="btn btn-default"
											href="QnAEdit.dvn?boardseq=${notice.boardseq}" role="button">수정</a>
										  <!-- delete modal -->
                                          <button type="button" class="btn btn-default"
                                             data-toggle="modal" data-target=".bs-example-modal-sm">삭제</button>
                                             
										<div class="modal fade bs-example-modal-sm" tabindex="-1"
											role="dialog" aria-labelledby="mySmallModalLabel"
											aria-hidden="true" style="display: none;">
											<div class="modal-dialog modal-sm">
												<div class="modal-content">

													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">×</span>
														</button>
														<h4 class="modal-title" id="mySmallModalLabel">
															정말 삭제하시겠습니까?<a class="anchorjs-link"
																href="#mySmallModalLabel"><span
																class="anchorjs-icon"></span></a>
														</h4>
													</div>
													<div class="modal-body">
														<a class="btn btn-danger"
															href="QnaDel.dvn?boardseq=${notice.boardseq}"
															role="button">삭제</a>
														<button type="button" class="btn btn-default"
															data-dismiss="modal">취소</button>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
										<a class="btn btn-default" href="QnA.dvn" role="button">목록</a>
									</div>
								</td>

							</tr>

							<tr>

								<td scope="col" class="ellipsis">

									<div class="row">
										<span class="reply-writer">leafgreen</span> <span
											class="reply-date">2016.06.09</span> <input type="hidden"
											value="1">
									</div>

									<div class="row">
										<p class="ellipsis reply-content">
											<span></span>오오오오
										</p>
									</div>

								</td>

								<td scope="col" class="">

									<div class="navbar-header">
										<button type="button" class="navbar-toggle collapsed"
											data-toggle="collapse" data-target="#reply-navbar"
											aria-expanded="false" aria-controls="navbar">
											<span class="sr-only">Toggle navigation</span> <span
												class="glyphicon glyphicon-option-vertical"></span>
										</button>
									</div>

									<div id="reply-navbar" class="navbar-collapse collapse">
										<ul class="nav navbar-nav navbar-right">
											<!-- <li class="nav_menu"><a href="#" class="btn btn-default">댓글</a></li>
															<li class="nav_menu"><a href="#" class="btn btn-default">수정</a></li> -->
											<li class="nav_menu"><a href="" class="btn btn-default">삭제</a></li>
										</ul>
									</div>

								</td>
								<!-- 댓글 끝 -->
							</tr>

							<tr>

								<form action="" method="get">

									<td scope="col" class="">

										<div class="form-group">
											<input type="hidden" name="commentId" value=""> <input
												type="hidden" name="commentNo" value="">
											<textarea rows="" class="form-control"
												placeholder="댓글을 입력하세요." name="commentText"></textarea>

										</div>

									</td>

									<td scope="col" class="">

										<div id="reply-navbar" class="navbar-collapse collapse">
											<ul class="nav navbar-nav navbar-right">
												<li class="nav_menu"><a href="" class="btn btn-default">확인</a></li>
											</ul>
										</div>

									</td>

								</form>

							</tr>

						</tbody>

					</table>
			</article>

		</div>

		<br>

		<div id="push"></div>

	</div>

</div>

</div>

</div>

<script src="${pageContext.request.contextPath}/resources/js/qna.js"></script>
