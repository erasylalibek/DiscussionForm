package kz.iitu.edu.dao;

import kz.iitu.edu.model.Post;
import kz.iitu.edu.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDao {

    DbConnection db = new DbConnection();

    public List<Post> getPosts()
        throws SQLException, ClassNotFoundException {
        List<Post> posts = new ArrayList<>();
        UserDao userDao = new UserDao();

        String sql = "SELECT * FROM posts";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            Date publishedDate = resultSet.getDate("published_date");
            Integer userId = resultSet.getInt("user_id");
            User user = userDao.getUserById(userId);

            Post post = new Post(id, content, publishedDate, userId, user);

            posts.add(post);
        }

        resultSet.close();
        statement.close();;
        connection.close();

        return posts;
    }

    public Post getPostById(Integer id) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();
        CommentDao commentDao = new CommentDao();

        String sql = "SELECT * FROM posts WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        Post post = new Post();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        post.setUserId(resultSet.getInt("user_id"));
        post.setPublishedDate(resultSet.getDate("published_date"));
        post.setContent(resultSet.getString("content"));
        post.setUser(userDao.getUserById(resultSet.getInt("user_id")));
        post.setId(id);
        post.setComments(commentDao.getAllByPostId(id));

        return post;
    }
}
