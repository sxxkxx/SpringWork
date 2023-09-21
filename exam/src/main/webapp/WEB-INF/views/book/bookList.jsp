<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList }" var="book">
				<tr>
					<td>${book.bookNo}</td>
					<td>${book.bookName}</td>
					<td>${book.bookCoverimg}</td>
					<td><fmt:formatDate value="${book.bookDate}"
							pattern="yyyy/MM/dd" /></td>
					<td><fmt:formatNumber value="${book.bookPrice }" pattern="#,###" /></td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>