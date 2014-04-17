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
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

</head>
    <body>
    <br>
    <div class="col-sm-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">User information</h3>
            </div>
            <div class="panel-body">
                <tbody>
                    <tr>
                        <td >name : </td> <td>${username}</td>
                    </tr>
                    <tr>
                        <td >password : </td> <td>${pass}</td>
                    </tr>
                    <tr>
                        <td >Message : </td> <td>${message}</td>
                    </tr>
                    <tr>
                        <td >
                            <security:authorize ifAnyGranted="ROLE_ADMIN">
                            <a href="<c:url value="/add_user" />" > add new user</a>
                        </td>
                        <td></security:authorize>
                            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                        </td>
                    </tr>
                  </tbody>

             </div>
            </div>
        </div>
    </body>
</html>