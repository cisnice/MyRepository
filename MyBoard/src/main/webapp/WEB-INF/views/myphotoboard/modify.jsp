<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		글수정
		<hr/>
		<form method="post" enctype="multipart/form-data">
			<input type="hidden" name="bno" value="${myphotoboard.bno}"/>	<!-- hidden type 은 사용자의 눈에 보이지는 않지만 서버에 전송해 준다.  -->
			<table>
				<tr>
					<td style="background-color:orange; width:70px"> 제목 </td>
				 	<td><input type="text" name="btitle" style="width:600px" value="${myphotoboard.btitle}"></td>
				</tr>
				
				<tr>
					<td style="background-color:orange; width:70px"> 내용 </td>
				 	<td><textarea name="bcontent" style="width:600px; height:200px;">${myphotoboard.bcontent}</textarea></td>
				</tr>
				
				<tr>
					<td style="background-color:orange; width:70px"> 사진 </td>
				 	<td><input type="file" name="photo"/></td>
				</tr>
			</table>
			<input type="submit" value="글수정"/>
		</form>
	</body>
</html>
