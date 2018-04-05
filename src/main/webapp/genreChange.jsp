<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 25.03.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link href="css/dataChange.css" rel="stylesheet" type="text/css">
    <link href="css/mainStyle.css" rel="stylesheet" type="text/css">
    <title>YourFavoriteMovies</title>
</head>

<body>
<jsp:include page="headerDataChange.jsp"/>
<jsp:include page="leftSideDataChange.jsp"/>

<div class="rightForm">
    <p><%=request.getAttribute("result")%>
    </p>
    <div>
        <p> Fill out this form, if yot want to add new genre </p>
        <form method="post" action="dispatcher">
            <input type="text" placeholder="Genre" name="type" size="20">
            <input type="submit" name="command" value="Create genre">
        </form>
    </div>

    <div>
        <p>Fill out this form, if yot want to delete genre</p>
        <form method="post" action="dispatcher">
            <input type="text" placeholder="Genre" name="type" size="20">
            <input type="submit" name="command" value="Remove genre">
        </form>
    </div>

</div>

</body>

</html>
