<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <style>
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #232323;
            padding: 8px;
            margin: 16px;
        }
    </style>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">



</head>
<body onload='document.f.j_username.focus();'>
<h3>Custom Login Page</h3>

<c:if test="${not empty error}">
    <div class="errorblock">
        Error occurred. <br /> Caused by:
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>

<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>



    <div class="row">
        <div class ="col-xs-4 col-md-offset-2" style="box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            <p>
            <table class="table span2 center-table">
                <caption>Please login</caption>
                <tr>
                    <td>Username:</td>
                    <td><input class="form-control" type='text' name='j_username' value=''>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="form-control" type='password' name='j_password' />
                    </td>
                </tr>
                <tr>
                    <td ><button name="submit" class="btn btn-success" type="submit" name="submit" >Login</button></td>
                    <td ><button name="reset" class="btn btn-danger pull-right" type="reset">Reset</button></td>
                </tr>

            </table>
            </p>
        </div>
    </div>
</form>
<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>