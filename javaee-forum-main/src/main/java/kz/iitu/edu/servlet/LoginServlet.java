package kz.iitu.edu.servlet;

import kz.iitu.edu.model.Post;
import kz.iitu.edu.model.User;
import kz.iitu.edu.dao.PostDao;
import kz.iitu.edu.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public LoginServlet() { super(); }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();

        try {
            User user = userDao.checkLogin(username, password);

            String direct = "";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30*60);
                List<Post> postList = postDao.getPosts();
                request.setAttribute("postList", postList);
                direct = "posts.jsp";
            } else {
                String message = "Invalid username/password";
                request.setAttribute("message", message);
                direct = "login.jsp";
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(direct);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
