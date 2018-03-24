<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 15.03.2018
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>YourFavoriteMovies</title>
    <link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <h1 class="text_centre"> WELCOME! </h1>
</div>

<div class="text_centre">
    <p>
        We glad to see you!
        Please choose a mode of using this site.
        And don't forget to fill in your name ;D
    </p>
</div>


<div>
    <form class="login" method="get" action='dispatcher'>
        <input type="text" placeholder="Username" title="username" size="20">
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
