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
    <title>YourFavoriteMovies</title>
    <link href="css/mainStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="headerMainPage.jsp"/>
<jsp:include page="leftsideMainPage.jsp"/>


<%--<jsp:useBean id="movieService" class="com.app.service.impl.MovieServiceImpl" type="com.app.service.MovieService"/>--%>
<%--<jsp:useBean id="genre" class="com.app.service.impl.MovieServiceImpl">--%>
<%--<jsp:setProperty name="genre" property="id" value="${param.genre_id}"/>--%>
<%--<jsp:setProperty name="genre" property="typeOfGenre" value="${param.typeOfGenre}"/>--%>

<div>
    <h4>
        <c:out value="${requestScope.typeOfGenre}"/>
    </h4>
    <table cellpadding="30" style="font-size: 12px;">

        <c:forEach var="movie" items="${param.movieList}">

            <tr>
                <td style="width: 400px; height: 100px;">
                    <p style="color: midnightblue">"${movie.getTitle()}"</p>
                        <%--<br><strong>Director</strong>${movie.getDirector().getName()}--%>
                        <%--<br><strong>Genres</strong><c:forEach var="genre" items="${movie.getGenres()}">${genre.getTypeOfGenre()}</c:forEach>--%>
                </td>


            </tr>
        </c:forEach>


    </table>


</div>


</body>
</html>
