<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		게시물 쓰기
		<hr/>
		<form method="post" action="/myapp/exam04/write">
			제목 : <input type="text" name="btitle"/> <br/>
			내용 : <textarea rows="5" cols="20" name="bcontent"></textarea> <br/>		<%-- textarea - 여러줄작성.  rows 행 cols 문자열의 길이 --%>
			<input type="submit" value="글쓰기"/>			
		</form>
	</body>
</html>