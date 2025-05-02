<%--
  Created by IntelliJ IDEA.
  User: hoyoung
  Date: 25. 5. 2.
  Time: 오후 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품등록</title>
</head>
<body>
<h3>상품상품</h3>
<meta charset="UTF-8">
<div>
    <form action="${pageContext.request.contextPath}/insertpro" method="post" accept-charset="UTF-8">
        이름:<input type="text" name="productName">
        가격:<input type="text" name="price">
        수량:<input type="text" name="pcnt">
        설명:<input type="text" name="des">
        <button type="submit">등록</button>
    </form>
</div>
<div>
    <form action="${pageContext.request.contextPath}/getlist" method="get" accept-charset="UTF-8"   >
        조회상품: <input type="text" name="name">
        <button type="submit" onclick="updateSearchHistory()">조회</button>
    </form>

</div>
<div>
    <h5>조회상품</h5>
    <table>
        <thead>
        <tr>
            <th>이름</th>
            <th>가격</th>
            <th>수량</th>
            <th>설명</th>
        </tr>
        </thead>
        <tbody id="productList">

        <tr>
            <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.pcnt}</td>
                <td>${product.des}</td>
            </tr>

        </tbody>
    </table>
</div>

<div id="searchHistory">
    <h5>최신 검색어</h5>
    <ul id="searchHistoryList">

    </ul>
</div>

</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function updateSearchHistory(event) {
        // event가 없는 경우(페이지 로드 시 호출) 처리
        if (event) {
            event.preventDefault(); // 폼 제출 기본 동작 중지
            const name = $('#searchInput').val().trim();
            if (!name) {
                alert('조회할 상품명을 입력하세요.');
                return;
            }
            $('#searchForm').submit();
        }

        // 비동기적으로 검색어 리스트 갱신
        $.ajax({
            url: '${pageContext.request.contextPath}/getSearchHistory',
            method: 'GET',
            dataType: 'json',
            success: function(data) {

                let html = '';
                data.forEach((item) => {
                    html += '<li>'+item.searchName +'(검색 시간: '+item.searchDate+') </li>';
                });
                $('#searchHistoryList').html(html);
            },
            error: function(xhr, status, error) {
                alert('검색어 로드 실패: ' + error);
            }
        });
    }
    $(document).ready(function() {
        updateSearchHistory(null); // event 없이 호출
    });
</script>
