<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ֹ��Ϸ�</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
<h1> �ֹ� �Ϸ�</h1><br>

<c:forEach var="order" items="${orderInfo}">
    <c:if test="${order.orderId != prevOrderId}">
        <h2><p>�ֹ� ��ȣ: ${order.orderId}</p></h2><br>
        <h3><p>�� �ݾ�: ${order.totalAmount}</p></h3>
        <p>�ֹ� ��¥: ${order.orderDateTime}</p><br>
    </c:if>
<%--     <p>��ǰ ID: ${order.productId}</p> --%>
    <p>���̽�ũ�� �̸�: ${order.productName}</p>
<%--     <p>�� ID: ${order.orderDetailId}</p> --%>
<%--     <p>���� �� ID: ${order.toppingDetailId}</p> --%>
<%--     <p>���� ID: ${order.toppingId}</p> --%>
    <p>���� �̸�: ${order.toppingName}</p>
    <br>
    <c:set var="prevOrderId" value="${order.orderId}" />
</c:forEach>
<button id="toOrderPage" class="btn btn-secondary">�ֹ� ��������</button>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$('#toOrderPage').click(function(){
	location.href = "pick.do";
});
</script>
</body>
</html>