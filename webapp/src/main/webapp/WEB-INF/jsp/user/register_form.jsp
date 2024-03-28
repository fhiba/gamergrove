<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: juani
  Date: 3/28/2024
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<c:url value="/register" var="registerUrl" />
<form action="${registerUrl}" method="post">
    <div>
        <label>Username:</label>
        <input name="username" placeholder="username"/>
    </div>
    <div>
        <input type="submit" value="Register!"/>
    </div>
</form>
</body>
</html>
