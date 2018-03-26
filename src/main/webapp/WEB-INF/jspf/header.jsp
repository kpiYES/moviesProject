<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 20.03.2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<div class="header">
    <img alt="Place for logo" name="logo">
    </img>

    <div>
        <form class="search_form" name="search_form" method="post">
            <img src="../../images/movieroll.jpg" width="30" height="30">
            <input type="text" name="search_String" value="" size="100"/>
            <input type="submit" value="Search" name="search_button"/>
            <select name="search_option">
                <option>Movie</option>
                <option>Director</option>
            </select>
        </form>
    </div>
</div>

</html>