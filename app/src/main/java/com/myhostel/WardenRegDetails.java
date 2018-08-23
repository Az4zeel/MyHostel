package com.myhostel;

public class WardenRegDetails {
    String email;
    String password;
    String gender;
    String name;


    public WardenRegDetails(String email, String password, String gender, String name){
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }
}
