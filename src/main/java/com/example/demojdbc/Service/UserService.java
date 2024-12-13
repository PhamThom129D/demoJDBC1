package com.example.demojdbc.Service;

import com.example.demojdbc.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService implements IUserService{
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try (Connection conn = ConnectJDBC.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String phone = resultSet.getString("phoneNumber");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                users.add(new User(id, name, phone, password, address));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in getAllUser", e);
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into users(username,phoneNumber,password,address) values(?,?,?,?)";
        try (Connection conn = ConnectJDBC.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, user.getName());
            pre.setString(2, user.getPhone());
            pre.setString(3, user.getPassword());
            pre.setString(4, user.getAddress());
            pre.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in addUser", e);
        }

    }

    @Override
    public void updateUser(int id, User user) {
        String sql = "update users set username = ?,phoneNumber = ?,password = ?,address = ? where id = ?";
        try (Connection conn = ConnectJDBC.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, user.getName());
            pre.setString(2, user.getPhone());
            pre.setString(3, user.getPassword());
            pre.setString(4, user.getAddress());
            pre.setInt(5, id);
            pre.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in updateUser", e);
        }

    }
    @Override
    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectJDBC.getConnection();
        String sql = "delete from users where id = ?";
        try(PreparedStatement pre = conn.prepareStatement(sql)){
            pre.setInt(1,id);
            pre.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in deleteUser", e);
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from users where id = ?";
        User user = null;
        try (Connection conn = ConnectJDBC.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, id);
            try (ResultSet resultSet = pre.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("username");
                    String phone = resultSet.getString("phoneNumber");
                    String password = resultSet.getString("password");
                    String address = resultSet.getString("address");
                    user = new User(id, name, phone, password, address);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in getUserById", e);
        }
        return user;
    }
    @Override
    public List<User> getUserByName(String keyword) {
        String sql = "select * from users where username like ?";
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectJDBC.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, "%" + keyword + "%");
            try (ResultSet resultSet = pre.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("username");
                    String phone = resultSet.getString("phoneNumber");
                    String password = resultSet.getString("password");
                    String address = resultSet.getString("address");
                    users.add(new User(id, name, phone, password, address));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in getUserByName", e);
        }
        return users;
    }

}
