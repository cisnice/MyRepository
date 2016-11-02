<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<script type="text/javascript">
			var v1 = "A";
			
			function fun1() {
				var v2 = "B";
				v3 = "C";						// var 없이 선언되면 함수 안에 있어도 전역변수로 인식한다. 
				console.log("v1 : " + v1);
				console.log("v2 : " + v2);
				console.log("v3 : " + v3);
			}
			
			function fun2() {				
				console.log("v1 : " + v1);
				console.log("v3 : " + v3);
				/* console.log("v2 : " + v2); */	/* v2는 fun1()에서 선언된 지역변수 이므로 사용할 수 없다. */
			}
			
			function fun3() {
				if(true) {
					var v4 = "D";
				}
				console.log("v4 : " + v4);			/* 함수 단위에서만 변수를 선언 할 수 있다. 블록 단위에서 선언된 변수는 함수 안에서 선언된 지역변수로 본다. */
			}
		</script>		
	</head>
	
	<body>
		지역변수와 전역변수
		<hr/>
		
		<script type="text/javascript">
			fun1();
			console.log("------------");
			fun2();
			console.log("------------");
			fun3();
		</script>
				
	</body>
</html>