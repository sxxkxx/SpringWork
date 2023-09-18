<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form>
		<div>
			<label>employee_id : <input type="text" name="employee_id" value="${empInfo.employeeId}" readonly="readonly"></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName" value="${empInfo.firstName}"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName" readonly="readonly" value="${empInfo.lastName}"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email" value="${empInfo.email}"></label>
		</div>
		<div>
			<label>hire_date : <input type="date" name="hireDate" readonly="readonly" value="${empInfo.hireDate}"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary" value="${empInfo.salary}"></label>
		</div>
		<button type="reset">취소</button>
		<button type="button">수정</button>
	</form>
	<script type="text/javascript">
	
	
		let formData = $('form').serializeArray();
		
		let formObj = {};
		$.each(formData, function(idx, obj){
			// 하나의 객체 => 하나의 필드
			formObj[obj.name] = obj.value;
		});
		
		$.ajax('empInfoInsert',{
			type : 'post',
			contentType : 'application/json',
			data : JSON.stringify(formObj)
		})
		.done(data =>{
			console.log(data);
		})
		.fail(reject => console.log(reject));
	
	$('form').submit();
	</script>
</body>
</html>