package com.dynamicapp.dynamicblogapp.models;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "users")
public class UserModel {

    @Id
    @Column(name = "userid")
    private int userid;

    @Column(name = "username")
    private String username;

    @Column(name = "useremail")
    private String useremail;

    @Column(name = "userpassword")
    private String userpassword;

    public int getUserid() {
        return userid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
