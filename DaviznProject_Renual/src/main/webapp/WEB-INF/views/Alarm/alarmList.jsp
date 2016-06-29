[notice-list.jsp]
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

            
            <!-- content -->
            <div class="container">
            
               <div class="col-sm-12 content-container">

                  <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}/renual/index.jsp">홈</a></li>
                     <li class="active">전체 알림 메세지 목록 보기</li>
                  </ol>
                     
                     <span class="glyphicon glyphicon-refresh notice-detail-icon" 
                        data-toggle="tooltip" title="새로 고침" aria-hidden="true"></span>
              <a href="${pageContext.request.contextPath}/alarm/readDelete.dvn">
                     <span class="glyphicon glyphicon-eye-close notice-detail-icon" 
                        data-toggle="tooltip" title="읽은 알림 삭제" aria-hidden="true"></span>
                 </a>
                 <a href="${pageContext.request.contextPath}/alarm/allDelete.dvn">      
                     <span class="glyphicon glyphicon-trash notice-detail-icon" 
                        data-toggle="tooltip" title="전체 삭제" aria-hidden="true"></span>
                    </a>
                  <hr>

                  <div class="col-sm-8 col-sm-offset-2 table-responsive">
                     
                     <table class="table table-bordered">
                        
                        <thead>
                        
                           <tr>
                              <th class="text-center">구분</th>
                              <th class="text-center">내용</th>
                              <th class="text-center">날짜</th>
                              <th class="text-center">삭제</th>
                           </tr>
                        
                        </thead>
                        
                        <tbody>
                           <c:forEach items="${list}" var="n">
                                 <tr class="font-bold">
                                 <td class="text-center">${n.datatype}</td>
                                 
                                 <c:choose>
                                    <c:when test="${n.datatype=='3'}">
                                       <td><a href="${pageContext.request.contextPath}/personalData/detailPersonalData2.dvn?datatype=${n.datatype}&strgseq=${n.strgseq}&dataseq=${n.dataseq}&alarmseq=${n.alarmseq}" class="notice-list-title">${n.dataname} 목표가 종료되었습니다.
                                       </a>
                                 </td>
                                    </c:when>
                                    <c:otherwise>
                                       <td><a href="detailpersonalData2.dvn?datatype=${n.datatype}?strgseq=${n.strgseq}?dataseq=${n.dataseq}&alarmseq=${n.alarmseq}" class="notice-list-title">${n.dataname} 목표가 종료되었습니다.
                                     </a>
                                    </c:otherwise>
                                 </c:choose> 
                                 
                             <%--     <td><a href="detailpersonalData.dvn?datatype=${n.datatype}?strgseq=${n.strgseq}?dataseq=${n.dataseq}" class="notice-list-title">${n.dataname} 목표가 종료되었습니다.
                                    <input type="hidden" name="datatype" value="${n.datatype}">
                                    <input type="hidden" name="strgseq" value="${n.strgseq}">
                                    <input type="hidden" name="dataseq" value="${n.dataseq}"></a>
                                 </td> --%>
                                 <td class="text-center">${n.finaldate}</td>
                                 <td class="text-center">
                                    <a href="${pageContext.request.contextPath}/alarm/selectOne.dvn?alarmseq=${n.alarmseq}">
                                       <input type="hidden" name="alarmseq" value="${n.alarmseq}">
                                       <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    </a>
                                 </td>
                              </tr>
                           </c:forEach>
                           
                        </tbody>
                        
                     </table>
                     
                  </div>
                  
                  <br>
            
               </div>
            
            </div>
            
            <div id="push"></div>
            
         </div>
         
      </div>

<script src="${pageContext.request.contextPath}/resources/lib/gorl/progress.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data-gorl.js"></script>
