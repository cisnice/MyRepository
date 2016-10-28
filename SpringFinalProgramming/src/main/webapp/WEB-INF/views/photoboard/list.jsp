<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
		<style type="text/css">
			* {
				font-family: 돋움;
				font-size: 12px;		
			}
			a {	
				text-decoration: none;
				color: black;
			}
			a:HOVER {				
				color: green;
			}
			
		</style>
	</head>
	
	<body>
		포토 게시판
		<hr/>
		<c:if test="${login != null}">
			<a href="write">[글쓰기]</a>
		</c:if>		
		
		<!-- <table style="width:600px"> -->
		<table>
			<tr>
				<td>
					<c:forEach var="photoBoard" items="${list}">
						<a href="info?bno=${photoBoard.bno}">
							<div style="width:120px; height:130px; margin:5px; display:inline-block; background-image: url(showPhoto?savedfile=${photoBoard.savedfile});  background-size: 120px 130px;">
								<div style="height:100px;">
									<span style="color: white; font-size:12px">${photoBoard.bdate}</span>
								</div>
								<div>
									<table style="width:100%; height:30px; background-color: black; opacity: 0.7">
										<tr>
											<td style="text-align:left; color:white;">${photoBoard.btitle}</td>
											<td style="text-align:right; color:aqua;">${photoBoard.bhitcount}</td>
										</tr>
									</table>
								</div>							
							</div>
						</a>	
					</c:forEach>
				</td>
			</tr>	
		</table>
		
		<div style="width:600px">
			<a href="list?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-1}">[이전]</a>				<!-- 1,2,3,4,5 (Group1), 6,7,8,9,10 (Group2), 11,12,13,14,15 (Group3)  pagesPerGroup -->
			</c:if>     
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">		<!-- begin 1 ~ end 5  그룹당페이지수(pagesPerGroup) 5 -->
				<a href="list?pageNo=${i}" 
					<c:if test="${pageNo==i}">style="color:red"</c:if>
				>${i}</a>
				&nbsp;
			</c:forEach>
			
			<c:if test="${groupNo < totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>			
		</div>
	</body>
</html>
