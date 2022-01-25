package com.wisestep.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private Boolean isUserLoggedIn;

    public User() {
        super();
    }

    public User(Long id, String email, Boolean isUserLoggedIn) {
        this.id = id;
        this.email = email;
        this.isUserLoggedIn = isUserLoggedIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(Boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", isUserLoggedIn=" + isUserLoggedIn +
                '}';
    }
}
