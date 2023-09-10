<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
.testdiv{ margin:3px; width:450px; }
</style>
</head>
<body style="margin:12px">
<button class="orderPage btn btn-secondary">주문 페이지로</button><br><br>
<c:forEach var="list" items="${list}">
	<div class="testdiv">
    <c:if test="${list.orderId != prevOrderId}">
    <hr>
        <h2><p>주문 번호: ${list.orderId}</p></h2>
        <button class="delBtn btn btn-danger" style="float:right;" id="${list.orderId }" value="${list.orderId }">삭제</button>
        <h3><p>총 금액: ${list.totalAmount}</p></h3>
        <p>주문 날짜: ${list.orderDateTime}</p><br>
    </c:if>
<%--     <p>상품 ID: ${order.productId}</p> --%>
    <p>아이스크림 이름: ${list.productName}</p>
<%--     <p>상세 ID: ${order.orderDetailId}</p> --%>
<%--     <p>토핑 상세 ID: ${order.toppingDetailId}</p> --%>
<%--     <p>토핑 ID: ${order.toppingId}</p> --%>
    <p>토핑 이름: ${list.toppingName}</p>
    </div>
    <br>
    <c:set var="prevOrderId" value="${list.orderId}" />
</c:forEach>

${ctxPath = pageContext.request.contextPath ; '' }
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

$('.delBtn').click(function(){
	var id = $(this).val();
	console.log(id);
	if(confirm(id+"번 삭제하시겠습니까?")){
		$.ajax({
			method:'POST',
			url: `${ctxPath}/api/members`,
			data: {"id":id},
			dataType: "json",
			success: function(res){
				//window.location.reload(true);
				if(res) {
					window.location.reload(true);
				}
// 				alert("삭제")
			}
		})
	}
	
// 	history.go(0);
	
})

$('.orderPage').click(function(){
	location.href = "pick.do";
})
</script>
</body>
</html>












