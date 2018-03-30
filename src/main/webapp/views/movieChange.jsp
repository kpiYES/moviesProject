<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 25.03.2018
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>YourFavoriteMovies</title>
</head>
<body>


<jsp:include page="../WEB-INF/jspf/headerDataChange.jsp"/>
<jsp:include page="../WEB-INF/jspf/leftSideDataChange.jsp"/>


<div class="rightForm">
    <form method="post" action="/dispatcher">
        <p> Fill out this form, if yot want to add new movie </p>
        <p> Fields "Director id" and "Title" are necessary! </p>
        <p> Director id: <input type="text" placeholder="3" name="director_id" size="30"></p>
        <p> Title: <input type="text" placeholder="Titanic" name="title" size="30"></p>
        <p> Runtime: <input type="text" placeholder="123" name="runtime" size="30"></p>
        <p> Path to describtion: <input type="text" placeholder="C:\Folder1\...\FolderD\aboutMovie.pdf" name="runtime" size="30"></p>
        <p> Path to image: <input type="text" placeholder="C:\Folder1\...\FolderK\picture.img" name="image"
                                  size="30"></p>
        <input type="submit" name="command" value="Create movie">
    </form>
</div>

<div class="rightForm">
    <form method="post" action="/dispatcher">
        <p>Fill out this form, if yot want to delete movie</p>
        <p>Title: <input type="text" placeholder="Calvin Ford" name="name" size="30"></p>
        <input type="submit" name="command" value="Remove movie">
    </form>
</div>

<div class="rightForm">
    <form method="post" action="/dispatcher">
        <p> Fill out this form, if yot want to update movie </p>
        <p> Fields "Director id" and "Title" are necessary! </p>
        <p> Director id: <input type="text" placeholder="4" name="director_id" size="30"></p>
        <p> Title: <input type="text" placeholder="Sun" name="title" size="30"></p>
        <p> Runtime: <input type="text" placeholder="83" name="runtime" size="30"></p>
        <p> Path to describtion: <input type="text" placeholder="C:\Folder1\...\FolderD\aboutMovie.pdf" name="description" size="30"></p>
        <p> Path to image: <input type="text" placeholder="C:\Folder1\...\FolderK\picture.img" name="image"
                                  size="30"></p>
        <input type="submit" name="command" value="Update movie">
    </form>
</div>

</body>
</html>
