<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 12.04.2018
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <link href="css/dataChange.css" rel="stylesheet" type="text/css">
    <title>YourFavoriteMovies</title>
</head>
<body>

<jsp:include page="headerMainPage.jsp"/>
<jsp:include page="leftsideMainPage.jsp"/>


<h2 style="align-content: center;">${requestScope.director.getName()} </h2>

<div style="width: 600px; float: left">

    <ul style="column-count: 2; list-style-type: none">
    <c:forEach var="movie" items="${requestScope.director.getMovies()}">

        <li> <p><a href="dispatcher?title=${movie.getTitle()}&command=To descriptionMoviePage">${movie.getTitle()}</a></p></li>

    </c:forEach>
    </ul>

</div>

<div style="width: 350px; float: left">
    <img src="dispatcher?path=${requestScope.director.getImage()}&command=Display file" width="270" height="350">
    <br><strong> Name: </strong> ${requestScope.director.getName()}
    <br><strong>Day of birth:</strong> ${requestScope.director.getDayOfBirth()}
</div>



</body>
</html>
