<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.testdiv{ margin:3px; width:450px; }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body style="margin:12px">
<button class="orderPage btn btn-secondary">이전 페이지로</button><br><br>
<div class="testdiv"><label><h3>토핑 종류:</h3></label><br>
        <c:forEach var="list" items="${list}" varStatus="num">
        <hr>
        <p>${list.toppingId }</p>
        <p>${list.toppingName }</p>
        <p>${list.additionalPrice }원</p>
		</c:forEach></div>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$('.orderPage').click(function(){
	location.href = "addTop.do";
})
</script>
</body>
</html>