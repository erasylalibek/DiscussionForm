<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" href="style/login.css">
</head>
<body>
<%@include file="navbar.jsp" %>
<p class="text-center h1 my-5">Log In</p>

<div class="test-div">
    <form action="login" method="post">
        <input type="text" id="username" class="fadeIn second" name="username" placeholder="username">
        <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">

        <button type="submit" class="btn btn-dark">Login</button>
    </form>
</div>
</body>
</html>
