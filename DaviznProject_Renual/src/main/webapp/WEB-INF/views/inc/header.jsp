<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>



<!-- Main_Top_Nav -->
<div class="navbar navbar-inverse navbar-fixed-top">
   <div class="container-fluid">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed"
            data-toggle="collapse" data-target="#navbar" aria-expanded="false"
            aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span> <span
               class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <a class="navbar-brand"
            href="${pageContext.request.contextPath}/index.dvn"> <img
            class="brand_img"
            src="${pageContext.request.contextPath}/resources/img/Davizn.png"
            height="40px">
         </a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav navbar-left header-menu">
            <li class="nav_menu">
               <a href="${pageContext.request.contextPath}/userStrg.dvn"> 
                  <i class="fa fa-database" aria-hidden="true"></i> 
                  &nbsp;내 데이터 관리
                  ${alram}
               </a>
            </li>
            <li class="nav_menu">
               <a href="${pageContext.request.contextPath}/groupNavi.dvn"> 
                  <i class="fa fa-users" aria-hidden="true"></i> 
                  &nbsp;내 그룹
               </a>
            </li>
            <!-- // 데이터 마켓 구현 시, 코드 추가 
                        <li class="nav_menu">
                           <a href="#">
                              <i class="fa fa-shopping-cart" aria-hidden="true"></i> &nbsp;데이터 마켓
                           </a>
                        </li>
                         -->
            <li class="nav_menu">
               <a href="${pageContext.request.contextPath}/communityNavigation.dvn">
                  <i class="fa fa-comments-o" aria-hidden="true"></i> 
                  &nbsp;커뮤니티
               </a>
            </li>
            <li class="nav_menu">
               <a href="${pageContext.request.contextPath}/QnANavigation.dvn">
                  <i class="fa fa-question-circle" aria-hidden="true"></i> 
                  &nbsp;1:1 문의&건의
               </a>
            </li>
            
            <se:authorize access="hasRole('ROLE_ADMIN')">
               <li class="nav_menu">
                  <a href="${pageContext.request.contextPath}/siteStatistics.dvn">
                     <i class="fa fa-eye" aria-hidden="true"></i>
                     &nbsp;사이트 통계
                  </a>
               </li>
            </se:authorize>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li>
               <se:authorize access="hasRole('ROLE_USER')">
                  <a class="btn dropdown-toggle h-menu-transition" data-toggle="dropdown" href="#"> 
                     <span class="glyphicon glyphicon-envelope h-menu-tran-icon" aria-hidden="true"></span> 
                     <span class="badge h-menu-tran-badge-mail">${msgCount}</span>
                  </a>
                  <ul class="dropdown-menu">
                     <c:set var="message" value="${messagList}" />
                     <c:choose>
                        <c:when test="${message eq null}">
                           <li><a href="#"> 새로운 메세지가 없습니다. </a></li>
                        </c:when>

                        <c:otherwise>
                           <c:forEach items="${alarmList}" var="al">
                              <li><a href="${pageContext.request.contextPath}/main-profile.navigation">
                                    id : 제목제목?? </a></li>
                           </c:forEach>
                        </c:otherwise>
                     </c:choose>
                     <li class="vertical-middle padding-vertical text-center">
                        <a href="${pageContext.request.contextPath}/messageNavigation.dvn">
                           <span class="notice-header-span notice-header-all">전체 쪽지 보기</span>
                        </a>
                     </li>
                     <c:if test="${alarmList}==null">
                        <c:forEach items="${alarmList}" var="al">
                           <li>
                              <a href="${pageContext.request.contextPath}/main-profile.navigation">
                                 id : 제목제목?? </a></li>
                        </c:forEach>
                     </c:if>
                  </ul>
               </se:authorize>
            </li>
            <li>
            <se:authorize access="hasRole('ROLE_USER')">
               <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                  <span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
                  <span class="badge h-menu-tran-badge-notice">${notice}</span>
               </a>
               <ul class="dropdown-menu">
                  <c:set var="notice" value="${alarmList}" />
                  <c:choose>
                     <c:when test="${notice eq null}">
                        <li><a href="#"> 새로운 알림이 없습니다. </a></li>
                     </c:when>

                     <c:otherwise>
                        <c:forEach items="${alarmList}" var="al">
                           <li>
                              <a href="${pageContext.request.contextPath}/main-profile.navigation">
                                 ${al.datatype} ${al.dataname}일정이 종료되었습니다.
                              </a>
                           </li>
                        </c:forEach>
                     </c:otherwise>
                  </c:choose>
                  <li class="vertical-middle padding-vertical text-center">
                     <a href="${pageContext.request.contextPath}/main-profile.navigation">
                        <span class="notice-header-span notice-header-all">전체 알림 보기</span>
                     </a>
                  </li>
               </ul>
            </se:authorize>
         </li>
         <li>
            <se:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
               <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                  <se:authentication property="name" var="LoingUser" />
                     ${LoingUser}님 
                  </se:authorize> 
                  <span class="caret"></span> 
               </a>
               <ul class="dropdown-menu">
                  <li>
                     <a href="${pageContext.request.contextPath}/member/profile.dvn">
                        <i class="fa fa-user"></i>
                            &nbsp;내 프로필
                     </a>
                  </li>
                  <li>
                     <a href="${pageContext.request.contextPath}/logout">
                        <i class="fa fa-power-off"></i> 
                           &nbsp;Logout
                     </a>
                  </li>
               </ul>
            </li>
            <!-- login sidebar test -->
            <li>
               <se:authorize access="!hasRole('ROLE_USER')">
                  <button type="button" id="login-sidebar-btn" class="btn btn-info">로그인</button>
               </se:authorize>
            </li>
         </ul>
      </div>
   </div>
</div>
<!-- /Main_Top_Nav -->

<!-- Sidebar -->
<div id="sidebar-wrapper">
   <div class="sidebar-box">
      <!-- <div class="alert alert-danger alert-dismissible" role="alert">
         <button type="button" class="close" data-dismiss="alert"
            aria-label="Close">
            <span aria-hidden="true">&times;</span>
         </button>
         <strong id="login-fail">잘못된 아이디 또는 비밀번호 입니다.</strong>
      </div> -->

      <form action="${pageContext.request.contextPath}/login" id="loginForm"
         method="post">
         <ul class="sidebar-nav">
            <li>
               <div class="form-group">
                  <input type="text" name="username" class="form-control"
                     placeholder="아이디">
               </div>
            </li>
            <li>
               <div class="form-group">
                  <input type="password" name="password" class="form-control"
                     placeholder="비밀번호">
               </div>
            </li>
            <li>
               <div class="form-group">
                  <input type="submit" id="loginBtn" class="btn btn-info btn-block"
                     value="로그인">
               </div>
            </li>
            <li><a href="" class="get-id-pw">아이디 또는 비밀번호 찾기</a></li>
            <li><a href="${pageContext.request.contextPath}/signup.dvn">
                  <button type="button" class="btn btn-success btn-block">
                     회원가입</button>
            </a></li>
            <!-- 소셜 로그인 -->
            <!-- <li>
               <div class="login-border-bottom">
                  <div class="login-or-box">
                     <div class="login-or">또는</div>
                  </div>
               </div>
            </li>

            <li>
               <div class="form-group">
                  <button type="button" class="btn btn-block fb-login"></button>
               </div>
            </li>
            <li>
               <div class="form-group">
                  <button type="button" class="btn btn-block goo-login"></button>
               </div>
            </li> -->
         </ul>
      </form>
   </div>
</div>
<br>