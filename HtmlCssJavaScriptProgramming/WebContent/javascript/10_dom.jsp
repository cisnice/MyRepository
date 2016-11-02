<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<script type="text/javascript">
			function onClickButton1() {
				console.log("onClickButton1() 실행");
				/* var div1 = document.getElementById("div1"); */		//document - 내장된 DOM 객체 안에 있는 div를 찾는다. id 가 매칭되는 하나의 값이 리턴한다.
				var div1 = document.querySelector("#div1");
				console.log(div1);
				div1.innerHTML = "수정 내용";								// div1 안에있는 HTML 을 "수정 내용" 으로 바꾼다.  최초 내용 => 수정 내용
			}
			
			function onClickButton2() {
				/* var imgArr = document.getElementsByTagName("img");					// getElementsByTagName - 여러개의 값을 배열로 리턴한다. */				
				/* var imgArr = document.getElementsByClassName("photo"); */		// getElementsByClassName - 여러개의 값을 배열로 리턴한다. */	
				var imgArr = document.querySelectorAll(".photo");
				imgArr[0].src = "../common/image/photo2.jpg";
			}
			
			function onClickButton3() {
				
				// 입력된 mid와 mpassword 얻기 (how1)
				/* 
				var inputMid = document.querySelector("[name=mid]");				
				var mid = inputMid.value;
				console.log("mid : " + mid);
				
				var inputMpassword = document.querySelector("[name=mpassword]");
				var mpassword = inputMpassword.value;				
				console.log("mpassword : " + mpassword);
				
				var inputMid = document.querySelector("[name=mid]").value;
				console.log("mid : " + inputMid);
				
				var inputMpassword = document.querySelector("[name=mpassword]").value;
				console.log("mpassword : " + inputMpassword); 
				*/
				
				var inputMid = document.querySelector("#form1 [name=mid]").value;
				console.log("mid : " + inputMid);
												
				var inputMpassword = document.querySelector("#form1 [name=mpassword]").value;
				console.log("mpassword : " + inputMpassword);
				
				// 입력된 mid와 mpassword 얻기 (how2)
				mid = document.form1.mid.value;					// name이 form1 인 객체를 찾고 그 안에서 name 이 mid 인 객체를 찾아 대입되는 값을 리턴한다.
				mpassword = document.form1.mpassword.value;
				console.log("mid : " + mid);
				console.log("mpassword : " + mpassword);
				
				// 유효성 검사
				if(mid == "") {							/* 문자열 비교 ==, equals 사용할 수 없다. null 검사는 하지 않는다. */
					alert("아이디를 입력하세요");
				} else if (mpassword == "") {
					alert("비밀번호를 입력하세요");
				}
				
				// 서버 전송
				/*
				var form1 = document.querySelector("#form1");				
				form1.submit();				
				
				document.querySelector("#form1").submit();
				*/
				document.form1.submit();
			}
		</script>
	</head>
	
	<body>
		DOM 사용
		<hr/>
		<button onclick="onClickButton1()">버튼1</button>
		<div id="div1">최초 내용</div>
		
		<button onclick="onClickButton2()">버튼2</button>
		<div>
			<!-- <img src="../common/image/photo1.jpg" width="200"/> -->
			<img class="photo" src="../common/image/photo1.jpg" width="200"/>
		</div>		
		
		<button onclick="onClickButton3()">버튼3</button>
		<div>
			<form id="form1" name="form1">
				아이디 : <input type="text" name="mid"/><br/>
				비밀번호 : <input type="password" name="mpassword"/><br/>
			</form>
			
			<!-- 
			<form id="form2" name="form2">
				아이디 : <input type="text" name="mid"/><br/>
				비밀번호 : <input type="password" name="mpassword"/><br/>
			</form>	 
			-->
				
				
		</div>
		
		
		
		
		
	</body>
</html>





