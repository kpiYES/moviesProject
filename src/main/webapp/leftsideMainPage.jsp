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

</head>

<div class="sidebar1">
    <h4> Genres </h4>


    <ul>
        <jsp:useBean id="genreService" class="com.app.service.impl.GenreServiceImpl" type="com.app.service.GenreService"
                     scope="request"/>
        <c:forEach var="genre" items="${genreService.all}">

            <c:set var="genreForMovie" value="${genre}" scope="session"/>

            <li>
                <form action="dispatcher" method="post">
                    <a href="#" onclick="parentNode.submit()">${genre.typeOfGenre}</a>
                    <input type="hidden" name="command" value="To mainMoviePage">
                </form>
            </li>
        </c:forEach>

    </ul>

    <%--<ul class="nav">--%>

    <%--<%--%>
    <%--List<Genre> genreList = (List<Genre>) request.getAttribute("genreList");--%>
    <%--for (Genre genre : genreList) {%>--%>

    <%--<li><a href="movie?genre_id= <%=genre.getId()%>"><%=genre.getTypeOfGenre() %>--%>
    <%--</a></li>--%>
    <%--<%}%>--%>


    <%--</ul>--%>

</div>

</html>
