package org.example.dao;

import org.example.model.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT_PERSON;

    private static final String URL = "jdbc:postgresql://localhost:5432/springMVC_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1111";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM PERSON";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setMail(resultSet.getString("mail"));
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

//    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getMail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person personFromUpdate) {
//        Person person = show(id);
//        person.setName(personFromUpdate.getName());
//        person.setAge(personFromUpdate.getAge());
//        person.setMail(personFromUpdate.getMail());
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
