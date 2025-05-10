<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>조회글</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
            margin: 30px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h3 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .post-details {
            margin-bottom: 20px;
        }
        .post-details p {
            margin: 10px 0;
        }
        .comment-section {
            margin-top: 30px;
        }
        .comment-form textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            resize: vertical;
        }
        .comment-form button {
            margin-top: 10px;
            padding: 8px 16px;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            color: white;
            cursor: pointer;
        }
        .comment-form button:hover {
            background-color: #0056b3;
        }
        .comment-list {
            margin-top: 20px;
        }
        .comment-item {
            padding: 10px;
            border-bottom: 1px solid #dee2e6;
        }
        .btn-back {
            margin-top: 20px;
            display: inline-block;
        }
    </style>
</head>
<body>
<%@ include file="../common/top.jsp"%>
<div class="container">
    <h3>조회글</h3>
    <div class="post-details">
        <p><strong>번호:</strong> ${write.no}</p>
        <p><strong>제목:</strong> ${write.title}</p>
        <p><strong>작성자:</strong> ${write.name}</p>
        <p><strong>작성일:</strong> ${write.wdate}</p>
        <p><strong>조회수:</strong> ${write.cnt}</p>
        <p><strong>내용:</strong> ${write.body}</p>
        <p><strong>첨부파일:</strong></p>
        <c:forEach var="file" items="${files}">
            <a href="download?filename=${file}">[다운로드]</a>
            <img src="download?filename=${file}">
        </c:forEach>
    </div>

    <!-- 댓글 입력 폼 -->
    <div class="comment-section">
        <h4>댓글</h4>
        <c:choose>
            <c:when test="${empty sessionScope.userId}">
                <script>
                    alert("회원 전용입니다. 로그인하세요.");
                    window.location.href = "${pageContext.request.contextPath}/loginPage?error=login_required";
                </script>
            </c:when>
            <c:otherwise>
                <form action="${pageContext.request.contextPath}/saveComment" method="post" class="comment-form">
                    <input type="hidden" name="userId" value="${sessionScope.userId}">
                    <input type="hidden" name="num" value="${write.no}">
                    <textarea name="content" rows="4" placeholder="댓글을 입력하세요" required></textarea>
                    <button type="submit">댓글 작성</button>
                </form>
            </c:otherwise>
        </c:choose>

        <!-- 댓글 목록 -->
        <div class="comment-list">
            <c:choose>
                <c:when test="${empty commentList}">
                    <p>댓글이 없습니다.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="comment" items="${commentList}">
                        <div class="comment-item">
                            <p><strong>작성자:</strong> ${comment.user_Id}</p>
                            <p><strong>내용:</strong> ${comment.content}</p>
                            <p><strong>작성일:</strong> ${comment.cdate}</p>
                            <p><strong>좋아요:</strong> ${comment.good}</p>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <a href="${pageContext.request.contextPath}/board" class="btn btn-primary btn-back">목록으로</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>