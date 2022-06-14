<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 섬머노트 시작 -->
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote();
	});
</script>
<!-- 섬머노트 끝 -->

</head>
<body>
	<form action="/myport/snsWrite">
		<input type="hidden" name="token" value="${token }"> <br> Title: <input
			name="title"> <br><br> Content:
		<textarea id="summernote" name="content">
			
		</textarea>




		<button>글작성</button>
	</form>
<!-- my javascript -->
<script type="text/javascript" src="resources/js/sns.js"></script>

</body>
</html>