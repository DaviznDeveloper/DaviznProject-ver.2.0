$(function() {
var datahtml = $('#wholehtml').html();
	console.log(datahtml);
	$.ajax({
		
		type : "POST",
		url : getContextPath() + "/personalData/managefile.dvn",
		data : {
			datahtml : datahtml
		},
		dataType : "text",
		cache : false,
		success : function(data) {
			console.log(data)
			alert('저장 성공');
		},
		error : function(data) {
			alert('죄송합니다. 잠시 후 다시 시도해주세요.');
			return false;
		}
		
	});
});

function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}