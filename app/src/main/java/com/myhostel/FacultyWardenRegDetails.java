package com.myhostel;

public class FacultyWardenRegDetails {
    String name;
    String password;
    String gender;
    String email;
    String dept;


    public FacultyWardenRegDetails(String name, String password, String gender,String email, String dept){
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.dept = dept;

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

    public String getEmail() {
        return email;
    }

    public String getDept() {
        return dept;
    }
}
