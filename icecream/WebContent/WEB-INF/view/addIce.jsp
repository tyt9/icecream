<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
<h2>아이스크림 추가</h2><br>
<form action="addIceSuccess" method="post">
아이스크림 코드 <input type="text" placeholder="ice_iceName" name="productId"><br><br>
아이스크림 이름 <input type="text" placeholder="딸기 아이스크림" name="productName"><br><br>
아이스크림 가격 <input type="number" placeholder="2000" name="price"><br><br>
<input type="hidden" value="0" name="stockQuantity"><br>
<input type="submit" value="추가하기" class="btn btn-success">
<input type="button" id="prev" class="btn btn-secondary" value="이전으로">
</form>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$('#prev').click(function() {
		location.href = "pdManagement.do";
	})
	
</script>
</body>
</html>