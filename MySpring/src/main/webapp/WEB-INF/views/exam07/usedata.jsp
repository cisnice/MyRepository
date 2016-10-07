<%@ page contentType="text/html;charset=UTF-8"%>					
<%@ page import="com.mycompany.myspring.exam07.Board" %>	
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		데이터 찾기	
		<hr/>     							
		[HttpServletRequest 를 이용해서 찾기] <br/>
		데이터1 : <%=(String)request.getAttribute("AAA") %> <br/>			
		데이터2 : <%=(String)request.getAttribute("BBB") %> <br/> <br/>	
		
		[HttpSession 를 이용해서 찾기] <br/>
		데이터1 : <%=(String)session.getAttribute("CCC") %> <br/>
		데이터2 : <%=(String)session.getAttribute("DDD") %> <br/> <br/>
		
		[EL 을 이용해서 찾기] <br/>
		데이터1 : ${data1} <br/>				
		데이터2 : ${data2} <br/> <br/>
		
		[객체의 속성(필드) 값 얻기] <br/>		
		<% Board board = (Board) request.getAttribute("board"); %> 	<br/>			
		<% if(board != null) { %>
				번호 : <%=board.getBno()%> <br/>			
				제목 : <%=board.getTitle()%> <br/>
				내용 : <%=board.getContent()%>	<br/>
				조회수 : <%=board.getHitcount()%>	<br/> 
		<% } %>		

		<br/>
		
		[컬렉션 이용하기] <br/>		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px; "> 				
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black;">번호</td> 
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">내용</td> 
				<td style="border: 1px solid black;">조회수</td>
			</tr>					
			
			<c:forEach var="b" items='${boardList}'> 	
				<tr> 				
					<td style="border: 1px solid black;">${b.bno}</td>			
					<td style="border: 1px solid black;">${b.title}</td>
					<td style="border: 1px solid black;">${b.content}</td> 
					<td style="border: 1px solid black;">${b.hitcount}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
