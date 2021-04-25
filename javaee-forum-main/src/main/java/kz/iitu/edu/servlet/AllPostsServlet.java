package kz.iitu.edu.servlet;

import kz.iitu.edu.model.Post;
import kz.iitu.edu.dao.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/posts")
public class AllPostsServlet extends HttpServlet {

    public AllPostsServlet() { super(); }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        PostDao postDao = new PostDao();

        try {
            List<Post> postList = postDao.getPosts();
            request.setAttribute("postList", postList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("posts.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
