<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	<body> 
				
		<font size="6"><b>글쓰기</b></font>
		<hr/> 
		
		<table style="width:570px">
			<tr>
				<td style="background-color:orange; width:70px">번호</td>
				<td>${myphotoboard.bno}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70px">제목</td>
				<td>${myphotoboard.btitle}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70px">내용</td>
				<td><pre>${myphotoboard.bcontent}</pre></td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70px">글쓴이</td>
				<td>${myphotoboard.bwriter}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70px">조회수</td>
				<td>${myphotoboard.bhitcount}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70px">날짜</td>
				<td>${myphotoboard.bdate}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:70px">사진</td>
				<td><img src="showPhoto?savedfile=${myphotoboard.savedfile}" width="500px"></td>
			</tr>				
		</table>
		<div>
			<c:if test="${login == myphotoboard.bwriter}" >
				<a href="modify?bno=${myphotoboard.bno}">[수정]</a>
				<a href="remove?bno=${myphotoboard.bno}">[삭제]</a>				
			</c:if>
			<a href="list">[목록]</a>
		</div>				
	</body>
</html>