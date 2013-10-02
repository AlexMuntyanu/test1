<%--
  Created by IntelliJ IDEA.
  User: aleksanderm
  Date: 9/23/13
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
    <title>secur page</title>

</head>
    <body>
        <h1>name : ${username}</h1>
        <br>
        <h1>password : ${pass}</h1>
        <br>
        <h1>Message : ${message}</h1>
        <br>
        <security:authorize ifAnyGranted="ROLE_ADMIN">
            <a href="<c:url value="/add_user" />" > add new user</a>
            <br>
        </security:authorize>
        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
    </body>
</html>