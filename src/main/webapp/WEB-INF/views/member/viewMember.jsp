<%--
  Created by IntelliJ IDEA.
  User: hoyoung
  Date: 25. 5. 1.
  Time: 오후 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>자세히보기</title>
</head>
<body>
<%@ include file="../common/top.jsp" %>
<h1>검색 회원</h1>
<table>
<tr>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>주소</th>
    <th>전화번호</th>
    <th>수정/삭제</th>
</tr>
<tr>

    <td>${member.id}</td>
    <td>${member.pass}</td>
    <td>${member.name}</td>
    <td>${member.addr}</td>
    <td>${member.tel}</td>
   <td> <form action="/member/edit" method="post" style="display: inline;">
        <input type="hidden" name="id" value="${member.id}">
        <input type="submit" value="수정" class="edit-btn">
    </form>
    <!-- 삭제 폼 -->
    <form action="/member/delete" method="post" style="display: inline;">
        <input type="hidden" name="id" value="${member.id}">
        <input type="submit" value="삭제" class="delete-btn">
    </form>
   </td>
</tr>
</table>
</body>
</html>
