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
        people.add(new Person("Peter", ++COUNT_PERSON));
        people.add(new Person("Igor", ++COUNT_PERSON));
        people.add(new Person("Bogdan", ++COUNT_PERSON));
        people.add(new Person("Artur", ++COUNT_PERSON));
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
}
