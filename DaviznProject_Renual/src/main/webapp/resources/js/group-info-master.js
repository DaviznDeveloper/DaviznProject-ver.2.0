$(function() {
	
	var checkQuantity = $("input[name=userid]:checked").length;
	
	$(".group-info-member-selected").text(checkQuantity);
	
	//최상단 체크박스 클릭
    $("#checkall").click(function(){
        //클릭되었으면
        if($("#checkall").prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $(".blankCheckbox").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $(".blankCheckbox").prop("checked",false);
        }
        
        // 갯수처리
        checkQuantity = $(".blankCheckbox:checked").length;
        
        $(".group-info-member-selected").text(checkQuantity);
        
    });
    
    $(".blankCheckbox").click(function() {
        // 갯수처리
        checkQuantity = $(".blankCheckbox:checked").length;
        
        $(".group-info-member-selected").text(checkQuantity);
    });
	
	
});