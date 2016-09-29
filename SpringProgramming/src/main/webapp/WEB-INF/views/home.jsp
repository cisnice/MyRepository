<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>	
	<body>
		SpringProgramming
		<hr/>					<!-- 수평선. <hr></hr> 안에 내용이 없을 경우 <hr/> -->
		<!-- 1. <a href="http://localhost:8080/myapp/exam01/join">컨트롤러 및 요청 매핑 메소드 작성</a> <br/>			<a></a> 클릭 할 수 있게 하는 테그. 절대경로. 외부 웹서버에 접속할때 -->
		1. <a href="/myapp/exam01/index">Exam01</a> : 컨트롤러 및 요청 매핑 메소드 작성 <br/>										<!-- <br/> 개행 테그. /~ 는 포트번호까지는 똑같다. 절대경로 -->
		<!-- 3. <a href="exam01/join">컨트롤러 및 요청 매핑 메소드 작성</a> <br/>													포트번호까지 없다면 home에 이어 추가적으로 붙이는 주소. 상대경로 -->
	</body>
</html>
