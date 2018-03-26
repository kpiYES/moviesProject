<%@ page import="com.app.model.Genre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 20.03.2018
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>


<div class="sidebar1">
    <h4> Genres </h4>
    <ul class="nav">

        <%
            List<Genre> genreList = (List<Genre>) request.getAttribute("genreList");
            for (Genre genre : genreList) {%>

        <li><a href="movie?genre_id= <%=genre.getId()%>"><%=genre.getTypeOfGenre() %>
        </a></li>
        <%}%>


    </ul>

</div>

</html>
