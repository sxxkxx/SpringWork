<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<!-- bno -->
				<th>제목</th>
				<!-- title -->
				<th>작성자</th>
				<!-- writer -->
				<th>작성일</th>
				<!-- yyyy년MM월dd일 -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="info">
				<!--<tr onclick="location.href='boardInfo?bno='+${info.bno};"> -->
				<tr>
					<td>${info.bno}</td>
					<td>${info.title}</td>
					<td>${info.writer}</td>
					<td><fmt:formatDate value="${info.regdate}"
							pattern="yyyy년MM월dd일" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
	

		$('tbody > tr').each(function(idx, tag){
			tag.addEventListener('click', function(e) {
				let bno = e.currentTarget.firstElementChild.textContent;

			location.href = 'boardInfo?bno=' + bno;
			});
		})
	</script>
</body>
</html>