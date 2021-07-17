package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public Person checkForUser(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPeople().get(i).getUsername().equals(person.getUsername()) &&
                    wholeRepository.getPeople().get(i).getPassword().equals(person.getPassword())) {
                return wholeRepository.getPeople().get(i);
            }
        }
    return new Person(1, "There is no such user");
    }

    public boolean checkIfUsernameIsUsed(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPeople().get(i).getUsername().equals(person.getUsername())) {
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
        return wholeRepository.createNewPerson(person);
    }

    public ArrayList getAllMyGroups(long id) {
        return (ArrayList<Group>) wholeRepository.getGroups()
                .stream()
                .filter(group -> wholeRepository.getPersonById(id).getGroupIds().contains(group.getId()))
                .collect(Collectors.toList());
    }
}
