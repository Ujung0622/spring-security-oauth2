package io.security.cors2;

public class User {

    private String username;
    private int age;
    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }


    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

}
