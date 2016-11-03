<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<script type="text/javascript">
			function checkLoginForm() {
				/* console.log("checkLoginForm");		// id와 password 가 입력되지 않아서 서버에 전송이 된다. 
				return false;								// 전송되지 않게 하기 위해 return 을 false로 주고 onsubmit 에도 return을 준다. */
				
				var mid = document.querySelector("#mid").value;
				var mpassword = document.querySelector("#mpassword").value;
				
				if (mid=="" || mpassword=="") {
					alert("아이디 또는 패스워드가 입력되지 않았습니다.");
					return false;
				} else if (mid.length < 4 || mid.length > 10) {
					alert("아이디의 길이가 맞지 않습니다.");
					return false;
				} else if (mpassword.length < 4 || mpassword.length > 10) {
					alert("패스워드의 길이가 맞지 않습니다.");
					return false;
				}
				return true;
			}
		</script>
	</head>
	
	<body>
		유효성 검사(입력값 검사)
		<hr/>
		<form id="loginForm" onsubmit="return checkLoginForm()">
			아이디 : <input type="text" name="mid" /><br/>
			비밀번호 : <input type="password" name="mpassword" /><br/>
			<input type="submit" value="로그인" />
		</form>

				
	</body>
</html>