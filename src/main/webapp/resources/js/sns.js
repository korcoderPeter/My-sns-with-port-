function textEdit() {
	jsonArray = [];
	$('#summernote').summernote({
		height : 500, // 에디터 높이
		minHeight : null, // 최소 높이
		maxHeight : null, // 최대 높이
		focus : true, // 에디터 로딩후 포커스를 맞출지 여부

		callbacks : {
			onImageUpload : function(files, editor, welEditable) {

				// 파일 업로드(다중업로드를 위해 반복문 사용)
				for (var i = files.length - 1; i >= 0; i--) {
					uploadSummernoteImageFile(files[i], this);
				}
			}
		}
	});

	function uploadSummernoteImageFile(file, el) {
		var data = new FormData();
		data.append("file", file);
		$.ajax({
			url : '/myport/uploadSummbernote.com',
			type : "POST",
			enctype : 'multipart/form-data',
			data : data,
			// cache: false,
			contentType : false,
			processData : false,
			success : function(data) {
				alert(data.url)
				$(el).summernote('editor.insertImage', "zzz");
				
			},
			error : function(e) {
				alert(e);
			}
		});
	}

};
function jsonFn(jsonArray) {
	alert(jsonArray);
};

textEdit();
