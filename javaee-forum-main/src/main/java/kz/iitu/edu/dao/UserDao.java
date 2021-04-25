package kz.iitu.edu.dao;

import kz.iitu.edu.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    DbConnection db = new DbConnection();
    public User checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        Connection connection = db.getConnection();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        User user = null;

        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }

    public int create(User user) throws ClassNotFoundException {

        String sql = "INSERT INTO users (username, password ) VALUES (?, ?)";
        int res = 0;

        try {

            Connection connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

//        ResultSet result = statement.executeQuery();

            res = statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public User getUserById(Integer id)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        User user = new User();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        user.setId(id);
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }
}
