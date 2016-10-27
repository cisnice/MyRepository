<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<style type="text/css">
			a {
				text-decoration: none;
				color: black;				
			}
			a:HOVER {			/* a 테그위에 마우스가 올라갔을때 */
				color: green;
			}
		</style>
	</head>
	
	<body>
		자유 게시판
		<hr/>
		<c:if test="${login != null}">
			<a href="write">[글쓰기]</a>
		</c:if>
		
		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px; "> 				
			<tr style="background-color: #ffcc00">				
				<td style="border: 1px solid black;">번호</td> 
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">글쓴이</td>
				<td style="border: 1px solid black;">조회수</td>
				<td style="border: 1px solid black;">날짜</td>				
			</tr>
			
			<c:forEach var="freeboard" items="${list}"> 		<!-- b객체, for문을 EL로 표현. boardList 가 null 이면 forEach 실행 안함 -->
				<tr>															<%-- ${boardList} 에 있는 board 객체 수만큼 for 문을 돈다. --%>
					<td style="border: 1px solid black;">${freeboard.bno}</td>			<!-- getter 메소드 출력 -->
					<td style="border: 1px solid black;">
						<a href="info?bno=${freeboard.bno}">
						${freeboard.btitle}
						</a>
					</td> 
					<td style="border: 1px solid black;">${freeboard.bwriter}</td>
					<td style="border: 1px solid black;">${freeboard.bhitcount}</td>
					<td style="border: 1px solid black;">${freeboard.bdate}</td>
				</tr>
			</c:forEach>
		</table>
		
<!-- 		<a href="#" >1&nbsp;</a>			&nbsp; 스페이스바
		<a href="#" >2&nbsp;</a>
		<a href="#" style="color:red">3&nbsp;</a>
		<a href="#" >4&nbsp;</a>
		<a href="#" >5&nbsp;</a> -->
		
		
		<div style="width:600px">
			<a href="list?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-1}">[이전]</a>				<!-- 1,2,3,4,5 (Group1), 6,7,8,9,10 (Group2), 11,12,13,14,15 (Group3)  pagesPerGroup -->
			</c:if>     
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">		<!-- begin 1 ~ end 5  그룹당페이지수(pagesPerGroup) 5 -->
				<a href="list?pageNo=${i}" 
					<c:if test="${pageNo==i}">style="color:red"</c:if>
				>${i}</a>
				&nbsp;
			</c:forEach>
			
			<c:if test="${groupNo < totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>			
		</div>
	</body>
</html>
