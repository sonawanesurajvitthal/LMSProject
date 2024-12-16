package com.lms.service;

import com.lms.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public User getUser(int id);

    public List<User> listOfUser();

    public User updateUser(User user);

    public void deleteUserById(int id);
}
