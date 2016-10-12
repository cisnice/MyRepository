<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>	
	<body>		
		[회원 가입 폼] <br/>
		<form method="post" action="/myspring/exam11/join">				
			아이디 : <input type="text" name="mid" value="fall"/> <br/>
			이름 : <input type="text" name="mname" value="한가을"/> <br/>
			비밀번호 : <input type="password" name="mpassword" value="12345"/> <br/>
			이메일 : <input type="email" name="memail" value="fall@naver.com"/> <br/>
			전화번호 : <input type="tel" name="mtel" value="010-1234-1234"/> <br/>
			직업 : <input type="radio" name="mjob" value="대학생">대학생
					  <input type="radio" name="mjob" checked value="회사원">회사원
					  <input type="radio" name="mjob" value="공무원">공무원<br/>
			개발분야 : <input type="checkbox" name="mskill" value="웹">웹개발
				 			<input type="checkbox" name="mskill" value="시스템" checked>시스템개발
							<input type="checkbox" name="mskill" value="빅데이터">빅데이터개발
							<input type="checkbox" name="mskill" value="IoT"/>IoT개발<br/>		
			주소 : <select name="maddress1">
						<option>서울특별시</option>
						<option selected>경기도</option>
						<option>부산광역시</option>
						<option>대구광역시</option>
						<option>제주</option>
				    </select> -
					<select name="maddress2">
						<option>인천시</option>
						<option>수원시</option>
						<option selected>용인시</option>
						<option>부천시</option>
						<option>의왕시</option>
					</select> <br/>
					 
			생년월일 : <input type="date" name="mbirth" value="2016-09-29"/>
			 		
					<br/>

					<input type="image" src="/myapp/resources/image/img.png" width="100"/>  
		</form>
	</body>
</html>
