package com.example.mongo.crud.services;

import com.example.mongo.crud.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getUsers();

    User createNewUser(User user);

    User findUserByEmail(String email);

    User updateUser(String email, User newData);

    void deleteUser(String email);
}
