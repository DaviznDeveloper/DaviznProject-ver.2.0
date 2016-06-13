<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<html lang="ko">

	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<meta name="description" content="">
		<meta name="author" content="Hwang.Young-sun">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon-152.png" sizes="152x152">
		
		<title>Davizn - 데이터 시각화 도구</title>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
		<!-- font-awesome -->
		<link href="${pageContext.request.contextPath}/resources/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sideBar.css">
		
		<!-- Custom Script -->
		<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/sideBar.js"></script>

	</head>
	
	<body>

		<div id="main">
		
			<!-- content -->
			<div class="col-md-10 content-container">

				<div class="col-md-6 col-md-offset-3 center-block">
					<div class="center-block dvn-logo sign-in-logo-box"></div>

					<hr>
					
					<div class="sidebar-box">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong id="login-fail">잘못된 아이디 또는 비밀번호 입니다.</strong>
						</div>

						<form action="${pageContext.request.contextPath}/login" id="" method="post">
							<ul class="sidebar-nav">
								<li>
									<div class="form-group">
										<input type="text" name="username" class="form-control"
											placeholder="이메일 계정을 입력하세요">
									</div>
								</li>
								<li>
									<div class="form-group">
										<input type="password" name="password" class="form-control"
											placeholder="비밀번호를 입력하세요">
									</div>
								</li>
								<li>
									<div class="form-group">
										<input type="submit" class="btn btn-info btn-block"
											value="로그인">
									</div>
								</li>
								<li><a href="#" class="get-id-pw">아이디 또는 비밀번호 찾기</a></li>
								<li><a href="${pageContext.request.contextPath}/signup.dvn">
										<button type="button" class="btn btn-success btn-block">
											회원가입</button>
								</a></li>
								<!-- 소셜 로그인 -->
								<li>
									<div class="login-border-bottom">
										<div class="sign-in-login-or-box">
											<div class="login-or">또는</div>
										</div>
									</div>
								</li>

								<li>
									<div class="form-group">
										<img src="./resources/img/facebook_login_btn2.png" class="sign-in-fb-login">
									</div>
								</li>
								<li>
									<div class="form-group">
										<img src="./resources/img/google_login_btn2.png" class="sign-in-goo-login">
									</div>
								</li>


							</ul>
						</form>

					</div>

				<!-- <form action="" method="post" class="form-horizontal">
						<div class="center-block dvn-logo sign-in-logo-box"></div>

						<hr>

						<div class="form-group">
							<label for="UserEmail">이메일 계정</label> 
							<input type="email" class="form-control" 
								id="" name="" placeholder="가입하신 이메일 계정을 입력하세요">
						</div>
						<div class="form-group">
							<label for="UserPassword">비밀번호</label>
							<input type="password" class="form-control"
								id="" name="" placeholder="가입하신 비밀번호를 입력하세요">
						</div>
						<br>
						<div class="form-group">
							<button type="submit" class="btn btn-info btn-block">로그인</button>
						</div>
					</form> -->
				</div>

			</div>
			
		</div>

</body>
	
</html>
			
