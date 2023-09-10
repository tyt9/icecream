<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
<button id="addIceBtn" class="btn btn-primary">아이스크림 추가</button>
<button id="addTopBtn" class="btn btn-primary">토핑 추가</button>
<button class="orderPage btn btn-secondary">주문 페이지로</button><br><br>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$('#addIceBtn').click(function() {
		location.href = "addIce.do";
	})
	$('#addTopBtn').click(function() {
		location.href = "addTop.do";
	})
	$('.orderPage').click(function(){
	location.href = "pick.do";
})
</script>
</body>
</html>