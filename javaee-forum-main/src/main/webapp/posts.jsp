<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
    <%@include file="head.jsp" %>
</head>
<body>

<jsp:useBean id="postList" type="java.util.List<kz.iitu.edu.model.Post>" scope="request"/>
<jsp:setProperty name="postList" property="*"/>

<%@include file="navbar.jsp" %>
<div class="container post-c">
    <p class="h2 mb-2">Posts</p>
    <% for (int i = 0; i < postList.size(); i++) { %>
        <div class="post mb-4"
             onclick="location.href=
                 'ParticularPostServlet?&postId=<%=postList.get(i).getId()%>'">
            <div class="content">
                <p class="h3"><% out.print(postList.get(i).getUser().getUsername()); %></p>
                <hr>
                <div class="topic">
                    <p><% out.print(postList.get(i).getContent()); %></p>
                </div>
                <p class="posted-date"><% SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    String strDate = format.format(postList.get(i).getPublishedDate());
                    out.print(strDate); %></p>
            </div>
        </div>
    <% } %>
</div>
</body>
</html>

<style>
    .post {
        height: 200px;
        width: 80%;
        border-radius: 80px;
        margin: 0 auto;
        background-color: white;
        cursor: pointer;
    }

    .post:hover {
        background-color: #d6cfcf;
        transition: 0.8s;
    }

    .post-c {
        background-color: #f7f5f0;
        min-height: 720px;
        padding: 15px;
    }

    .posted-date {
        color: #b9b7b2;
    }

    .topic {
        height: 70px;
        font-size: 19px;
    }

    .content {
        padding: 15px 80px;
    }

</style>
