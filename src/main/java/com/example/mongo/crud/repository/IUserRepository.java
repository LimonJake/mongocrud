package com.example.mongo.crud.repository;

import com.example.mongo.crud.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}
