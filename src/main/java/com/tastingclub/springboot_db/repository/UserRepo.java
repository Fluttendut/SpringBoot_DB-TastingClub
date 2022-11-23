package com.tastingclub.springboot_db.repository;

import com.tastingclub.springboot_db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate template;


    // CHECK WHY THE WHERE userID does not work!!!!!
    public User updateUser(int id, User user) {
        String sql = "UPDATE users SET usrName = ?, favTeacher = ? WHERE userID = ?";
        template.update(sql, user.getUsrName(), user.getFavTeacher(), user.getUsrID());
        return null;
    }

    public List<User> fetchAll() {
        String sql = "SELECT usrId, usrName, favTeacher FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);
    }

    public User addUser(User user) {
        String sql = "INSERT INTO users (usrName, password, favTeacher) VALUES(?,?,?)";
        template.update(sql, user.getUsrName(), user.getPassword(), user.getFavTeacher());
        return null;
    }

    //Rowmapper is the SQL equivalent of ResultSet
    public User findUserByID(int id) {
        String sql = "SELECT usrID, usrName, favTeacher FROM users WHERE usrID = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = template.queryForObject(sql, rowMapper, id);
        return user;
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM user WHERE userID = ?";
        return template.update(sql, id) >0;
    }
}
