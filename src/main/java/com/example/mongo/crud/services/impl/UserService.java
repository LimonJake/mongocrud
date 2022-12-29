package com.example.mongo.crud.services.impl;

import com.example.mongo.crud.models.User;
import com.example.mongo.crud.repository.IUserRepository;
import com.example.mongo.crud.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> result = userRepository.findByEmail(email);
        if(result.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return result.get();
    }

    @Override
    public User updateUser(String email, User newData) {

        Optional<User> result = userRepository.findByEmail(email);

        if(result.isPresent())
            return userRepository.save(newData);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The email : %s does not exist!", email));
    }

    @Override
    public void deleteUser(String email) {
        Optional<User> result = userRepository.findByEmail(email);
        result.ifPresent(userRepository::delete);
    }


}
