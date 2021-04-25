package kz.iitu.edu.servlet;

import kz.iitu.edu.model.Comments;
import kz.iitu.edu.model.Post;
import kz.iitu.edu.model.User;
import kz.iitu.edu.dao.CommentDao;
import kz.iitu.edu.dao.PostDao;
import kz.iitu.edu.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

    public CommentServlet() { super(); }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommentDao commentDao = new CommentDao();
        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();

        try {
            Integer postId = Integer.parseInt(req.getParameter("postId"));
            Integer userId = Integer.parseInt(req.getParameter("userId"));
            String answer = req.getParameter("comment");
            Integer likes = 0;
            Date publishedDate = new Date(System.currentTimeMillis());
            User user = userDao.getUserById(userId);

            Comments comment = new Comments();
            comment.setContent(answer);
            comment.setUserId(userId);
            comment.setPostId(postId);
            comment.setUser(user);
            comment.setLikes(likes);
            comment.setPublishedDate(publishedDate);

            int res = 0;
            if (answer != null) {
                res = commentDao.createComment(comment);
            }

            Post post = postDao.getPostById(postId);

            req.setAttribute("post", post);

            System.out.println(res);
            RequestDispatcher dispatcher =req.getRequestDispatcher("particular.jsp");
            dispatcher.forward(req, resp);


        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
