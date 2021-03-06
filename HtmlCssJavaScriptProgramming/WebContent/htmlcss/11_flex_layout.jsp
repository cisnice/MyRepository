<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<style>
			/* #container {
				display: flex;
				flex-direction: column;
				width: 600px;
				height: 300px;
				background-color: aqua;
			}
			*/
			 
			/* #header {
				background: red; */
				/* flex: 1; */						/* 부모의 width에 맞게 분할하여 비율을 맞춘다. header : content : footer = 1 : 1 : 1 */         		
				/* height: 100px;
			}  */
			
		/* 	#content {
				background: green;
				flex: 1;
			} */
			
			/* #footer {
				background: blue; */
				/* flex: 1; */
				/* height: 30px;	 */				/* 고정 크기를 먼저 주고 남은 부분을 flex 에서 나눈다. */
			/* } */
			 
			 
			* {
				margin: 0px;
				padding: 0px;
			}  
			
			#container {
				width: 100%;
				border: 1px solid gray;
				display: flex;
				flex-direction: column;
				/* height: 500px; */
				height: 97vh;			/* 브라우저의 끝까지  */
			}
			
			#header, #footer {
				padding: 1em;
				color: white;
				background-color: black;
				text-align: center;
			}
			
			#content {
				flex: 1;
				display: flex;
			}
			
			#content #menu {				
				background-color: orange;	
				width: 150px;
				padding: 1em;				
			}
			
			#content #menu ul {
				list-style-type: none;
				padding: 0;
			}
			
			#content #center {
				flex: 1;
				padding: 1em;
			}
			
		</style>		
	</head>
	
	<body> 
		<!--flex 속성을 이용한 Layout
		<hr/> -->
		<div id="container">
			<div id="header">
				<h1>City Gallery</h1>
			</div>
			<div id="content">
				<div id="menu">
					<ul>
					    <li><a href="#">London</a></li>
					    <li><a href="#">Paris</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
				  	</ul>
				</div>
				<div id="center">
					<h1>London</h1>
				  	<p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
					<p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
				</div>
			</div>
			<div id="footer">Copyright © W3Schools.com</div>
		</div>
		
	</body>
</html>