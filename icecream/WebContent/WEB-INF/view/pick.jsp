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
    <h1>���̽�ũ�� �ֹ� ������</h1>
        <h2>��ǰ ����</h2>
        <label>���̽�ũ�� ����:</label><br>
        <input type="radio" name="product" value="ice_choco" checked><label>�ٴҶ� ���̽�ũ��</label><br>
        <input type="radio" name="product" value="ice_strawberry"><label>���ݸ� ���̽�ũ��</label><br>
        <input type="radio" name="product" value="ice_yogurt"><label>���� ���̽�ũ��</label><br><br>

        <h2>���� ����</h2>
        <label>�߰� ����:</label><br>
<!--         <input type="checkbox" name="toppings" value="0" style="display:none" checked> -->
        <input type="checkbox" name="toppings" value="top_chocochip">
        <label>���Ͻ� ���ݸ� Ĩ</label><br>
        <input type="checkbox" name="toppings" value="top_cherry">
        <label>���� �Ŀ��</label><br>
        <input type="checkbox" name="toppings" value="top_cereal">
        <label>���� ȥ��</label><br>

        <input type="submit" value="���" id="test">
        <form action="orderSuccess.do" id="formTest" method="post">
        <input type="submit" value="�ֹ��ϱ�" id="orderSubmit" >
        </form>
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		 var num = 1;
		  var formTest = $("#formTest");
		  // -- ����ư �̺�Ʈ --
		  $('#test').click(function(){
			  var product = $("input[name='product']:checked").val();
			  var pdName = $("input[name='product']:checked").next().text();
// 			  formTest.append("<div id='"+num+"' class='testdiv'><div name='pd' >��ǰ��ȣ : "+product+" | ��ǰ�� : "+pdName+"</div></div>")
			  formTest.append("<div id='"+num+"' class='testdiv'>"
						  		+"<input type='hidden' class='pd_hd' name='pd_id_"+num+"' value='"+product+"'>"
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
// 			      alert(tpId);
			      //alert(tpName);
			      div.append("<input type='hidden' class='tp_hd' name='tp_id_"+num+"' value='"+tpId+"'>"
			    		  +"<div id='tp_"+tpnum+"'>���ι�ȣ : "+tpId+" | ���θ� : "+tpName+"</div>")
			      tpnum = tpnum+1;
				
			      //formTest.append("<div id="+num+">��ǰ��ȣ : "+product+" | ��ǰ�� : "+pdName+"</div>")
			    }
			  });

			  num = num + 1;
			});
		// -- ����ư �̺�Ʈ �� --
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
// 			list.push("1��");
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
	                alert("error�� ");
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


