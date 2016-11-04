<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/css/bootstrap.min.css"rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet">
	
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		로그인
		<hr/>
		<form method="post" >
			아이디 : <input type="text" name="mid" value="${findMid}"/> 
			<c:if test="${error == 'LOGIN_FAIL_MID' }">* 아이디가 존재하지 않음</c:if>			
			<br/>
			패스워드 : <input type="password" name="mpassword"/> 
			<c:if test="${error == 'LOGIN_FAIL_MPASSWORD' }">* 패스워드가 틀림</c:if>
			<br/>
			<input type="submit" value="로그인"/><br/>		
		</form>
		<a href="${pageContext.servletContext.contextPath}/member/join">회원가입</a> <br/>
		<a href="findMid">아이디 찾기</a> <br/>
		<a href="findMpassword">비밀번호 찾기</a> <br/>
	</body>
</html>
