package com.example.edp20;


public class SemiClass {

    String course;
    String username;
    String password;
    String name;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SemiClass( String name, String email, String course, String username, String password) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.username = username;
        this.password = password;

    }
    public SemiClass() {
    }
}