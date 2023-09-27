<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Form</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div>
		<!-- <form action="" method="post" enctype="multipart/form-data">  -->
		<input type="file" name="uploadFile" multiple="multiple">
		<button class="uploadBtn">Submit</button>
		<!-- </form> -->
	</div>

	<script>
		$('.uploadBtn').click(function() {
			var formData = new FormData(); //FormData 객체 생성, FormData: Ajax기반으로 파일전송에 필요한 객체, FormData없을시 header에 dataType 입력해줘야함 
			var inputFile = $("input[type='file']");

			var files = inputFile[0].files;
			//files : 선택한 모든 파일을 나열하는 FileList 객체입니다.
			//multiple 특성을 지정하지 않닸다면 두 개 이상의 파일을 포함하지 않습니다.

			for (var i = 0; i < files.length; i++) {
				console.log(files[i]);
				formData.append("uploadFiles", files[i]);// Key and Value로 append 
			}
			
			// 실제 업로드 Ajax 사용
			
			// javascript의 fetch 사용
			/*
			fetch('uploadsAjax',{
				method : 'post',
				body : formData
			})
			.then(response => response.json())
			.then(data=> console.log(data))
			.catch(err => console.log(err));
			*/
			
			//jQuery.ajax
			
			$.ajax({
	               url: 'uploadsAjax',	
	               type: 'POST',
	               processData: false,	//기본값은 true, ajax 통신을 통해 데이터를 전송할 때, 기본적으로 key와 value값을 Query String으로 변환해서 보냅니다. 파일타입 자동변환 방지
	               contentType: false,	// multipart/form-data타입을 사용하기위해 false 로 지정합니다. ajax타입으로 자동변환 방지
	               data: formData,               
	               success: function(result){
	                   for(let image of result){
						   let path = '${pageContext.request.contextPath}/images/' + image;
						   let imgTag = $('<img/>').prop('src', path);
						   $('div').append(imgTag);
					   }
	               },
	               error: function(reject){	
	                   console.log(reject);
	               }
	         }); 
	           

		});
	</script>

</body>
</html>