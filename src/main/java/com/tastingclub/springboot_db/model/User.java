package com.tastingclub.springboot_db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    private int usrID;
    private String usrName, password, favTeacher;

    public User(){}

//    public int getUsrID() {return usrID;}
//    public String getUsrName() {return usrName;}
//    public String getPassword() {return password;}
//    public String getFavTeacher() {return favTeacher;}
//
//    public void setUsrID(int isrID) {this.usrID = isrID;}
//    public void setUsrName(String usrName) {this.usrName = usrName;}
//    public void setPassword(String password) {this.password = password;}
//    public void setFavTeacher(String favTeacher) {this.favTeacher = favTeacher;}
}
