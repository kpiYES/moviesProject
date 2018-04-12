<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 25.03.2018
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/dataChange.css" rel="stylesheet" type="text/css">
    <title>YourFavoriteMovies</title>
</head>
<body>


<jsp:include page="headerDataChange.jsp"/>
<jsp:include page="leftSideDataChange.jsp"/>

<p> <%=request.getAttribute("result")%></p>
<div class="rightForm">
    <form method="post" action="dispatcher" enctype="multipart/form-data">
        <p> Fill out this form, if yot want to add new director </p>
        <p> All fields are necessary! </p>
        <p> Name: <input type="text" placeholder="Frank Darabont" name="name" size="30"></p>
        <p> Day of birth: <input type="text" placeholder="1965-03-25" name="day_of_birth" size="30"></p>
        <p> Image: <input type="file"  name="image" size="30"></p>
        <input type="submit" name="command" value="Create director">
    </form>
</div>

<div class="rightForm">
    <form method="post" action="dispatcher">
        <p>Fill out this form, if yot want to delete director</p>
        <p>Name: <input type="text" placeholder="Emilia Stone" name="name" size="30"></p>
        <input type="submit" name="command" value="Remove director">
    </form>
</div>

<div class="rightForm">
    <form method="post" action="dispatcher" enctype="multipart/form-data">
        <p> Fill out this form, if yot want to update director </p>
        <p> All fields are necessary! </p>
        <p> Name: <input type="text" placeholder="Jozef Patric" name="name" size="30"></p>
        <p> Day of birth: <input type="text" placeholder="1973-09-14" name="day_of_birth" size="30"></p>
        <p> Image: <input type="file" name="image" size="30"></p>
        <input type="submit" name="command" value="Update director">
    </form>
</div>


</body>
</html>
