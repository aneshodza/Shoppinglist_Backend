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
                new Person("Anes", "Hodza", "bj6IOTjaAuxoU5OTf5ur", "anes.hodza")
        );
        people.add(
                new Person("Meriton", "Aliu", "freg546gtr56", "meriton.aliu")
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

    public ArrayList<Item> getItems() {
        return items;
    }
}
