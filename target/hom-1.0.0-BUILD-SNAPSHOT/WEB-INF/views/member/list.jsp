<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 목록</title>
    <style>

    </style>
</head>
<body>
<%@ include file="../common/top.jsp" %>
<h1>회원 목록</h1>
<c:choose>
    <c:when test="${not empty memberlist}">
        <table>
            <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>주소</th>
                <th>전화번호</th>
                <th>수정/삭제</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${memberlist}" >
                <tr>

                    <td><a href="${pageContext.request.contextPath}/view?id=${member.id}">${member.id}</a> </td>
                    <td>${member.pass}</td>
                    <td>${member.name}</td>
                    <td>${member.addr}</td>
                    <td>${member.tel}</td>
                    <td>
                        <form action="edit" method="post" style="display: inline;">
                            <input type="hidden" name="id" value="${member.id}">
                            <input type="submit" value="수정" class="edit-btn">
                        </form>
                        <!-- 삭제 폼 -->
                        <form action="delete" method="post" style="display: inline;">
                            <input type="hidden" name="id" value="${member.id}">
                            <input type="submit" value="삭제" class="delete-btn">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p class="no-data">등록된 회원이 없습니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>