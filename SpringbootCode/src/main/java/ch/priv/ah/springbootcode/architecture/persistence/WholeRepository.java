package ch.priv.ah.springbootcode.architecture.persistence;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Item;
import ch.priv.ah.springbootcode.architecture.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @class: WholeRepository
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@Repository
public class WholeRepository {
    ArrayList<Group> groups;
    ArrayList<Person> people;
    ArrayList<Item> items;

    public WholeRepository() {
        groups = new ArrayList<>();
        people = new ArrayList<>();
        items = new ArrayList<>();

        groups.add(
                new Group("Test group")
        );

        people.add(
                new Person("Anes", "Hodza", "12345678", "anes.hodza")
        );
        people.add(
                    new Person("Meriton", "Aliu", "12345678", "meriton.aliu")
        );

        items.add(
                new Item("Batteries", "Buy them quick")
        );
        items.add(
                new Item("Milk", "I'm going to bake some cookies")
        );

        groups.get(0).addPersonToThisGroup(people.get(0));
        groups.get(0).addPersonToThisGroup(people.get(1));
        groups.get(0).addItemToThisGroup(items.get(0), people.get(0).getId());
        groups.get(0).addItemToThisGroup(items.get(1), people.get(1).getId());
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Person getPersonAtIndex(int index) {
        return getPeople().get(index);
    }

    public boolean createNewPerson(Person person) {
        people.add(
                new Person(person.getFirst_name(), person.getLast_name(), person.getPassword(), person.getUsername())
        );
        return true;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
