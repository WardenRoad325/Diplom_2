package org.example;

import org.apache.commons.lang3.RandomStringUtils;


public class LoginUser {

    private final static String gmail = "@gmail.com";
    private String email;
    private String name;

    public LoginUser(String email) {
        this.email = email;
    }

    public LoginUser(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static LoginUser getRandomUser() {
        String email = RandomStringUtils.randomAlphabetic(10) + gmail;
        String name = RandomStringUtils.randomAlphabetic(10);
        return new LoginUser(email, name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}