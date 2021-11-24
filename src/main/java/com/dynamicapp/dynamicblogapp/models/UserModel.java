package com.dynamicapp.dynamicblogapp.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "Users")
public class UserModel {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
