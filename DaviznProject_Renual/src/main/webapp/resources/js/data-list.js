
$(function() {
	$('#selectStrg').change(function(){
		var strgseq = $("select[name=selectStrg]").val();
		location.href=getContextPath()+"/personalData/showPersonalDataList.dvn?strgseq="+strgseq;
	});
	
});

function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}