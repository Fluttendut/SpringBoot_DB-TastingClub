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

    public User addUser(User user) { return userRepo.addUser(user);}

    public User findUserByID(int id) { return userRepo.findUserByID(id);
    }

    public boolean deleteUser(int id) { return userRepo.deleteUser(id);}

    public User updateUser(int id, User user) { return userRepo.updateUser(id, user);}
}
