package com.jonas.spring_security_examples.users;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

//Implementing the User class only as a JPA entity
@Entity
public class User {

    @Id
    private int id;
    private String username;
    private String password;
    private String authority;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthority() {
        return authority;
    }
}
