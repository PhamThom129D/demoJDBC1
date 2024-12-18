package com.example.demojdbc.Service;

import com.example.demojdbc.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {

    public List<User> getAllUser() throws SQLException, ClassNotFoundException;

    public void addUser(User user);

    public void updateUser(int id,User user);

    public void deleteUser(int id) throws SQLException, ClassNotFoundException;

    public User getUserById(int id);

    List<User> getUserByName(String keyword);
}
