<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<style type="text/css">		 
			/* * { color: red }		*/							/* * => 모든 태그. color => 글자 색  */ 	
			
			div { background-color: yellow; }		/* 모든 div 의 배경색 지정 */
			#div2 { background-color: aqua; } 		/* # => id가 div2 인 객체의 배경색 지정 */
			.div3 { background-color: green; }		/* . => class 이름이 div3 인 객체의 배경색 지정 */
																/* id > class > default 우선순위. id, class 둘다 지정되어 있으면 id의 영향을 받는다. */
			
			#div4, #p1, #h1 { background-color: orange; }		/* 여러 태그를 함께 선언 할 때는 (,) 로 구분 */
			
			#div5 p { background-color: blue; }				/* div5 안에있는 모든 p 태그  */
			#div6 > p { background-color: fuchsia; }		/* div6 의 바로 밑에 있는 태그 */
			#div7 + p { background-color: maroon; }		/* div7 다음 나오는 태그 */
			
			[checked] { color: green; }							/* [] => []안에 있는 모든 속성들. checked 를 가진 모든 속성들에 적용 */
			[selected=true] { color: green; }					/* selected=true 인 속성들에 적용 */
			#form1 [checked] { background-color: green; }		/* id가 form1 인 객체중 checked 가 있는 태그 */
			
			a{ color: black; text-decoration: none; }		/* 링크의 장식 */
			a:active { color: red; }								/* 클릭했을 때  */	
			a:link { color: green; }								/* 방문하지 않은 링크 */
			a:hover { color: blue;  text-decoration: underline;}			/* 마우스를 올려 놓았을 때 옵션 설정, 색, 밑줄 */
			
		</style>		
	</head>
	
	<body>
		CSS 선택자
		<hr/>
		<div>A</div>
		<div id="div2" class="div3">B</div>			<!-- id 가 중복되어 선언될 수 없다.  -->
		<div class="div3">C</div>						<!-- class 는 중복되어 선언될 수 있다. -->
		<div class="div3">D</div>
		
		<br/>
		
		<div id="div4">E</div>
		<p id="p1">F</p>									<!-- p 태그는 기본 공백이 있다. -->
		<h3 id="h1">G</h3>
		
		<br/>
		
		<div id="div5">
			<p>A</p>
			<p>A</p>
		</div>
		
		<div id="div6">
			<div><p>A</p></div>
			<p>A</p>
		</div>
		
		<div id="div7"></div>
		<p>A</p>
		<p>B</p>
		
		<div>
			<div checked="true"> A </div>
			<div checked="false"> B </div>
			
			<div selected="false"> C </div>
			<div selected="true"> D </div>
			<div selected="true"> E </div>
		</div>
		
		<form id="form1">
			<div checked="true"> A </div>
			<div checked="false"> B </div>
		</form>
		
		<div style="background-color: white">				<!-- inline style -->
			<a href="http://www.naver.com">네이버</a><br/>
			<a href="http://tomcat.apache.org">톰캣</a><br/>
			<a href="http://www.w3c.org">w3c</a><br/>
		</div>
		
		
		
	</body>
</html>