package org.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    @NotEmpty(message = "Name should not be empty!!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String name;
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @NotEmpty(message = "Mail should not be empty!!")
    @Email(message = "Mail must be valid!")
    private String mail;
    private int id;

    public Person() {

    }

    public Person(String name, int age, String mail, int id) {
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
