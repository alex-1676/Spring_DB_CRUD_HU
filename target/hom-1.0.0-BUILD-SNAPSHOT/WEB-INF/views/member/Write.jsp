<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
#main{
    width: 700px;
    height: 800px;
    border: 1px solid;
  }
  .write{
    width: 650px;
    height: 700px;
    
    margin: auto;
    margin-top: 10px;
  }
  #writesave{
    float: right;
    margin-right: 20px;
    margin-top: 20px;
  }
  span{
    margin-left: 20px;
  }
  #open{
    margin-left: 70px;
  }
</style>
<body>
<%@ include file="../common/top.jsp"%>

 <form action="${pageContext.request.contextPath}/postSave" method="post">
    <div id="main">
      <span>제목</span><input type="text" maxlength="20" name="title" id="titleid">
      <span>작성자</span><input type="text" maxlength="10" name="writer" id="writerid">
      <span id="open">공개여부</span><select name="opencheck">
        <option value="0">공개</option>
        <option value="1">비공개</option>
      </select>
      <!--자바 스크립트로 글자수 제한하기-->
      <div class="write">
        <textarea name="inwrite" class="write" id="inwrite" maxlength="100">
    
        </textarea>
      </div>
      <input type="submit" value="저장" id="writesave">
    </div>
  </form>
  
  

</body>
</html>
<script>
  window.onload = function(){
    document.getElementById('writesave').addEventListener('click', ()=>{
      let a = document.getElementById('titleid').value;
      let b = document.getElementById('writerid').value;

      if(a==''||b==''){
        alert('작성자와 제목은 반드시 입력해야합니다.');
        return;
      }
    })
    
  }
</script>
