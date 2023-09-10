<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
.testdiv{ border:1px solid blue; margin:3px; width:350px; }
</style>
</head>
<body>
    <h1>아이스크림 주문 페이지</h1>
        <h2>제품 선택</h2>
        <label>아이스크림 종류:</label><br>
        <input type="radio" name="product" value="ice_choco" checked><label>바닐라 아이스크림</label><br>
        <input type="radio" name="product" value="ice_strawberry"><label>초콜릿 아이스크림</label><br>
        <input type="radio" name="product" value="ice_yogurt"><label>딸기 아이스크림</label><br><br>

        <h2>토핑 선택</h2>
        <label>추가 토핑:</label><br>
<!--         <input type="checkbox" name="toppings" value="0" style="display:none" checked> -->
        <input type="checkbox" name="toppings" value="top_chocochip">
        <label>웨하스 초콜릿 칩</label><br>
        <input type="checkbox" name="toppings" value="top_cherry">
        <label>녹차 파우더</label><br>
        <input type="checkbox" name="toppings" value="top_cereal">
        <label>과일 혼합</label><br>

        <input type="submit" value="담기" id="test">
        <form action="orderSuccess.do" id="formTest" method="post">
        <input type="submit" value="주문하기" id="orderSubmit" >
        </form>
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		 var num = 1;
		  var formTest = $("#formTest");
		  // -- 담기버튼 이벤트 --
		  $('#test').click(function(){
			  var product = $("input[name='product']:checked").val();
			  var pdName = $("input[name='product']:checked").next().text();
// 			  formTest.append("<div id='"+num+"' class='testdiv'><div name='pd' >상품번호 : "+product+" | 상품명 : "+pdName+"</div></div>")
			  formTest.append("<div id='"+num+"' class='testdiv'>"
						  		+"<input type='hidden' class='pd_hd' name='pd_id_"+num+"' value='"+product+"'>"
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
// 			      alert(tpId);
			      //alert(tpName);
			      div.append("<input type='hidden' class='tp_hd' name='tp_id_"+num+"' value='"+tpId+"'>"
			    		  +"<div id='tp_"+tpnum+"'>토핑번호 : "+tpId+" | 토핑명 : "+tpName+"</div>")
			      tpnum = tpnum+1;
				
			      //formTest.append("<div id="+num+">상품번호 : "+product+" | 상품명 : "+pdName+"</div>")
			    }
			  });

			  num = num + 1;
			});
		// -- 담기버튼 이벤트 끝 --
		$('#orderSubmit').click(function(){
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
		
		
// 		$.ajax({
// 		    url: "/orderSuccess",
// 		    type: "POST",
// 		    data:{list:JSON.stringify(list)},
// 		    success: function(result){
// 		    },
// 		});
    </script>
</html>


