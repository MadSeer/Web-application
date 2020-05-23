<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/CreateUser.jsp">Add user</a>
<table border="1">
    <tr>
        <td>Login</td>
        <td>Password</td>
    </tr>
    <c:forEach items="${usersAttr}" var="user">
        <tr valign="top">
            <td> ${user.login} </td>
            <td> ${user.password} </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.servletContext.contextPath}/views/LoginUsers.jsp">Enter</a>
</body>
</html>
