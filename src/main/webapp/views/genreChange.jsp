
<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 25.03.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<link href="../css/dataChange.css" rel="stylesheet" type="text/css">
<link href="../../css/mainStyle.css" rel="stylesheet" type="text/css">
<html>

<title>YourFavoriteMovies</title>


<body>
<jsp:include page="../WEB-INF/jspf/headerDataChange.jsp"/>
<jsp:include page="../WEB-INF/jspf/leftSideDataChange.jsp"/>

<div class="rightForm">
    <div>
        <p> Fill out this form, if yot want to add new genre </p>
        <form method="post" action="/dispatcher">
            <input type="text" placeholder="Genre" name="type" size="20">
            <input type="submit" name="command" value="Create genre">
        </form>
    </div>

    <div>
        <p>Fill out this form, if yot want to delete genre</p>
        <form method="post" action="/dispatcher">
            <input type="text" placeholder="Genre" name="type" size="20">
            <input type="submit" name="command" value="Remove genre">
        </form>
    </div>

</div>

</body>

</html>
