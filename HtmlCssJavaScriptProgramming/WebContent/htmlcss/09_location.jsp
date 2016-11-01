<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<style type="text/css">
			#div1 {
				position: absolute;		/* absolute - left, top 만큼 브라우저 좌표(0, 0) 에서 떨어진다. 스크롤에 따라간다. */
				left: 100px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			
			#div2 {				
				width: 100px;				/* static - left, top 의 영향을 받지 않는다. */
				height: 100px;
				background-color: blue;
			}
			
			#div3 {				
				position: fixed;			/* fixed -  left, top 만큼 브라우저 좌표(0, 0) 에서 떨어진다. 스크롤을 움직여도 고정되어있다. */
				left: 300px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: green;
			}
			
			#div4 {				
				position: relative;			/* relative -  left, top 만큼 부모의 좌표(0, 0) 에서 떨어진다. */
				left: 500px;
				top: 100px;
				width: 300px;
				height: 300px;
				border: 1px solid black;
			}
			
			#div5 {	
				position: relative;			
				left: 150px;
				top: 150px;			
				width: 50px;
				height: 50px;
				background-color: orange;
			}
		</style>		
	</head>
	
	<body>
		<!-- location 관련 CSS 속성
		<hr/> -->
		
		<div id="div1"></div>
		<div id="div2"></div>
		<div id="div3"></div>
		<div id="div4">
			<div id="div5"></div>
		</div>
		
		<%for(int i=0; i<30; i++) { %>
			<br/>
		<%} %>
		
	</body>
</html>