<%@ page import="com.app.model.Director" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 15.03.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <movie>YourFavoriteMovies</movie>
    <link href="../css/mainStyle.css" rel="stylesheet" type="text/css">
</head>
<body>


<div class="container">


    <div class="header">
        <div class="logo">
            <img src="../images/movieroll.jpg">
        </div>

        <div class="desor">
            <h3> Your favorite movies</h3>
        </div>

        <div class="searching_form">
            <form title="search_form" method="post">
                <input type="text" title="search_String value=" size="110"/>
                <input class="search_button" type="submit" value="Search" title="search_button"/>
                <select title="search_option">
                    <option>Title</option>
                    <option>Director</option>
                </select>
            </form>
        </div>
    </div>

    <div class="sidebar1">
        <h4> Choose directors</h4>
        <ul class="nav">

            <%
                List<Director> directorList = (List<Director>) request.getAttribute("directorList");
                for (Director director : directorList) {
                    out.print("<li><a href='#'>" + director.getName() + "</a></li>");
                }
            %>

        </ul>
        <p>&nbsp;</p>
    </div>

    <div class="content">
        <h1> &nbsp;</h1>
        <p>&nbsp;</p>
    </div>


</div>
</body>
</html>
