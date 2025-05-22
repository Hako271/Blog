package com.example.ApiBlog.conf;

public class UserRegistrationDto {
    private String lastName;
    private String firstName;
    private String password;
    private String email;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String lastName, String password, String email, String firstName) {
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
