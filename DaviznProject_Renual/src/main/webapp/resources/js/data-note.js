
$(function() {

	CKEDITOR.replace('ckeditor',{
		skin: 'moonocolor',
		enterMode: '2',
		shiftEnterMode: '3',
		height: '400px',
		inlinesave : {
				  postUrl: '/myurl',
				  postData: {test: true},
				  useJSON: false,

				  // Callbacks...
				  onSave: function(editor) { console.log('clicked save', editor); },                                   
				  onSuccess: function(editor, data) { console.log('save successful', editor, data); },                 
				  onFailure: function(editor, status, request) { console.log('save failed', editor, status, request); }
				},
		toolbar: 
			[['Print','-','Undo','Redo'],
			 ['Font'],
			 ['FontSize'],
			 ['TextColor','BGColor','-','Bold','Italic','Underline','Strike'],
			 ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','Outdent','Indent'],
			 ['Subscript','Superscript','RemoveFormat'],
			 ['NumberedList','BulletedList'],
			 ['Link','Image'],
			 ['Table','HorizontalRule']],
			 filebrowserImageUploadUrl: '${pageContext.request.contextPath}/personalData/imageUpload.dvn'
	});
	
	var sendNoteDataaa;
	
	$("#sendNoteData").click(function() {
        var sendNoteData = CKEDITOR.instances.ckeditor.getData();
        var noteText = $('#ckeditor').val(sendNoteData);
        $("#noteForm").submit();   
        
     });
	
	
	
	$("button[type='reset']").click(function() {
		CKEDITOR.instances.ckeditor.setData(sendNoteData);

		console.log("데이터" + " : " + sendNoteData);
		
	});

	var editorbox = $("form").find("");
	
	$("body").on("keydown click", function() {
		setTimeout("noteAjax()", 3000);
	});

	setInterval("noteAjax()", 60000);

});

function noteAjax() {
	var sendNoteTitle = $(".note-title").val();
	var sendNoteData = CKEDITOR.instances.ckeditor.getData();
	
	/* 
	$.ajax({

		type : "POST",
		url : "test.do",
		async : false,
		data : {
			note_title : sendNoteTitle,
			note_content : sendNoteData
		},
		dataType : "text",
		cache : false,
		success : function(data) {
			alert("저장되었습니다.");
		},
		error : function(data) {
			alert('죄송합니다. 잠시 후 다시 시도해주세요.');
			return false;
		}
		
	});
	*/
	
	console.log(sendNoteTitle + " : " + sendNoteData);
	
}