<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		게시물 목록
		<hr/>
		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px; "> 				
			<tr style="background-color: #ffcc00">				
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">내용</td> 
				<td style="border: 1px solid black;">글쓴이</td>
			</tr>
			
			<c:forEach var="board" items='${boardList}'> 		<!-- b객체, for문을 EL로 표현. boardList 가 null 이면 forEach 실행 안함 -->
				<tr>															<%-- ${boardList} 에 있는 board 객체 수만큼 for 문을 돈다. --%>
					<td style="border: 1px solid black;">${board.btitle}</td>			
					<td style="border: 1px solid black;">${board.bcontent}</td> 
					<td style="border: 1px solid black;">${board.bwriter}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>