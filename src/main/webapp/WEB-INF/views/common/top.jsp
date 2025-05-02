<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>여행 홈페이지</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
		header {
			background-color: #007bff;
			padding: 15px 0;
			text-align: center;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
		header h3 {
			color: white;
			margin: 0;
			font-weight: 600;
		}
		nav {
			background-color: #ffffff;
			padding: 10px 0;
			border-bottom: 1px solid #dee2e6;
		}
		nav ul {
			list-style: none;
			padding: 0;
			margin: 0;
			text-align: center;
		}
		nav ul li {
			display: inline-block;
			margin: 0 15px;
		}
		nav ul li a {
			color: #343a40;
			text-decoration: none;
			font-weight: 500;
			padding: 8px 12px;
			border-radius: 4px;
			transition: background-color 0.2s;
		}
		nav ul li a:hover {
			background-color: #e9ecef;
			color: #007bff;
		}
		.login-status {
			text-align: right;
			padding: 5px 20px;
			font-size: 0.9em;
			color: #6c757d;
		}
		hr {
			margin: 0;
			border-top: 1px solid #dee2e6;
		}
	</style>
</head>
<body>
<header>
	<h3>여행 홈페이지</h3>
</header>
<div class="login-status">
	<c:choose>
		<c:when test="${not empty sessionScope.userId}">
			사용자: ${sessionScope.userId} | <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
		</c:when>
		<c:otherwise>
			비로그인 중 | <a href="${pageContext.request.contextPath}/loginPage">로그인</a>
		</c:otherwise>
	</c:choose>
</div>
<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath}/">홈</a></li>
		<li><a href="#">공부방</a></li>
		<li><a href="#">자유게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/write">게시판글쓰기</a></li>
		<li><a href="${pageContext.request.contextPath}/board">자유게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/memberjoinPage">회원가입</a></li>
	</ul>
</nav>
<hr>
</body>
</html>