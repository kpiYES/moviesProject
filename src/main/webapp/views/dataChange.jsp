<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 24.03.2018
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>YourFavoriteMovies</title>
</head>
<body>

<div>
<h1 class="text_centre"> WELCOME! </h1>
</div>



<div>
    <p> Fill out this form, if yot want to add new genre </p>
    <form method="post" action="dispatcher">
        <input type="text" placeholder="Genre" name="genre_add" size="20">
        <input type="submit" value="Add">
    </form>
</div>

<div>
    <p>Fill out this form, if yot want to delete genre</p>
    <form method="post" action="dispatcher">
        <input type="text" placeholder="Genre" name="genre_delete" size="20">
        <input type="submit" value="Add">
    </form>
</div>




</body>
</html>
