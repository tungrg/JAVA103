package com.slide1;

public class User {
    private String email;
    private String username;
    private int age;
    private String password;
    public User(String email, String username, int age, String password) {
        this.email = email;
        this.username = username;
        this.age = age;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
