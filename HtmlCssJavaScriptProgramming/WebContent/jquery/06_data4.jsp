<%@ page contentType="application/json;charset=UTF-8"%>		<%-- json 전송방식  --%>
<%-- { } - 객체, [ ] - 배열 --%>

<%-- 속성 이름은 반드시 "" 로 감싸야한다. 숫자는 그대로 작성, 문자는 "" 로, null(데이터가 없다) 허용--%>
[
	{"ano" : 1, "alocation" : "독일", "ahitcount" : 10, "aimg" : "../common/image/photo1.jpg"}, 		 							
	{"ano" : 2, "alocation" : "독일", "ahitcount" : 7, "aimg" : "../common/image/photo2.jpg"}, 		 			 
	{"ano" : 3, "alocation" : "독일", "ahitcount" : 15, "aimg" : "../common/image/photo3.jpg"}		 			
]

<%-- 
{
	"data1" : [{}, {}, {}],
	"data2" : [{}, {}, {}]
}
객체 안에 배열을 넣고, 배열 안에 객체를 넣고, 중복도 가능하다.
 --%>
 
 
 
 