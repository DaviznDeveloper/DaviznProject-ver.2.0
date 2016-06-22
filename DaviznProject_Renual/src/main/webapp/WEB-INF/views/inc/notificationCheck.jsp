<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 
	@filename : notificationCheck.jsp
	@Date : 
	@Author : 
	@Desc : 
  -->
<script type="text/javascript">

//root ContextPath
function getContextPath() {
   var hostIndex = location.href.indexOf( location.host ) + location.host.length;
   return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};

$(function() {

	setInterval(function() {
	console.log('${userid}');
    if('${userid}' != ''){//////////////
       // 쪽지기능 알림
       $.ajax({
            type : "post",
            url : getContextPath() + "/message/msgNotificationCheck.dvn",
            data: {"receiver" : '${userid}'},
            success : function(data) {
               if(data != ''){
                  for(var i=0; i<data.length; i++){
                	  console.log("aaaaaaaaaaaaaaaaaaaaa");
	        		console.log("ID : " + data[i].ID);
	        			
                     var options = {
                           body : data[i].sender + "님이 쪽지를 보냈습니다."
                     }
                    var notification = new Notification("제목", options);
                    $.ajax({
                        type : "post",
                        url : getContextPath() + "/message/changeMsgNotificationState.dvn",
                        data : {"receiver" : '${userid}', "message_num" : data[i].message_num},///////////////////
                        success : function() {
                           
                        }
                     });
                  }
               }
            }
 
         });
    }
 }, 5000);
});
	


</script>