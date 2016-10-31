<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">	
		<!-- External Style Sheet -->												<!-- 다른 jsp와도 연결 가능. 재사용 가능 -->
		<link rel="stylesheet" type="text/css" href="05_style.css" >	<!-- 05_style.css 와 text/css type 으로 연결 -->
																							
		<!-- Internal Style Sheet -->		<!-- 현재 jsp 에서만 사용 가능. -->
		<style type="text/css">
			.menu {
				background-color: #ffffff;				
			}
			.menu li {
				color: orange;
			}
		</style>
	</head>
	
	<body>
		CSS Location
		<hr/>
		
		<header>제목</header>
		<p>내용</p>
		
		<a href="http://tomcat.apache.org">톰캣</a>
		
		<div class="menu">
			<ul>
				<li>menu1</li>
				<li>menu2</li>
				<li>menu3</li>
			</ul>
		</div>
		
		<div style="background-color: yellow; text-align: center;">		<!-- 단점 : 재사용 불가 -->
			본문 내용입니다.
		</div>
		
	</body>
</html>