<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>글쓰기</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 커스텀 CSS -->
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
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
        input[type="text"], textarea, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical; /* 세로 크기 조정만 가능 */
        }
        button[type="submit"] {
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
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%@ include file="../common/top.jsp"%>
<c:if test="${empty sessionScope.userId}">
    <script>
        alert("회원 전용입니다. 로그인하세요.");
        location.href = "${pageContext.request.contextPath}/loginPage";
    </script>
</c:if>
<div class="container">
    <h3>글쓰기</h3>

    <form action="${pageContext.request.contextPath}/saveWrite" method="post" accept-charset="UTF-8">
        <table border="1">
            <tr>
                <td>제목</td>
                <td><input type="text" id="title" name="title"></td>
            </tr>
            <tr>
                <td>ID</td>
                <td><input type="text" id="name" name="name"></td>
            </tr>
            <tr>
                <td>작성글</td>
                <td><textarea name="body" rows="5" cols="30"></textarea></td>
            </tr>
            <tr>
                <td>공개여부</td>
                <td>
                    <select name="s_flag">
                        <option value="0">공개</option>
                        <option value="1">비공개</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" id="save">저장</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
<script>
    $("form").submit(function(event) {
        if ($("#title").val() === "") {
            alert("제목을 적으시오");
            event.preventDefault(); // 폼 제출 방지
            return;
        }
        if ($("#name").val() === "") {
            alert("작성자를 적으시오");
            event.preventDefault(); // 폼 제출 방지
            return;
        }
    });
</script>