<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>         
         
         <!-- content -->
         <div class="container margin-top-50">
         
            <div class="col-md-8 content-container">
   
               <div class="col-md-6 col-md-offset-3 center-block">
                  <a href="index.dvn">
                     <div class="center-block dvn-logo sign-in-logo-box"></div>
                  </a>
                  
                  <hr>
                  
                  <div class="sidebar-box">
   
                     <form action="${pageContext.request.contextPath}/login" id="" method="post">
                        <ul class="sidebar-nav">
                           <li>
                              <div class="form-group">
                                 <input type="text" name="username" class="form-control"
                                    placeholder="아이디를 입력하세요">
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
                           <li>
                              <span>
                                 <a href="${pageContext.request.contextPath}/signup.dvn" class="btn btn-success btn-block">
                                    	회원가입
                                 </a>
                              </span>
                           </li>
                           <!-- 소셜 로그인 -->
                           <!-- 
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
                            -->
   
                        </ul>
                     </form>
   
                  </div>
                  
               </div>
   
            </div>
            
         </div>
         