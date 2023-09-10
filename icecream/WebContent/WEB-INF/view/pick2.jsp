<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>���̽�ũ�� ����~!</title>
<style>
	.testdiv{ border:3px solid #0075c4; margin:3px; width:450px; }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
    <br><h1>���̽�ũ�� �ֹ� ������</h1>
        <br><h2>��ǰ ����</h2>
        <div class="pd_div"><label>���̽�ũ�� ����:</label><br>
        <c:forEach var="pdList" items="${pdList}" varStatus="num">
			<input type="radio" name="product" value="${pdList.productId}" >
			<label>${pdList.productName } </label><small>${pdList.price }</small><br>
		</c:forEach></div>
         
        <br><h2>���� ����</h2>
        <div class="pd_div"><label>�߰� ����:</label><br>
		<c:forEach var="tpList" items="${tpList}" varStatus="num">
			<input type="checkbox" name="toppings" value="${tpList.toppingId }">
        	<label>${tpList.toppingName }</label><small>${tpList.additionalPrice }</small><br>
		</c:forEach></div><br>
        
        
        <form action="orderSuccess.do" id="formTest" method="post">
        <input type="button" value="���" id="test" class="btn btn-primary">
        <input type="submit" value="�ֹ��ϱ�" id="orderSubmit" class="btn btn-success">
        <input type="button" value="�ʱ�ȭ" id="resetBtn" class="btn btn-warning">
<!--         <button id="resetBtn" class="btn btn-danger">�ʱ�ȭ</button> -->
<!--         <button class="orderHisBtn btn btn-info">���� �ֹ� ����</button> -->
        <input type="button" value="���� �ֹ� ����" class="orderHisBtn btn btn-info">
        <input type="button" id="management" value="����" class="btn btn-secondary">
        </form>
        <div></div>
        
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var totalAmount = 0; 
		 var num = 1;
		  var formTest = $("#formTest");
		  // -- ����ư �̺�Ʈ --
		  $('#test').click(function(){
			  var product = $("input[name='product']:checked").val();
			  var pdName = $("input[name='product']:checked").next().text();
			  var pdPrice = parseInt($("input[name='product']:checked").next().next().text());
// 			  alert(pdName);
// 			  alert(pdPrice);
			  totalAmount = totalAmount + pdPrice;
// 			  formTest.append("<div id='"+num+"' class='testdiv'><div name='pd' >��ǰ��ȣ : "+product+" | ��ǰ�� : "+pdName+"</div></div>")
			  formTest.append("<div id='"+num+"' class='testdiv'>"
					  			+"<input type='button' class='addDel' style='float: right;' value='����'>"
						  		+"<input type='hidden' class='pd_hd' name='"+num+"' value='"+product+"'>"
						  		+"<div id='pd' >��ǰ��ȣ : "+product+" | ��ǰ�� : "+pdName+"</div>"
						  	 +"</div>")
// 			alert($("#num").attr("value"));
			  var tpnum = 1;
			  $('input:checkbox[name=toppings]').each(function (index) {
			    if($(this).is(":checked")==true){

			      var divNum = "#"+num;
			      var div = $(divNum);
			      var tpId = $(this).val();
			      var tpName = $(this).next().text();
			      var tpPrice = parseInt($(this).next().next().text());
			      totalAmount = totalAmount + tpPrice;
// 			      alert(tpId);
			      //alert(tpName);
			      div.append("<input type='hidden' class='tp_hd' name='"+num+"' value='"+tpId+"'>"
			    		  +"<div id='tp_"+tpnum+"'>���ι�ȣ : "+tpId+" | ���θ� : "+tpName+"</div>")
			      tpnum = tpnum+1;
				
			      //formTest.append("<div id="+num+">��ǰ��ȣ : "+product+" | ��ǰ�� : "+pdName+"</div>")
			    }
			  });
// 			alert(totalAmount);
			  num = num + 1;
			  $('div:last').html("<br><h4>����ݾ� :"+totalAmount+"</h4>");
			});
		// -- ����ư �̺�Ʈ �� --
		
		// -- �ֹ��ϱ� ��ư �̺�Ʈ 
		$('#orderSubmit').click(function(){
			if($('#1').length == 0){
				alert("���̽�ũ�� ����~!");
				return false;
			}else{
			console.log("ttt");
				
				var list = new Array();
	// 			$('.pd_hd').each(function(index,item) {
	// 				console.log($(item).val)
	// 				list.push($(item).val());
	// 			});
				$('.tp_hd').each(function(index,item) {
					$('input.tp_hd').find()
					console.log($(item).val)
					list.push($(item).val());
				});
	// 			list.push("1��");
				console.log(list);
				orderArray();
			}
		})
// 		function getList() {
// 			console.log("ttt");
// 			var list = new Array();
// 			$('.tp_hd').each(function(index,item) {
// 				console.log($(item).val)
// 				list.push($(item).val());
// 			});
// 			console.log(list);
			
// 		}
		
		 function orderArray() {
	        $.ajax({
	            data: JSON.stringify(list),
	            url: "/orderSuccess",
	            type: "POST",
	            contentType: "application/json; charset=UTF-8",
	            success: function (data) {
	                location.href = "/orderSuccess"
	            },
	            error: function() {
	                alert("error�� ");
	            }
	        });
	    }

	// ������ư �� ù��° checked
	$('input:radio[name=product]').first().attr("checked",true); 
// 	$('input:radio[name=product]').eq(2).attr("checked",true); --> eq(0) - ù��° ���� = .first()

 	// ���� �ֹ� ���� ��ư �̺�Ʈ
	$('.orderHisBtn').click(function(){
		location.href = "previousOrders";
	});

	// �ʱ�ȭ ��ư �̺�Ʈ
	$('#resetBtn').click(function(){
		location.href = "pick.do";
	});
	
	// ���� ��ư �̺�Ʈ
	$(document).on("click", ".addDel", function(){ // �������� ������ ��ư�� �����Ҷ� 
		$(this).closest("div").remove();
	
	});
	
	$('#management').click(function(){
		location.href = "pdManagement.do";
	});

    </script>
</html>


