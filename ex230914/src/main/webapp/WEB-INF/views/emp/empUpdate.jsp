<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<label>employee_id : <input type="text" name="employeeId"
				value="${empInfo.employeeId}" readonly="readonly"></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName"
				value="${empInfo.firstName}"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"
				readonly="readonly" value="${empInfo.lastName}"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email"
				value="${empInfo.email}"></label>
		</div>
		<div>
			<label>hire_date : <input type="date" name="hireDate"
				readonly="readonly" value='<fmt:formatDate value="${empInfo.hireDate}" pattern="yyyy-MM-dd" />' >  </label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"
				value="${empInfo.salary}"></label>
		</div>
		<button type="reset">취소</button>
		<button type="button">수정</button>
	</form>
	<script type="text/javascript">
	
	$('form > :button').on('click', empUpdateHandler);

	function empUpdateHandler(event){
		// 보낼 데이터
		let objData = getEmpInfo();
		for(let field in objData){
			// for in(객체 내부 순환) 사용 시 []대괄호 사용 
			// 1) 변수에 필드명을 담아서 사용하는 경우
			// 2) 필드병을 문자열로 접근해야하는 경우 : 특수문자사용(-),영문을 제외한 한글
			console.log(objData[field]); 
			console.log(objData.employeeId, objData['employeeId']);
		}	
		// ajax
		$.ajax('empUpdate',{
			type : 'post',
			contentType : 'application/json',
			data : JSON.stringify(objData)
		})
		.done(result =>{ // success, done은 연속적으로 사용가능(done종료 후 다른 done), javascript의 then과 동일
			let message = '결과 : '+ result['결과']+', 대상 사원번호 : '+result['사원번호'];
			alert(message);
		})
		.fail(reject => console.log(reject)); // error
					
	}
	function getEmpInfo(){
		let formData = $('form').serializeArray();

		let formObj = {};
		$.each(formData, function(idx, obj){
			formObj[obj.name] = obj.value;
		});

		return formObj;
	}
	</script>
</body>
</html>