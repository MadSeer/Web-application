<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/create" method="POST">
    <table>
    <tr>
        <td align="right"> Login : </td>
        <td>
            <input type="text" name="login"/>  <%-- поле ввода текста с именем login --%>
        </td>
    </tr>
    <tr>
        <td align="right"> Password : </td>
        <td>
            <input type="text" name="password"/>  <%-- поле ввода текста с именем password --%>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" align="center" value="Submit"/>  <%--  при нажатии на кнопку с названием Submit
                                                                    отправляем запрос на сервлет с URI /create
                                                                    по методу POST.
                                                                    При этом в запрос в качестве параметров
                                                                    передаются login и password (в виде пар ключ-значение)--%>
        </td>
    </tr>
    </table>
</form>

</body>
</html>
