<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품등록</title>
    <meta charset="UTF-8">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <!-- jQuery 추가 (필요 시) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h3>상품상품</h3>

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
    <form id="searchForm" onsubmit="updateSearchHistory(event);">
        조회상품: <input type="text" name="name" id="searchInput">
        <button type="submit" id="searchButton">조회</button>
    </form>
</div>

<div>
    <h5>조회상품</h5>
    <table id="productList" border="1">
        <thead>
        <tr>
            <th>이름</th>
            <th>가격</th>
            <th>수량</th>
            <th>설명</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<div id="searchHistory">
    <h5>최신 검색어</h5>
    <ul id="searchHistoryList"></ul>
</div>

<script>
    async function updateSearchHistory(event) {
        event.preventDefault();
        document.getElementById('searchButton').disabled = true;
        const name = document.getElementById('searchInput').value.trim();

        if (!name) {
            alert('조회할 상품명을 입력하세요.');
            document.getElementById('searchButton').disabled = false;
            return;
        }

        const productList = document.getElementById('productList').getElementsByTagName('tbody')[0];

        try {
            const response = await axios.get('${pageContext.request.contextPath}/getlist', {
                params: { name: name }
            });

            productList.innerHTML = '';
            if (response.data && response.data.productName) {
                productList.innerHTML = '<tr>' +
                    '<td>' + response.data.productName + '</td>' +
                    '<td>' + response.data.price + '</td>' +
                    '<td>' + response.data.pcnt + '</td>' +
                    '<td>' + response.data.des + '</td>' +
                    '</tr>';
            } else {
                productList.innerHTML = '<tr><td colspan="4">상품을 찾을 수 없습니다.</td></tr>';
            }
        } catch (error) {
            console.error("Error:", error.response ? error.response.status : error.message);
            productList.innerHTML = '<tr><td colspan="4">조회 실패: ' + (error.message || '알 수 없는 오류') + '</td></tr>';
        } finally {
            document.getElementById('searchButton').disabled = false;
        }

        const searchHistoryList = document.getElementById('searchHistoryList');
        try {
            const response = await axios.get('${pageContext.request.contextPath}/getSearchHistory');
            let html = '';
            response.data.forEach(item => {
                html += '<li>' + item.searchName + ' (검색 시간: ' + item.searchDate + ') </li>';
            });
            searchHistoryList.innerHTML = html;
        } catch (error) {
            console.error("Error:", error.response ? error.response.status : error.message);
            searchHistoryList.innerHTML = '<li>검색어 로드 실패: ' + (error.message || '알 수 없는 오류') + '</li>';
        }
    }

    // jQuery 없이 페이지 로드 시 호출 (필요 시 주석 해제)
    window.onload = async function() {
        console.log("이게ㅁㄴㅇㅁㄴㅇ")
        await updateSearchHistory(null); // 페이지 로드 시 검색 기록 로드

    };
</script>
</body>
</html>