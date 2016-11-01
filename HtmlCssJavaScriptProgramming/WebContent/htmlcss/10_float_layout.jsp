<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">	
		<style>
			* {
				margin: 0px;
				padding: 0px;
			}
			
			div.container {
				/* background-color: orange; */
				width: 100%;		/* width 가 100% 이면 container 의 부모인 body 의 전체 폭을 사용한다. */
				/* margin: auto; */
				border: 1px solid gray;
			}
			
			header, footer {
				padding: 1em;    /* 16 px */
				color: white;
				background-color: black;
				text-align: center;				
			}
			
			footer {
				clear: both;					/* nav 가 float 이라 공중에 떠 있기 때문에 내용이 길어지면 footer 밑으로 내려가게 된다. */
			}									/* 이것을 방지하기 위해 footer를 clear하면 nav의 끝에 footer가 오게된다.  */
			
			nav {
				float: left;
				/* max-width: 160px; */		/* max-width - 최대 160px. 줄어들수는 있다. */
				margin: 0px;
				padding: 1em;
				background-color: orange;
				width: 300px;
			}
			
			nav ul {
				list-style-type: none;
				padding: 0;
			}
			
			nav ul a{
				text-decoration: none;
			}
			
			article {
				margin-left: 170px;
				padding: 1em;
				overflow: hidden;			/* article 내에 스크롤바 나오지 않게 */
			}
		</style>	
	</head>
	
	<body> 
		<!--float 속성을 이용한 Layout
		<hr/> -->
		<div class="container">

			<header>
			   <h1>City Gallery</h1>
			</header>
			  
			<nav>
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
			</nav>
			
			<article>
				<h1>London</h1>
			  	<p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
				<p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
			</article>
			
			<footer>Copyright © W3Schools.com</footer>
		
		</div>
		
	</body>
</html>