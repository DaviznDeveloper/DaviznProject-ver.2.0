$(function() {
	
	$('#applygroup').click(function(){
		var userid = $('#userid').val();
		var groupseq = $('#groupseq').val();
		console.log(userid+groupseq);
		$.ajax({
			type : "POST",
			url : getContextPath()+"/group/applyGroup.dvn",
			data : {
				"groupseq" : groupseq
			},
			success : function(data) {
				alert(data);
			},
			error : function(){
				alert("Check Error");
			}
		});
		
	});
	

});

function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}