<%@ page contentType="text/html;charset=UTF-8"%> 
<%-- 1. 파일 저장 인코딩(index.jsp 의 문자셋 지정)   2. HTML 내용이 어떤 문자셋인지 브라우저에 전달. 3bytes  --%>
<!-- <%@ page pageEncoding="EUC-KR" %>  -->
<%-- 1번의 기능만 가지고 있다. 2bytes --%>

<!DOCTYPE html>
<html>		
	<head>	
		<%-- <meta charset="UTF-8"> --%>		
		<%-- 2번의 기능. page contentType 이 선언되어 있다면 작성해 주지 않아도 된다. *.jsp 작성시에는 생략 가능, *.html 작성시에는 필수 --%>
		<title>index</title>
	</head>
	
	<body>
		HTML, CSS, JavaScript <!-- 학습 -->
		<hr/>
		1. <a href="htmlcss/index.jsp">HTML/CSS</a> <br/>
		2. <a href="bootstrap/index.jsp">Bootstrap</a> <br/>
		3. <a href="javascript/index.jsp">JavaScript</a> <br/>
		4. <a href="jquery/index.jsp">jQuery</a> <br/>		
		
	</body>
</html>