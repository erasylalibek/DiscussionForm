<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user" class="kz.iitu.edu.model.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<header>
    <div class="container">
        <nav class="navbar navbar-expand">
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AllPostsServlet">Posts</a>
                    </li>

                    <li class="nav-item"><a class="nav-link">
                        About</a>
                    </li>
                </ul>
            </div>

            <div class="authorize">

                <% if (user.getUsername() != null) { %>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link">
                        <jsp:getProperty name="user" property="username"/>
                    </a></li>
                    <li class="nav-item"><a href="LogoutServlet" class="nav-link">Log out</a></li>
                </ul>
                <% }
                if (user.getUsername() == null) { %>
                <a class="nav-link" href="login.jsp">Log in</a>
                <% } %>
            </div>
        </nav>
    </div>
</header>

<style>
    header {
        background-color: #f2f2f2;
    }

    .navbar {
        padding: 0;
    }

    .mr-15 {
        margin-right: 10rem;
    }

    .nav-item {
        margin-right: 26px;
        position: relative;
    }

    .nav-item:hover {
        border-bottom: 4px solid black;
    }

    a {
        color: black;
        padding: 0;
        height: 68px;
        line-height: 72px;
    }

    li {
        height: 68px;
    }

    .authorize:hover {
        font-weight: bold;
    }

    .nav-link {
        cursor: pointer;
        padding-top: 0;
    }

</style>
