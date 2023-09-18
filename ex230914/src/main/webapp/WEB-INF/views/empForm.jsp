<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
	<hr>
	<form action="">
		<table>
			<tr>
				<th>성</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="hireDate"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="jobId"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
	<script type="text/javascript">
		$('form:eq(1)').on('submit', function(e) {
			e.preventDefault();

			//let formData = new FormData(document.getElementsByTagName('form')[1]); 자바스크립트
			let formData = $('form:eq(1)').serializeArray(); // Jquery
			// serialize() : QueryString - key=Value&key=Value&...
			// serializeArray() : [{name : 'lastName', value:'king'}, ...] <= 요거를
			// {lastName : 'King', ...} <= 요런방식으로 변환해줘야함
			
			formData = $('table input');

			let formObj = {};
			$.each(formData, function(idx, obj){
				// 하나의 객체 => 하나의 필드
				formObj[obj.name] = obj.value;
			});
			// 반복문과 idx사용시 Jquery가 아닌 Javascript 사용해야함!!
	
			console.log(formData, formObj);
			
			$.ajax('empInfoInsert',{
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(formObj)
			})
			.done(data =>{
				console.log(data);
			})
			.fail(reject => console.log(reject));
				
			
			
			//return false;
		});

		/*
			Event Object
			- 메소드
			1) preventDefault() : 해당 이벤트에 기본으로 설정된 동작을 막음. (<a>태그의 href, )
			2) stopPropagation() : 이벤트 버블링(자식 -> 부모 이벤트 전파)을 막음.
			
			- 필드
			1) target : 이벤트가 발생한 태그 (고정값)
			2) currentTarget : 현재 이벤트 핸들러가 동작하는 태그 (변동값) => this
				submit 버튼 클릭 => form이 실행
		 */
	</script>
</body>
</html>