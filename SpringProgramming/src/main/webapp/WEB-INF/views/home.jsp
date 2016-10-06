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
		1. <a href="/myapp/exam01/index">Exam01</a> : 컨트롤러 및 요청 매핑 메소드 작성 <br/>								<!-- <br/> 개행 테그. /~ 는 포트번호까지는 똑같다. 절대경로 -->
		<!-- 3. <a href="exam01/join">컨트롤러 및 요청 매핑 메소드 작성</a> <br/>													포트번호까지 없다면 home에 이어 추가적으로 붙이는 주소. 상대경로 -->
		
		2. <a href="/myapp/exam02/index">Exam02</a> : 요청 파라미터 값 받기 <br/>
		3. <a href="/myapp/exam03/index">Exam03</a> : 폼 입력 값 받기 <br/>
		4. <a href="/myapp/exam04/index">Exam04</a> : 요청 방식별 처리 <br/>								<!-- postman Launcher 앱 추가해서 테스트  -->
		5. <a href="/myapp/exam05/index">Exam05</a> : 요청 처리 메소드의 리턴 타입 <br/>	
		6. <a href="/myapp/exam06/index">Exam06</a> : 요청 처리 메소드의 매개 변수 타입 <br/>
		7. <a href="/myapp/exam07/index">Exam07</a> : 컨트롤러에서 JSP로 데이터 객체 전달 <br/>
		8. <a href="/myapp/exam08/index">Exam08</a> : 리다이렉트 <br/>
		
		<br/>
		
		9. <a href="/myapp/exam09/index">Exam09</a> : 의존성 주입(DI - Dependency Injection) <br/>
	</body>
</html>
