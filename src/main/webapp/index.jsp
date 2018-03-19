<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 15.03.2018
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <movie>YourFavoriteMovies</movie>
    <link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <h1 class="text"> WELCOME! </h1>
</div>


<div>
    <p class="text">
        We glad to see you in our site!
        You can find here interesting book, download or read the one online.
    </p>
</div>

<div class="movie">
    <p> Enter your title </p>
    <form class="login" method="post" action="main">
        <input type="text" placeholder="Username" title="username" size="20">
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
