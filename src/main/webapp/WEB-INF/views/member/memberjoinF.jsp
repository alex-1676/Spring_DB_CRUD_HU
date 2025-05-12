<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script> <!-- jquery 설치 -->
<body>
	<%@ include file="../common/top.jsp"%>
	<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath}/memberjoind" method="post"> <!-- 데이터 베이스에 삽입 작업은 대게 post방식 -->
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type ="text" name="id" id="userid"><span id="duplexid">중복체크</span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type ="text" name="pass"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type ="text" name="name"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type ="text" name="addr"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type ="text" name="tel"></td>
			</tr>
			<tr>
				<td colspan=2>
				<input type ="submit" value="가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
//jquery라는 js 라이브러리 : js의 자주 사용되는 기능으로 개발된 라이브러리
//설치는 주로 cdn 방식으로 한다.
//jquery 문법은 $로 시작
$("#duplexid").click(()=>{	//id가 userid 태그를 선택해서 click이벤트를 정의한다
	let uid = $("#userid").val();
	
	
	
	//비동기 방식으로 서버에 전송해보자
	//request(비동기), url, parameter, method
	$.ajax({
		async:true,				//false라면 -> 동기 방식
		url: "duplexid", 		//url
		data: {'id' : uid}, 	//파라미터			
		type: 'GET',			//get방식으로 보낸다.
		dataType: "text",
		success : function(data){//data = 서버로부터 받은 데이터
			alert(data + "서버로부터 받음");
			if(data!=''){
				alert("사용가능");
				$("#duplexid").text(data+"사용가능 아이디")
			}else{
				alert("중복된 아이디입니다.")
				$("#userid").val('');
				$("#userid").focus();
			}
		},
		error : function(){
			alert("통신오류")
		}
	})
})
</script>