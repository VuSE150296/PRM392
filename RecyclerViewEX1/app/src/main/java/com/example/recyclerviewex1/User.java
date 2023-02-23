package com.example.recyclerviewex1;

public class User {
    private String Username;
    private String FullName;
    private String Email;

    public User(String username, String fullName, String email) {
        Username = username;
        FullName = fullName;
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
