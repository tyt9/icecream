<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
<%-- 
<c:if test="${! empty authUser}">
	${authUser.name}님, 안녕하세요.
	<a href="logout.do">[로그아웃하기]</a>
	<a href="changePwd.do">[암호변경하기]</a>
</c:if>
<c:if test="${empty authUser}">
	<a href="join.do">[회원가입하기]</a>
	<a href="login.do">[로그인하기]</a>
</c:if>
--%>
<u:isLogin>
	${authUser.name}님, 안녕하세요.
	<a href="logout.do">[로그아웃하기]</a>
	<a href="pick.do">[들어가기~!]</a>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
if(window.location == 'http://localhost:9090/icecream/index.jsp'
	|| window.location == 'http://localhost:9090/icecream/'){
	window.location.href = 'http://localhost:9090/icecream/pick.do';
}
</script>
</u:isLogin>
<u:notLogin>
<!-- 	<a href="join.do">[회원가입하기]</a> -->
	<a href="login.do">[로그인하기]</a>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	if(window.location == 'http://localhost:9090/icecream/index.jsp'
	|| window.location == 'http://localhost:9090/icecream/'){
		window.location.href = 'http://localhost:9090/icecream/login.do';
	}
</script>
</u:notLogin>
<br/>
</body>
</html>