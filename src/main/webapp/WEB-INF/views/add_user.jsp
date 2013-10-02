<%--
  Created by IntelliJ IDEA.
  User: aleksanderm
  Date: 10/2/13
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add new user page</title>
</head>
<body>

<form action="/add_user" method="POST">
    <input type="text" name="userName"/> User Name
    <br>
    <input type="password" name="password"/> Password
    <br>
    <input type="checkbox" name="adminRole" /> Role admin
    <br>
    <input type="checkbox" name="userRole" /> Role user
    <br>
    <input type="submit" value="Select Subject"/>
</form>
</body>
</html>