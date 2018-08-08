package com.myhostel;

public class WardenRegDetails {
    String name;
    String password;
    String gender;

    public WardenRegDetails(){

    }

    public WardenRegDetails(String name, String password, String gender){
        this.name = name;
        this.password = password;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }
}
