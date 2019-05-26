package com.ciaoshen.sia4.ch05.post_form_54.spittr;

public class Spitter {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public Spitter() {}

    public Spitter(Long id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Spitter(String firstName, String lastName, String username, String password) {
        this(null, firstName, lastName, username, password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void SetFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

}
