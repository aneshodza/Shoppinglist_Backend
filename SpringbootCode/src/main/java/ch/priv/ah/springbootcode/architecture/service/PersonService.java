package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @class: PersonService
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@Service
public class PersonService {

    private final WholeRepository wholeRepository;

    @Autowired
    public PersonService(WholeRepository wholeRepository) {
        this.wholeRepository = wholeRepository;
    }

    public ArrayList getAllPeople() {
        return wholeRepository.getPeople();
    }

    public Person getPersonById(long id) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (id == wholeRepository.getPersonAtIndex(i).getId()) {
                return wholeRepository.getPersonAtIndex(i);
            }
        }
        return null;
    }

    public Person checkForUser(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPersonAtIndex(i).getUsername().equals(person.getUsername()) &&
                    wholeRepository.getPersonAtIndex(i).getPassword().equals(person.getPassword())) {
                return wholeRepository.getPersonAtIndex(i);
            }
        }
    return new Person(1, "There is no such user");
    }

    public boolean checkIfUsernameIsUsed(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPersonAtIndex(i).getUsername().equals(person.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public Person createNewPerson(Person person){
        if (checkIfUsernameIsUsed(person)) {
            return new Person(2, "Username is already in use");
        } else if (person.getPassword().length() < 8) {
            return new Person(3, "Password is not 8 characters long");
        } else if (person.getUsername().isBlank()) {
            return new Person(4, "Username cannot be empty");
        }
        wholeRepository.createNewPerson(person);
        return new Person(0, "Created new user");
    }

    public ArrayList getAllMyGroups(long id) {
        ArrayList<Group> myGroups = new ArrayList<>();
        int newestGroupIndex = 0;
        for (int i = 0; i < getPersonById(id).getGroupIds().size(); i++) {
            for (int j = newestGroupIndex; j < wholeRepository.getGroups().size(); j++) {
                if (getPersonById(id).getGroupIds().get(i).equals(wholeRepository.getGroups().get(j).getId())) {
                    myGroups.add(wholeRepository.getGroups().get(j));
                    newestGroupIndex = j;
                    break;
                }
            }
        }
        return myGroups;
    }
}
