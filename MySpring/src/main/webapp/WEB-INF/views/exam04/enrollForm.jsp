<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		Exam04
		<hr/>
		[게시물 등록 폼] <br/>
		<form method="post" action="/myspring/exam04/enroll">
			제목 : <input type="text" name=title value="이것이 자바냐"/> <br/>
			내용 : <input type="text" name=content value="글쎄다"/> <br/>
			
			<input type="submit" value="등록"/>
		</form>
		
		
	</body>
</html>