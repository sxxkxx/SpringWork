<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 조회</title>
</head>
<body>
	<div>
		<div>
			<table border="1">
				<tr>
					<th>employee_id</th>
					<td>${empInfo.employeeId}</td>
				</tr>
				<tr>
					<th>first_name</th>
					<td>${empInfo.firstName}</td>
				</tr>
				<tr>
					<th>last_name</th>
					<td>${empInfo.lastName}</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${empInfo.email}</td>
				</tr>
				<tr>
					<th>hire_date</th>
					<td><fmt:formatDate value="${empInfo.hireDate}"
							pattern="yyyy년MM월dd일" /></td>
				</tr>
				<tr>
					<th>job_id</th>
					<td>${empInfo.jobId}</td>
				</tr>
				<tr>
					<th>salary</th>
					<td>${empInfo.salary}</td>
				</tr>
				<tr>
					<th>department_id</th>
					<td>${empInfo.departmentId}</td>
				</tr>
			</table>
			<button type="button" onclick="location.href='empList'">목록</button>
			<button type="button" onclick="location.href='empUpdate?employeeId=${empInfo.employeeId}'">수정</button>
		</div>
	</div>
</body>
</html>