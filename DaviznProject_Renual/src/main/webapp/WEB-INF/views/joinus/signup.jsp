<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

            <!-- content -->
            <div class="col-md-10 content-container">
   
               <div class="col-md-6 col-md-offset-3 center-block">
                  <div class="panel panel-default">
                     <div class="col-md-12 margin-box">
                        <a href="index.dvn">
                           <div class="center-block dvn-logo sign-in-logo-box"></div>
                        </a>
                        
                        <hr>
                        
                        <h4 class="text-center"><b>Davizn에 가입하고 당신의 데이터를 관리하세요.</b></h4>
         
                        <br>
         
                        <form action="${pageContext.request.contextPath}/join/joinMember.dvn" method="post">
                           <div class="form-group">
                              <label for="UserName">아이디</label> 
                              <input type="text" class="form-control" id="userid" name="userid" placeholder="사용하실 아이디를 입력하세요" required>
                              <span id="checkuserid" class="sign-up-input-info">영문 + 숫자 조합으로 최소 6글자에서 최대 12글자까지 설정하세요.</span>
                           </div>
                           <div class="form-group">
                              <label for="UserEmail">이메일 주소</label>
                              <input type="email" class="form-control" id="account" name="account" placeholder="사용하실 이메일을 입력하세요" required>

                              <span id="checkaccount" class="sign-up-input-info">사용중인 이메일을 입력하세요.</span>
                           </div>
                           <div class="form-group">
                              <label for="UserPassword">비밀번호</label>
                              <input type="password" class="form-control" id="password" name="password" placeholder="사용하실 비밀번호를 입력하세요" required>
                              <span id="checkpwd" class="sign-up-input-info">영문 + 숫자 조합으로 최소 7글자에서 최대 14글자까지 설정하세요.</span>
                           </div>
                           <div class="form-group">
                              <label for="UserTel">연락처</label>
                              <input type="tel" class="form-control" id="phone" name="phone" placeholder="연락 가능한 연락처를 입력하세요" required>
                              <span id="checkphone" class="sign-up-input-info">연락 가능한 연락처를 입력하세요.</span>
                           </div>
         
                           <hr>
            
                           <div class="checkbox">
                              <label>
                              <input type="checkbox" value="" required>
                                 Davizn 서비스 약관 및 개인 정보 보호 정책에 동의합니다.
                              </label>
                           </div>
                           
                           <hr>
                           
                           <button type="submit" class="btn btn-success center-block">계정 생성하기</button>
                           
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