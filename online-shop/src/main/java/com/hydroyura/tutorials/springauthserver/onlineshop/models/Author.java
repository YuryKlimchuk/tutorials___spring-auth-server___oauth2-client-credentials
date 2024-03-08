package com.hydroyura.tutorials.springauthserver.onlineshop.models;

import java.time.LocalDateTime;

public class Author {

    private String firstname, lastname;
    private LocalDateTime birthday;


    public Author() {}


    public String getFirstname() {
        return firstname;
    }

    public Author setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Author setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public Author setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
