package com.example.Lab3.order;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserName {
    private String fullName;

    public UserName(String fullName){
        this.fullName = fullName;
    }

    public UserName() {

    }

    public String getFullName() {
        return fullName;
    }
}
