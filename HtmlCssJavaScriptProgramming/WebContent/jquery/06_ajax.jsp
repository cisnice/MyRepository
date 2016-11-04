<%@ page contentType="text/html;charset=UTF-8"%> 

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			
			$( function() {
				$("#btn1").on("click", function() {
					$.ajax({									// $ 객체의 ajax() 메소드
						url : "06_data1.jsp",				
						success : function(data) {		// data - 특정한 부분에 들어가는 HTML 조각, success - data가 서버로부터 리턴된다.
							console.log(data);
							$("#div1").html(data);						
						}
					});						
				} );
			} )
			
			function checkMid() {
				var mid = $("#mid").val();				
				$.ajax({
					url : "06_data2.jsp",
					//data : "mid=" + mid,
					data : {"mid" : mid},
					success : function(data) {
						if(data.trim() == "true") {
							$("#btn2Result").html("사용할 수 있음");
						} else {
							$("#btn2Result").html("사용할 수 없음");
						}
					}
				});
			}
			
			function getAd(kind, keyword) {
				$.ajax({
					url : "06_data3.jsp",
					data : {"kind":kind, "keyword":keyword},
					success : function(data) {							// 1) HTML 조각  2) XML  3) JSON
						$("#div3").html(data);	
					}					
				})
			}
			
			function getJson() {
				$.ajax({
					url : "06_data4.jsp",					
					success : function(data) {					// data 에 JSON 이 들어온다	
						
						var html = "";
						html += '<table>';
						html += '<tr>';
						html += 	'<td>';	
						for(var i=0; i<data.length; i++) {						
							html += 		'<div style="width:120px; height:130px; margin:5px; display:inline-block; background-image: url(' + data[i].aimg + ');  background-size: 120px 130px;">';										
							html += 			'<div>';
							html += 				'<table style="width:100%; height:30px; background-color: black; opacity: 0.7">';
							html += 					'<tr>';
							html += 						'<td style="text-align:left; color:white;">' + data[i].alocation + '</td>';
							html += 						'<td style="text-align:right; color:aqua;">' + data[i].ahitcount + '</td>';
							html += 					'</tr>';
							html += 				'</table>';
							html += 			'</div>';							
							html += 		'</div>';				
						}
						html += 	'</td>';
						html += '</tr>';	
						html += '</table>';
						
						$("#div4").html(html);
					}					
				});
			}
			
		</script>		
	</head>
	
	<body>
		AJAX 통신
		<hr/>
		
		<button id="btn1">버튼1</button>
		<div id="div1" style="height:100px; border:1px solid black"></div>
		
		<br/><br/>
		
		<button id="btn2" onclick="checkMid()">아이디 중복 체크</button>
		<input id="mid" type="text" name="mid"/>
		<span id="btn2Result"></span>
		
		<br/><br/>
		
		<button id="btn3" onclick="getAd('book', 'java')">광고 정보 얻기</button>		<!-- java 관련된 책을 가져온다. -->
		<div id="div3"></div>
		
		<br/><br/>
			
		<button id="btn4" onclick="getJson()">JSON 응답 이용</button>		
		<div id="div4"></div>
		
	</body>
</html>
