<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		데이터 찾기
		<hr/>     <%-- jsp 에서 변수 선언없이 사용 가능한 변수들 request, response, session..... --%>
		[HttpServletRequest 를 이용해서 찾기] <br/>
		데이터1 : <%=(String)request.getAttribute("data1") %> <br/>			<%--request 안에서 data1 을 찾아서 <%= ~~ %> 에 넣어준다. --%>
		데이터2 : <%=(String)request.getAttribute("data2") %> <br/> <br/>
		
		[HttpSession 를 이용해서 찾기] <br/>
		데이터1 : <%=(String)session.getAttribute("data1") %> <br/>
		데이터2 : <%=(String)session.getAttribute("data2") %> <br/> <br/>
		
		[EL 을 이용해서 찾기] <br/>
		데이터1 : ${data1} <br/>				<%-- request 에서 먼저 찾고 없으면 session 에서 찾는다. 둘 중에 한곳에만 저장되어 있으면 된다. request 가 우선순위 --%>
		데이터2 : ${data2} <br/> <br/>
	</body>
</html>