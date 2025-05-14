<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 1000px;
            margin-top: 30px;
        }
        .table {
            background-color: white;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .pagination {
            justify-content: center;
            margin-top: 20px;
        }
        .btn-write {
            float: right;
            margin-bottom: 5px;
        }
        .clickable-row {
            cursor: pointer;
        }
        .clickable-row:hover {
            background-color: #e9ecef;
        }
    </style>
</head>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<body>
<%@ include file="../common/top.jsp"%>
<div class="container">
    <h3 class="mb-4">게시판</h3>


    <!-- 게시글 목록 테이블 -->
    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th scope="col" style="width: 50%;">제목</th>
            <th scope="col" style="width: 40%;">작성일</th>
            <th scope="col" style="width: 10%;">조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty writeList}">
                <tr>
                    <td colspan="2" class="text-center">게시글이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="write" items="${writeList}">
                    <tr class="clickable-row"
                        <c:choose>
                            <c:when test="${write.s_flag == 1}">
                                onclick ="alert('비공개글입니다.')"
                            </c:when>
                            <c:otherwise>
                                onclick="location.href='${pageContext.request.contextPath}/chboard?no=${write.no}'">
                            </c:otherwise>

                        </c:choose>>
                        <td>
                                ${write.title}
                            <c:if test="${write.s_flag == 1}">[비공개]</c:if>
                        </td>
                        <td>
                                ${write.wdate}
                        </td>
                        <td>${write.cnt}</td>
                        <td><a href="${pageContext.request.contextPath}/delete?no=${write.no}">수정</a></td>
                    <td><a href="<c:url value="/delete?no=${write.no}"/>">삭제</a></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageVO.prev}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/board?page=${pageVO.startPage - 1}" aria-label="Previous">
                        <span aria-hidden="true">«</span>
                    </a>
                </li>
            </c:if>
            <c:forEach var="i" begin="${pageVO.startPage}" end="${pageVO.endPage}">
                <li class="page-item ${pageVO.page == i ? 'active' : ''}">
                    <a class="page-link" href="${pageContext.request.contextPath}/board?page=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${pageVO.next}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/board?page=${pageVO.endPage + 1}" aria-label="Next">
                        <span aria-hidden="true">»</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<script>
    window.onload = () => loadPage(1);

async function loadPage(page) {

}
</script>