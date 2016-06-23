    $(function() {
             setInterval(function() {
                  if($('#sender').val() != ''){//////////////
                     // 쪽지기능 알림
                     $.ajax({
                          type : "post",
                          url : "msgNotificationCheck.dvn",
                          data: {"receiver" : $('#sender').val()},
                          success : function(data) {
                             if(data != ''){
                            	 alert('쪽지 체크');
                            	 console.log(data);
                                for(var i=0; i<data.length; i++){
                                  
                                   var options = {
                                         body : data[i].sender + "님이 쪽지를 보냈습니다."
                                   }
                                  var notification = new Notification("제목", options);
                                  $.ajax({
                                      type : "post",
                                      url : "changeMsgNotificationState.dvn",
                                      data : {"receiver" : $('#sender').val(), "message_num" : data[i].message_num},///////////////////
                                      success : function() {
                                         
                                      }
                                   });
                                }
                             }
                          }
               
                       });
                  }
               }, 5000); 


            $('#receiver').keyup(function() {
               $.ajax({
                      type : "post",
                      url : "getMemberList.dvn",
                      data : {"userid": $('#receiver').val()},// 이건 파라미터...
                      success : function(data) {
                        var printdata = "";

                        $('#div_view').empty();
                        
                        
                        $.each(data, function(index, item) {
                           printdata += "<li id='list" + index + "'>" + item.userid + "</li>";
                         });
                        
                        if($('#receiver').val() ==""){
                           $('#div_view').empty();
                        }
                        else{
                           $('#div_view').append("<ul>" + printdata + "</ul>");
                        }
                            
                        
                        $.each(data, function(index, item) {
                           $('#list' + index).click(function() {
                              $('#receiver').val($('#list' + index).text());
                              $('#div_view').empty();
                              
                           });
                           
                           $('#receiver').focusout(function() {
                              //$('#div_view').empty();
                              
                              
                           });
                        });
                      }
                   });
               
            });
            
            
            $('.nav-tabs>li>a').on('click',function(){
                  index = $(this).parent().index() + 1;
                  $('.nav-tabs>li').removeClass('active')
                  $('.tab-pane').hide();
                  $('.t'+ index).fadeIn();
                  $(this).parent('li').addClass('active');
            });
         });