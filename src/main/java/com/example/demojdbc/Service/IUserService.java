package com.example.demojdbc.Service;

import com.example.demojdbc.Model.User;

import java.util.List;

public interface IUserSerice {

    public List<User> getAllUser();

    public void addUser(User user);

    public void updateUser(int id,User user);

    public void deleteUser(int id);

    public User getUserById(int id);

}
