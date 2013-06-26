<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>Items</title></head>
<body>
<br>
<h3>print</h3>
<h1><c:out value="${items}"></c:out></h1>
<br>
  <h3>Items:</h3>
  <c:forEach var="item" items="${items}">
	<div>id = ${item.id}; name= ${item.noteName}, text= ${item.text} </div>
  </c:forEach>
</body>
</html>