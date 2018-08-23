package com.myhostel;

public class Student {
    String name;
    String password;
    String gender;
    String email;
    String dept;
    String year;
    String room;
    String rollno;

    public Student(){

    }

    public Student(String name, String password, String gender,String email, String dept, String year,String room, String rollno){
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.dept = dept;
        this.year = year;
        this.room = room;
        this.rollno = rollno;

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

    public String getYear() {
        return year;
    }

    public String getRollno() {
        return rollno;
    }

    public String getRoom() {

        return room;
    }
}
