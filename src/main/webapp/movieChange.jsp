<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 25.03.2018
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>YourFavoriteMovies</title>
</head>
<body>


<jsp:include page="headerDataChange.jsp"/>
<jsp:include page="leftSideDataChange.jsp"/>


<div class="rightForm">
    <form method="post" action="/dispatcher" enctype="multipart/form-data">
        <p> Fill out this form, if yot want to add new movie </p>
        <p> Fields "Name of director" and "Title" are necessary! </p>
        <p> Name of director: <input type="text" placeholder="Karl Ponsey" name="name_of_director" size="30"></p>
        <p> Title: <input type="text" placeholder="Titanic" name="title" size="30"></p>
        <p> Runtime: <input type="text" placeholder="123" name="runtime" size="30"></p>
        <p> Description: <input type="file" name="description" size="30"></p>
        <p> Image: <input type="file" name="image" size="30"></p>
        <p> Genres:<input type="text" placeholder="comedy, western, crime" name="genres" size="30"></p>
        <input type="submit" name="command" value="Create movie">
    </form>
</div>

<div class="rightForm">
    <form method="post" action="/dispatcher">
        <p>Fill out this form, if yot want to delete movie</p>
        <p>Title: <input type="text" placeholder="Calvin Ford" name="title" size="30"></p>
        <input type="submit" name="command" value="Remove movie">
    </form>
</div>

<div class="rightForm">
    <form method="post" action="/dispatcher" enctype="multipart/form-data">
        <p> Fill out this form, if yot want to update movie </p>
        <p> Fields "Director id" and "Title" are necessary! </p>
        <p> Name of director: <input type="text" placeholder="Max Zamaev" name="name_of_director" size="30"></p>
        <p> Title: <input type="text" placeholder="Sun" name="title" size="30"></p>
        <p> Runtime: <input type="text" placeholder="83" name="runtime" size="30"></p>
        <p> Description: <input type="file" name="description" size="30"></p>
        <p> Image: <input type="file" name="image" size="30"></p>
        <p> Genres:<input type="text" placeholder="comedy, western, crime" name="genres" size="30"></p>
        <input type="submit" name="command" value="Update movie">
    </form>
</div>

</body>
</html>

