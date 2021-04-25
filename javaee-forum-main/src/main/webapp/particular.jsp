<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="kz.iitu.edu.model.Comments" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <%@include file="head.jsp" %>
</head>
<body>

<jsp:useBean id="post" class="kz.iitu.edu.model.Post" scope="request"/>
<jsp:setProperty name="post" property="*"/>

<%@include file="navbar.jsp" %>
<div class="container py-3 post-c">
    <div class="post">
        <div class="content">
            <p class="h2"><%=post.getUser().getUsername()%></p>
            <div class="topic">
                <p><%=post.getContent()%></p>
            </div>

            <p class="posted-date"><% SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                String topicDate = format.format(post.getPublishedDate());
                out.print(topicDate); %></p>
        </div>
    </div>

    <% for (Comments comment: post.getComments()) { %>
    <div class="comment mt-4">
        <p class="h5"><%=comment.getUser().getUsername()%></p>
        <div class="answer">
            <p><%=comment.getContent()%></p>
        </div>

        <div class="d-flex justify-content-start">
            <p class="posted-date">
                <%String commentDate = format.format(comment.getPublishedDate());
                    out.print(commentDate); %></p>
            <% if (user.getId() != null) { %>
            <form action="LikeServlet" method="get" class="ml-3 mb-2">
                <input type="hidden" name="commentId" value="<%=comment.getId()%>">

                <button type="submit" name="like" value="true" class="btn btn-dark">Likes <%=comment.getLikes()%></button>
            </form>
            <% } %>
            <% if (user.getId() == null) { %>
            <div class="ml-3 mb-2">
                <button type="submit"  onclick="location.href='login.jsp'" class="btn btn-dark">Likes <%=comment.getLikes()%></button>
            </div>
            <% } %>
        </div>

    </div>
    <% } %>
    <% if (user.getId() != null) { %>
    <form class="form-group" action="comment" method="post">
        <input type="hidden" name="postId" value="<%=post.getId()%>">
        <input type="hidden" name="userId" value="<%=user.getId()%>">
        <label for="comment">Comment:</label>
        <textarea name="comment" class="form-control" rows="5" id="comment"></textarea>
        <br>
        <button type="submit" class="btn btn-dark">Send</button>
    </form>
    <% } %>

    <% if (user.getId() == null) { %>
    <p class="require mt-5 h3">Log in if you want to leave comment</p>
    <% } %>

</div>
</body>
</html>

<style>
    .post {
        height: 200px;
        width: 90%;
        border-radius: 80px;
        margin: 0 auto;
        background-color: white;
    }

    .comment {
        height: 170px;
        width: 70%;
        background-color: white;
        margin: 0 135px;
        padding: 20px;
    }

    .content {
        padding: 15px 80px;
    }

    .answer {
        height: 80px;
        font-size: 15px;
    }

    .topic {
        height: 80px;
        font-size: 22px;
    }

    .posted-date {
        color: #b9b7b2;
    }

    .post-c {
        background-color: #f7f5f0;
        min-height: 720px;
        padding: 15px;
    }

    .form-group {
        width: 85%;
        margin: 0 auto;
    }

    .btn {
        padding: .150rem .45rem!important;
    }

    .require {
        display: block;
        width: 70%;
        margin: 0 135px;
        padding: .375rem .75rem;
        font-size: 1rem;
        line-height: 1.5;
        color: #495057;
        background-color: #fff;
        border: 1px solid #ced4da;
        border-radius: .25rem;
    }

</style>
