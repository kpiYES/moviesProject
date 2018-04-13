<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 12.04.2018
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<p>
    <c:out value="${requestScope.errMsg}"/>
</p>

</body>
</html>
