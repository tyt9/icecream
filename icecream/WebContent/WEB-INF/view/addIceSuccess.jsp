<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.testdiv{ margin:3px; width:450px; }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
<button class="orderPage btn btn-secondary">이전 페이지로</button><br><br>
<div class="testdiv"><label><h3>아이스크림 종류:</h3></label><br>
        <c:forEach var="list" items="${list}" varStatus="num">
        <hr>
        <p>${list.productId }</p>
        <p>${list.productName }</p>
        <p>${list.price }원</p>
		</c:forEach></div>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$('.orderPage').click(function(){
	location.href = "addIce.do";
})
</script>
</body>
</html>