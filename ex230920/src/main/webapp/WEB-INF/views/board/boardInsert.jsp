<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form action="boardInsert" name="insertForm" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name=""></td>
			</tr>
		</table>
		<button type="button" onclick="location.href='boardList'">목록</button>
		<button type="submit">등록</button>
	</form>
	<script type="text/javascript">
        $('[name="insertForm"]').on('submit',function(e){
            e.preventDefault();

            let title = $('[name="title"]');
            let writer = $('[name="writer"]');

            if(title.val()==''){
                alert('제목이 입력되지 않았습니다.');
                title.focus();
                return;
            }

            if(writer.val()==''){
                alert('작성자가 입력되지 않았습니다.');
                writer.focus();
                return;
            }

            alert('게시글이 등록되었습니다.')
            insertForm.submit();
            // form 태크에서만 name을 변수처럼 사용가능
        })
	</script>
</body>
</html>