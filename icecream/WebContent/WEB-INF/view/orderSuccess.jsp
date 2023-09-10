<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문완료</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
<h1> 주문 완료</h1><br>

<c:forEach var="order" items="${orderInfo}">
    <c:if test="${order.orderId != prevOrderId}">
        <h2><p>주문 번호: ${order.orderId}</p></h2><br>
        <h3><p>총 금액: ${order.totalAmount}</p></h3>
        <p>주문 날짜: ${order.orderDateTime}</p><br>
    </c:if>
<%--     <p>상품 ID: ${order.productId}</p> --%>
    <p>아이스크림 이름: ${order.productName}</p>
<%--     <p>상세 ID: ${order.orderDetailId}</p> --%>
<%--     <p>토핑 상세 ID: ${order.toppingDetailId}</p> --%>
<%--     <p>토핑 ID: ${order.toppingId}</p> --%>
    <p>토핑 이름: ${order.toppingName}</p>
    <br>
    <c:set var="prevOrderId" value="${order.orderId}" />
</c:forEach>
<button id="toOrderPage" class="btn btn-secondary">주문 페이지로</button>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$('#toOrderPage').click(function(){
	location.href = "pick.do";
});
</script>
</body>
</html>