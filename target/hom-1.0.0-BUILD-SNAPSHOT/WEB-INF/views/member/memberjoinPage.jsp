<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery -->
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<!-- 커스텀 CSS -->
	<style>
		body {
			background-color: #f8f9fa;
			font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
		}
		.container {
			max-width: 600px;
			margin: 30px auto;
			padding: 20px;
			background-color: white;
			border-radius: 8px;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
		h3 {
			color: #007bff;
			margin-bottom: 20px;
			font-weight: 600;
			text-align: center;
		}
		table {
			width: 100%;
			border-collapse: collapse;
			background-color: white;
		}
		td {
			padding: 10px;
			border: 1px solid #dee2e6;
		}
		input[type="text"] {
			width: 100%;
			padding: 8px;
			border: 1px solid #ced4da;
			border-radius: 4px;
			box-sizing: border-box;
		}
		input[type="submit"] {
			width: 100%;
			padding: 10px;
			background-color: #007bff;
			border: none;
			border-radius: 4px;
			color: white;
			font-weight: 500;
			cursor: pointer;
			transition: background-color 0.2s;
		}
		input[type="submit"]:hover {
			background-color: #0056b3;
		}
		#duplexid {
			margin-left: 10px;
			color: #6c757d;
			cursor: pointer;
		}
		#duplexid:hover {
			color: #007bff;
			text-decoration: underline;
		}
	</style>
</head>
<body>
<%@ include file="../common/top.jsp"%>
<div class="container">
	<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath}/memberjoinj" method="post">
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type ="text" name="id" id="id"><span id="duplexid">중복체크</span></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type ="text" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type ="text" name="pass"></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type ="submit" value="가입">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
<script>
	$("#duplexid").click(()=>{
		let uid = $("#id").val();
		$.ajax({
			async:true,				//false라면 -> 동기 방식
			url: "${pageContext.request.contextPath}/duplexid", 		//url
			data: {'id' : uid}, 	//파라미터
			type: 'GET',			//get방식으로 보낸다.
			dataType: "text",
			success : function(data){//data = 서버로부터 받은 데이터

				if(data==''){
					alert("사용가능");
					$("#duplexid").text(data+"사용가능 아이디")
				}else{
					alert("중복된 아이디입니다.")
					$("#id").val('');
					$("#id").focus();
				}
			},
			error : function(){
				alert("통신오류")
			}
		})

	})
</script>