<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:csrfMetaTags />
<!-- header에 matatag 삽입 , Ajax사용 -->
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	<sec:authorize access="isAuthenticated()">
		<form action="logout" method="post">
			<sec:csrfInput />
			<button>로그아웃</button>
		</form>
	</sec:authorize>
	<script type="text/javascript">
		$.ajax('boardUpdate', {
			type : 'post',
			contentType: 'application/json',
			data : JSON.stringify({'bno' : '002'}),
			beforeSend : function (xhr) { // 통신을 하기직전 헤더에 값을 부여
				let header = $('meta[name="_csrf_header"]').attr('content');
				let token = $('meta[name="_csrf"]').attr('content');
				
				xhr.setRequestHeader(header, token);
			}
		})
		.done( result => console.log(result))
		.fail(reject => console.log(reject));
	</script>

</body>
</html>