<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<script type="text/javascript">
		
			function changeImg1() {
				var img1 = document.querySelector("#img1");
				img1.src ="../common/image/photo1.jpg" ;
			}
			
			/* window.onload = function() {			// window(브라우저)에서 load 이벤트가 실행 됬을때 function 실행 
				console.log("window.onload");
			}; */
			
			/* function fun1() {
				console.log("window.onload");
			}
			
			window.onload = fun1; */    /* fun1() 을 붙이면 함수를 실행한 후 결과 값을 window.onload 에 대입한다. */
													/* window.onload 자체가 fun1 함수를 실행하라는 명령어이므로 () 를 빼준다.  */
													
			function changeImg2() {
				var img2 = document.querySelector("#img2");
				img2.src ="../common/image/photo2.jpg" ;
			}		
			
			function changeImg3() {
				var img3 = document.querySelector("#img3");
				img3.src ="../common/image/photo3.jpg" ;
			}	
			
			window.onload = function() {								// onload 이벤트는 jsp 내에 있는 모든 내용이 DOM 객체로 만들어진 후 실행 된다.                
				var btn2 = document.querySelector("#btn2");		// null 값 에러. 버튼2가 먼저 실행 된 후에 클릭할때 실행 되어야한다.
				btn2.onclick = changeImg2;	
				
				var btn3 = document.querySelector("#btn3");
				/* btn3.addEventListener("click", function() {			// Event Handler. 이벤트가 발생할 때 실행되는 함수
					var img3 = document.querySelector("#img3");
					img3.src="../common/image/photo3.jpg";
				} );	 */
				btn3.addEventListener("click", changeImg3);
			};
			
			/* 
			function init() {		// onload 를 사용하지 않고 body에 onload 를 선언하고 init() 함수를 호출해도 window.load와 같은 결과를 준다.			
				var btn2 = document.querySelector("#btn2");
				btn2.onclick = changeImg2;
			}
			*/
			
		</script>
	</head>
	
	<!-- <body onload="init()"> -->
	<body>
		Event 처리
		<hr/>
		
		<h3>[how1] </h3>
		<button onclick="changeImg1()">버튼1</button>
		<img id="img1" src="" width="100px" />
		
		<h3>[how2] </h3>
		<button id="btn2" onclick="btn2">버튼2</button>
		<img id="img2" src="" width="100px" />
		
		<h3>[how3] </h3>
		<button id="btn3" onclick="btn3">버튼3</button>
		<img id="img3" src="" width="100px" />
				
	</body>
</html>
