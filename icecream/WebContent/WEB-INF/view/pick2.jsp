<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>아이스크림 가게~!</title>
<style>
	.testdiv{ border:3px solid #0075c4; margin:3px; width:450px; }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="margin:12px">
    <br><h1>아이스크림 주문 페이지</h1>
        <br><h2>제품 선택</h2>
        <div class="pd_div"><label>아이스크림 종류:</label><br>
        <c:forEach var="pdList" items="${pdList}" varStatus="num">
			<input type="radio" name="product" value="${pdList.productId}" >
			<label>${pdList.productName } </label><small>${pdList.price }</small><br>
		</c:forEach></div>
         
        <br><h2>토핑 선택</h2>
        <div class="pd_div"><label>추가 토핑:</label><br>
		<c:forEach var="tpList" items="${tpList}" varStatus="num">
			<input type="checkbox" name="toppings" value="${tpList.toppingId }">
        	<label>${tpList.toppingName }</label><small>${tpList.additionalPrice }</small><br>
		</c:forEach></div><br>
        
        
        <form action="orderSuccess.do" id="formTest" method="post">
        <input type="button" value="담기" id="test" class="btn btn-primary">
        <input type="submit" value="주문하기" id="orderSubmit" class="btn btn-success">
        <input type="button" value="초기화" id="resetBtn" class="btn btn-warning">
<!--         <button id="resetBtn" class="btn btn-danger">초기화</button> -->
<!--         <button class="orderHisBtn btn btn-info">이전 주문 내역</button> -->
        <input type="button" value="이전 주문 내역" class="orderHisBtn btn btn-info">
        <input type="button" id="management" value="관리" class="btn btn-secondary">
        </form>
        <div></div>
        
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var totalAmount = 0; 
		 var num = 1;
		  var formTest = $("#formTest");
		  // -- 담기버튼 이벤트 --
		  $('#test').click(function(){
			  var product = $("input[name='product']:checked").val();
			  var pdName = $("input[name='product']:checked").next().text();
			  var pdPrice = parseInt($("input[name='product']:checked").next().next().text());
// 			  alert(pdName);
// 			  alert(pdPrice);
			  totalAmount = totalAmount + pdPrice;
// 			  formTest.append("<div id='"+num+"' class='testdiv'><div name='pd' >상품번호 : "+product+" | 상품명 : "+pdName+"</div></div>")
			  formTest.append("<div id='"+num+"' class='testdiv'>"
					  			+"<input type='button' class='addDel' style='float: right;' value='삭제'>"
						  		+"<input type='hidden' class='pd_hd' name='"+num+"' value='"+product+"'>"
						  		+"<div id='pd' >상품번호 : "+product+" | 상품명 : "+pdName+"</div>"
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
			    		  +"<div id='tp_"+tpnum+"'>토핑번호 : "+tpId+" | 토핑명 : "+tpName+"</div>")
			      tpnum = tpnum+1;
				
			      //formTest.append("<div id="+num+">상품번호 : "+product+" | 상품명 : "+pdName+"</div>")
			    }
			  });
// 			alert(totalAmount);
			  num = num + 1;
			  $('div:last').html("<br><h4>예상금액 :"+totalAmount+"</h4>");
			});
		// -- 담기버튼 이벤트 끝 --
		
		// -- 주문하기 버튼 이벤트 
		$('#orderSubmit').click(function(){
			if($('#1').length == 0){
				alert("아이스크림 선택~!");
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
	// 			list.push("1번");
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
	                alert("error… ");
	            }
	        });
	    }

	// 라디오버튼 중 첫번째 checked
	$('input:radio[name=product]').first().attr("checked",true); 
// 	$('input:radio[name=product]').eq(2).attr("checked",true); --> eq(0) - 첫번째 선택 = .first()

 	// 이전 주문 내역 버튼 이벤트
	$('.orderHisBtn').click(function(){
		location.href = "previousOrders";
	});

	// 초기화 버튼 이벤트
	$('#resetBtn').click(function(){
		location.href = "pick.do";
	});
	
	// 삭제 버튼 이벤트
	$(document).on("click", ".addDel", function(){ // 동적으로 생성된 버튼을 선택할때 
		$(this).closest("div").remove();
	
	});
	
	$('#management').click(function(){
		location.href = "pdManagement.do";
	});

    </script>
</html>


