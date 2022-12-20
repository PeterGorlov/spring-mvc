package org.example.model;

public class Person {
    private String name;
    private int age;
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
