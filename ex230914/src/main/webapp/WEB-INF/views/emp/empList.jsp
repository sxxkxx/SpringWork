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
	<button type="button">선택삭제</button>
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
		
		// 단건 삭제
		$('tr button').on('click', empInfoDel)
		
		function empInfoDel(event){
			let trTag = $(event.currentTarget).closest('tr');
			let empId = $(trTag).children().eq(1).text();

			$.ajax('empDelete?employeeId='+empId)
			.done(result => {
				console.log(result);
				//$(trTag).remove();
				let deleteId = result.list[0];
				$('tbody > tr > td:nth-of-type(2)').each(function(idx, tag){
					if($(tag).text() == deleteId){
						$(tag).parent().remove();
					}
				})
			})
			.fail(reject => console.log(reject));
		}
		// 선택 삭제
		$('button:eq(0)').on('click', empListDelete);

		function empListDelete(event){
			// 선택한 사원번호를 가지는 배열
			let empIdList = getEmpList();

			// ajax
			$.ajax('empDelete',{
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(empIdList)
			})
			.done(result => {
				if(result){
					location.href='empList'; // 배열을 보낼 때 사용 but 극히 드문경우, 쓰면 욕먹음
				}
				 // 자바스크립트는 리턴 데이터 유형 구분해야함, ajax jquery는 상관없음
			})
			.fail(reject => console.log(reject));
		}

		function getEmpList(){
			let checkTag = $('tbody input[type="checkbox"]:checked');

			let empList = [];
			checkTag.each(function(idx, inTag){
				let empId = $(inTag).parent().next().text();
				empList.push(empId);
			});

			return empList;
		}

	</script>
</body>
</html>