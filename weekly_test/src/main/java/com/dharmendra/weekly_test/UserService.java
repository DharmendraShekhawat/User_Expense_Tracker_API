package com.dharmendra.weekly_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

@Autowired
IUserRepo userRepo;

    public ResponseEntity<String> addUser(Users user) {
      userRepo.save(user);
        HttpStatus status = HttpStatus.CREATED;
        return ResponseEntity.status(status).body("user added");
    }
}
