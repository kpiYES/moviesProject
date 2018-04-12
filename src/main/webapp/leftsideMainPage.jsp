<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 20.03.2018
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="css/mainStyle.css" rel="stylesheet" type="text/css">
    <title>YourFavoriteMovies</title>
</head>

<body>



<div style="width: 300px; float: left">
    <h4> Genres </h4>


    <ul>
        <jsp:useBean id="genreService" class="com.app.service.impl.GenreServiceImpl" type="com.app.service.GenreService"
                     scope="request"/>
        <c:forEach var="genre" items="${genreService.all}">

            <li>
                    <a href="dispatcher?typeOfGenre=${genre.typeOfGenre}&command=To mainMoviePage"  >${genre.typeOfGenre}</a>
            </li>
        </c:forEach>

    </ul>


</div>

</body>
</html>
