package com.example.mongo.crud.controller;

import com.example.mongo.crud.models.User;

import com.example.mongo.crud.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createNewUser(user), HttpStatus.OK);
    }

    @PostMapping("/{email}")
    public ResponseEntity<User> findUser(@PathVariable("email") String email){
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(email, user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable("email") String email){
        userService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
