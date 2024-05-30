package com.example.Lab3.order;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {
    private String phone;

    public Phone(String phone){
        this.phone = phone;
    }

    public Phone() {

    }

    public String getPhone() {
        return phone;
    }
}
