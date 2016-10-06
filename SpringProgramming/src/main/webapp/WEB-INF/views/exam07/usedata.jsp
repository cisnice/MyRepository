<%@ page contentType="text/html;charset=UTF-8"%>					<%-- <%@ %> 지시자를 사용하겠다. 여기서는 page --%>
<%@ page import="com.mycompany.myapp.exam07.Board" %>	<%-- Board 클래스의 전체 경로 --%>
<%-- <%@ page contentType="text/html;charset=UTF-8" import="com.mycompany.myapp.exam07.Board"%> 붙여서 써도 무방 --%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		<%-- html 이외의 테그 사용시 명시. JSTL(Java Standard Tag Library) --%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		데이터 찾기	<%-- jsp 파일은 톰캣이 java 파일로 변환시켜 컴파일 한다. C:/Users/Administrator/workspace/.metadata 에서 usedata_jsp.java 검색하면 변환되어 있는 자바파일을 확인 할 수 있다. --%>
		<hr/>     		<%-- jsp 에서 변수 선언없이 사용 가능한 변수들 request, response, session..... usedata_jsp.java에 정의되어 있다. --%>					
		[HttpServletRequest 를 이용해서 찾기] <br/>
		데이터1 : <%=(String)request.getAttribute("data1") %> <br/>			<%-- 표현식. request 안에서 data1 을 찾아서 <%= ~~ %> 에 넣어준다. 값 출력 --%>
		데이터2 : <%=(String)request.getAttribute("data2") %> <br/> <br/>	
		
		[HttpSession 를 이용해서 찾기] <br/>
		데이터1 : <%=(String)session.getAttribute("data1") %> <br/>
		데이터2 : <%=(String)session.getAttribute("data2") %> <br/> <br/>
		
		[EL 을 이용해서 찾기] <br/>
		데이터1 : ${data1} <br/>				<%-- request 에서 먼저 찾고 없으면 session 에서 찾는다. 둘 중에 한곳에만 저장되어 있으면 된다. request 가 우선순위 --%>
		데이터2 : ${data2} <br/> <br/>
		
		[객체의 속성(필드) 값 얻기] <br/>		
		<% Board board = (Board) request.getAttribute("board"); %> 	<br/>			<%-- <% %> 안의 자바코드를 실행해라 --%>
		<% if(board != null) { %>
				번호 : <%=board.getBno()%> <br/>			
				제목 : <%=board.getTitle()%> <br/>
				내용 : <%=board.getContent()%>	<br/>
				조회수 : <%=board.getHitcount()%>	<br/> 
		<% } %>		
		<%--  
		번호 : ${board.bno}	<br/>			<!-- EL 내부에서 "." 은 getter 메소드 호출. board.getBno() -->
		제목 : ${board.title}	<br/>
		내용 : ${board.content}	<br/>
		조회수 : ${board.hitcount}	<br/> <br/>
		--%>
		
		<br/>
		
		[컬렉션 이용하기] <br/>		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px; "> 				
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black;">번호</td> 
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">내용</td> 
				<td style="border: 1px solid black;">조회수</td>
			</tr>					
			
			<%-- <% List<Board> list = (List<Board>)request.getAttribute("boardList"); %>	
			<%if(list != null) { %>
	 			<% for(Board b : list) { %>
	 				<tr> 				
						<td style="border: 1px solid black;"><%=b.getBno()%></td>			
						<td style="border: 1px solid black;"><%=b.getTitle()%></td>
						<td style="border: 1px solid black;"><%=b.getContent()%></td> 
						<td style="border: 1px solid black;"><%=b.getHitcount()%></td>
					</tr>
				<% } %> 
			<% } %>	 --%>
			
			<c:forEach var="b" items='${boardList}'> 	<!-- b객체, for문을 EL로 표현. boardList 가 null 이면 forEach 실행 안함 -->
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
