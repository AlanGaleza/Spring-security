<%--
  Created by IntelliJ IDEA.
  User: Alan
  Date: 01.08.2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>luv2code Company Home Page</title>
</head>

<body>
    <h2>luv2code Company Home Page</h2>
    <hr>
    <p>
        Welcome to the luv2code company home page!
    </p>
    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>

</body>

</html>
