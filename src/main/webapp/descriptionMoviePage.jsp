<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 07.04.2018
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>YourFavoriteMovies</title>
</head>
<body>
<jsp:include page="headerMainPage.jsp"/>
<jsp:include page="leftsideMainPage.jsp"/>

<div style="width: 600px; float: left">

    <h2 style="align-content: center; margin-top: 0; margin-bottom: 0">${requestScope.movie.getTitle()} </h2>

    <br><strong>Director: </strong><a href="dispatcher?name=${requestScope.movie.getDirector().getName()}&command=To directorPage">${requestScope.movie.getDirector().getName()}</a>
    <br><strong>Genres: </strong><c:forEach var="genre"
                                            items="${requestScope.movie.getGenres()}"
                                            varStatus="counter">${genre.getTypeOfGenre()}
    <c:if test="${!counter.last}">, </c:if>
</c:forEach>
    <br><strong>Runtime: </strong>${requestScope.movie.getRuntime()}
    <object data="dispatcher?path=${requestScope.movie.getDescription()}&command=Display file" type="application/pdf" width="550" height="300">
    </object>

</div>
<div style="width: 350px; float: left">
    <img src="dispatcher?path=${requestScope.movie.getImage()}&command=Display file" width="300" height="400">
</div>


</body>
</html>
