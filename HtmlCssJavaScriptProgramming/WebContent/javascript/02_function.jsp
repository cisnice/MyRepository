<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<script type="text/javascript">			/* <head> 영역에 script 는 선언문 */
			function sum(from, to) {
				var sum = 0;
				for(var i=from; i<=to; i++) {
					sum += i;
				}
				return sum;
			}
		</script>
	</head>
	
	<body>
		함수 선언
		<hr/>
		
		<script type="text/javascript">			/* <body> 영역에 script 는 실행문 */
			console.log( "1부터 10까지의 합 : " + sum(1, 10) ); 	
		</script>
				
	</body>
</html>
