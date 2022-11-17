package com.tastingclub.springboot_db.service;

import com.tastingclub.springboot_db.model.User;
import com.tastingclub.springboot_db.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> fetchAll() {return userRepo.fetchAll();}
}
