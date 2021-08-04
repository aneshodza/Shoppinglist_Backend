package ch.priv.ah.springbootcode.architecture.persistence;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Invitation;
import ch.priv.ah.springbootcode.architecture.model.Item;
import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

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
    ArrayList<Invitation> invitations;

    public WholeRepository() {
        groups = new ArrayList<>();
        people = new ArrayList<>();
        items = new ArrayList<>();
        invitations = new ArrayList<>();

        groups.add(
                new Group("Test group", "g87eg7mVes")
        );
        groups.add(
                new Group("Second test group", "f34gme50gw")
        );
        groups.add(
                new Group("Third test group", "54geGfBteF")
        );

        people.add(
                new Person("Anes", "Hodza", "12345678", "anes.hodza", "JR93y")
        );
        people.add(
                new Person("Meriton", "Aliu", "12345678", "meriton.aliu", "Sze4v")
        );
        people.add(
                new Person("Ismail", "Hodza", "12345678", "ismail.hodza", "43gmS")
        );

        items.add(
                new Item("Batteries", "Buy them quick", 0)
        );
        items.add(
                new Item("Milk", "I'm going to bake some cookies", 1)
        );

        invitations.add(
                new Invitation(people.get(0).getownUrl(), groups.get(1).getGroupUrl(), people.get(0).getUsername(), groups.get(1).getGroupName())
        );

        groups.get(1).addPersonToThisGroup(people.get(0));
        groups.get(0).addPersonToThisGroup(people.get(0));
        groups.get(0).addPersonToThisGroup(people.get(1));
        groups.get(2).addPersonToThisGroup(people.get(0));

        groups.get(0).addItemToThisGroup(items.get(0));
        groups.get(0).addItemToThisGroup(items.get(1));

        people.get(1).addInvitation(invitations.get(0));
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public Group getGroupById(long id) {
        return groups
                .stream()
                .filter(group -> group.getId() == id)
                .findFirst()
                .get();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Person getPersonById(long id) {
        return people
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .get();
    }

    public Person getPersonByUrl(String url) {
        return people
                .stream()
                .filter(person -> person.getownUrl().equals(url))
                .findFirst()
                .get();
    }

    public Person createNewPerson(Person person) {
        people.add(
                new Person(person.getFirst_name(), person.getLast_name(), person.getPassword(), person.getUsername())
        );
        return new Person(person.getFirst_name(), person.getLast_name(), person.getPassword(), person.getUsername());
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItemById(long id) {
        items.removeIf(item -> item.getId() == id);
    }

    public ArrayList<Invitation> getInvitations() {
        return invitations;
    }
}
