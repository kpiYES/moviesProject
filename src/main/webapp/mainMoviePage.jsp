<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 04.04.2018
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/mainStyle.css" rel="stylesheet" type="text/css">
    <title>YourFavoriteMovies</title>
</head>
<body>

<jsp:include page="headerMainPage.jsp"/>
<jsp:include page="leftsideMainPage.jsp"/>


<div style="width: 1000px; float: left">
    <h2 style="text-align: center">
        ${requestScope.typeOfGenre}
    </h2>
        <ul style="column-count: 2; list-style-type: none">
        <c:forEach var="movie" items="${requestScope.movieList}">

                <li style="margin-bottom: 30px">
                <p style="font-size: larger">"${movie.getTitle()}"</p>
                    <img src="dispatcher?path=${movie.getImage()}&command=Display file" width="120" height="140">
                    <br><strong>Directed by </strong>${movie.getDirector().getName()}
                        <p class="reference"><a href="dispatcher?title=${movie.getTitle()}&command=To descriptionMoviePage">
                        Read description</a></p>
                </li>
        </c:forEach>
        </ul>




</div>


</body>
</html>
