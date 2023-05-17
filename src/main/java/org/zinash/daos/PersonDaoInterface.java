package org.zinash.daos;

import org.zinash.models.Person;

import java.util.List;

public interface PersonDaoInterface {
    List<Person> getAllPersons();

    void addPerson(Person person);

    public void updateCity(int personId, String newCity);

    public void deletPerson(int personId);

    public List<Person> getPersonsById(int personId);

    public List<Person> getPersonsByName(String lastName);


}
