<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		배열
		<hr/>
		
		<script type="text/javascript">
			var cars = ["Saab", "Volvo", "BMW"];			/* javascript 는 배열을 [] 로 표현한다. java 는 {} */
			console.log(cars[0]);
			console.log(cars[1]);
			console.log(cars[2]);
			
			console.log("----------");
			
			for (var i=0; i<cars.length; i++){
				console.log(cars[i]);
			}
			
			console.log("----------");
			
			var cars2 = new Array("Saab", "Volvo", "BMW");
			cars2.sort();
			
			for (var i=0; i<cars2.length; i++){
				console.log(cars2[i]);
			}
			
			console.log("----------");
			
			var fruits = ["Banana", "Orange", "Apple", "Mango"];			/* javascript는 고정값이 아니라 추가가 가능하다. java에서 List의 기능을 한다. */
			fruits.push("Lemon");  
			fruits[5] = "포도";
			
			for (var i=0; i<fruits.length; i++){
				console.log(fruits[i]);
			}
			
		</script>
				
	</body>
</html>