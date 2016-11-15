<%@ page contentType="application/json;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

[
<c:forEach var="restaurant" items="${list}" varStatus="status">
		{
			"image" : "${restaurant.image}",
			"imageLarge" : "${restaurant.imageLarge}",
			"title" : "${restaurant.title}",
			"price" : "${restaurant.price}",
			"content" : "${restaurant.content}"
		}
		<c:if test="${!status.last}">,</c:if>	 
		
</c:forEach>
]

