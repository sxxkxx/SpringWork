<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보</title>
</head>
<body>
	<div>
		<form action="getEmp" method="get">
			<label>사원번호<input type="number" name="employeeId"></label>
			<button type="submit">검색</button>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>사원번호</th>
				<td>${empInfo.employeeId}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${empInfo.lastName}</td>
			</tr>
			<tr>
				<th>업무</th>
				<td>${empInfo.jobId}</td>
			</tr>
		</table>
	</div>
</body>
</html>