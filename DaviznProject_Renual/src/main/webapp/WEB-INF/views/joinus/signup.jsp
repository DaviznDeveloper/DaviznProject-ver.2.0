<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				<!-- content -->
				<div class="col-md-10 content-container">
	
					<div class="col-md-6 col-md-offset-3 center-block">
						<div class="panel panel-default">
							<div class="col-md-12 margin-box">
								<h2>Davizn 회원가입</h2>
								<h4>Davizn에 가입하고 당신의 데이터를 관리하세요.</h4>
								
								<hr>
								
								<h4><b>개인 계정 만들기</b></h4>
			
								<br>
			
								<form action="member/joinMember.dvn" method="post">
									<div class="form-group">
										<label for="UserName">이름</label> 
										<input type="text" class="form-control" 
											id="nickname" name="nickname" placeholder="사용하실 이름을 입력하세요">
										<span id="checknickname" class="sign-up-input-info">이름은 닉네임과도 같습니다. 단, 사용자끼리 중복되는 이름은 허용하지 않습니다.</span>
									</div>
									<div class="form-group">
										<label for="UserEmail">이메일 주소</label>
										<input type="email" class="form-control" 
											id="userid" name="userid" placeholder="사용하실 이메일을 입력하세요">
										<span id="checkuserid" class="sign-up-input-info">이메일이 당신의 계정 아이디가 될 것입니다.</span>
									</div>
									<div class="form-group">
										<label for="UserPassword">비밀번호</label>
										<input type="password" class="form-control" 
											id="" name="password" placeholder="사용하실 비밀번호를 입력하세요">
										<span class="sign-up-input-info">비밀번호는 최소 7글자에서 최대 14글자까지 설정하실 수 있습니다.</span>
									</div>
									<div class="form-group">
										<label for="UserTel">연락처</label>
										<input type="tel" class="form-control" 
											id="" name="phone" placeholder="연락 가능한 연락처를 입력하세요">
										<span class="sign-up-input-info">연락처 입력은 필수는 아닙니다.</span>
									</div>
			
									<hr>
				
									<div class="checkbox">
										<label> <input type="checkbox" value="">
											Dvizn 서비스 약관 및 개인 정보 보호 정책에 동의합니다.
										</label>
									</div>
									
									<hr>
									
									<button type="submit" class="btn btn-success">계정 생성하기</button>
									
									<br>
									
								</form>
								
								<br>
								
							</div>
							
						</div>
					</div>

				</div>
				
				<div id="push"></div>
				
			</div>
			
		</div>

<script src="${pageContext.request.contextPath}/resources/js/signUp.js"></script>