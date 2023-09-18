<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<p>${result}</p>
	<table border="1">
		<thead>
			<tr>
				<th>Check</th>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td><input type="checkbox"></td>
					<td>${emp.employeeId }</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td><fmt:formatDate value="${emp.hireDate}"
							pattern="yyyy년MM월dd일" /></td>
					<td>${emp.jobId}</td>
					<td>${emp.salary}</td>
					<td><button type="button">Del</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		// tip
		let message = [
			<c:forEach begin="1" end="5">
			`${result}`, //자바스크립트의 변수에 쓸때만 가능
			
		</c:forEach>
			];
		if(message.length > 0 ) alert(message.toString());
		
		
		$('tbody > tr').on('click', function(e) {
			if (e.target.tagName != 'TD')
				return; // 실제 이벤트가 발생한 대상이 td가아니면 동작안함

			//let empId = e.currentTarget.firstElementChild.nextElementSibling.textContent; javascript방식
			let empId = $(e.currentTarget).find('td:nth-of-type(2)').text(); //Jquery 방식
			//let empId = $(e.currentTarget).find('td:eq(1)').text(); 인덱스1번
			location.href = 'empInfo?employeeId=' + empId;
		});
	</script>
</body>
</html>