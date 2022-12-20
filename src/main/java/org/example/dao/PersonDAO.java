package org.example.dao;

import org.example.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT_PERSON;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person("Peter", 28, "osmachkin@gmail.com", ++COUNT_PERSON));
        people.add(new Person("Igor", 30, "Mangov@gmail.com", ++COUNT_PERSON));
        people.add(new Person("Bogdan", 22, "Marchenko@gmail.com", ++COUNT_PERSON));
        people.add(new Person("Artur", 25, "Marchenko@gmail.com", ++COUNT_PERSON));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++COUNT_PERSON);
        people.add(person);
    }

    public void update(int id, Person personFromUpdate) {
        Person person = show(id);
        person.setName(personFromUpdate.getName());
        person.setAge(personFromUpdate.getAge());
        person.setMail(personFromUpdate.getMail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
