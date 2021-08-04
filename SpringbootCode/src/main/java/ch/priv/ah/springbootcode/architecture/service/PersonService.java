package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;
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

    public Object checkForUser(Person searchedPerson) {
        Optional<Person> foundPerson = wholeRepository.getPeople()
                .stream()
                .filter(person -> person.getUsername().equals(searchedPerson.getUsername()))
                .findFirst();
        if (foundPerson.isEmpty()) {
            return new ReturnMessage(1, "There is no such user", false);
        } else if (!foundPerson.get().getPassword().equals(searchedPerson.getPassword())) {
            return new ReturnMessage(1, "There is no such user", false);
        }
        return foundPerson.get();
    }

    public boolean checkIfUsernameIsUsed(Person searchedPerson) {
        return wholeRepository.getPeople()
                .stream()
                .filter(person -> person.getUsername().equals(searchedPerson.getUsername()))
                .findFirst()
                .isEmpty();
    }

    public Object createNewPerson(Person person){
        if (person.getUsername().isBlank()) {
            return new ReturnMessage(4, "Username cannot be empty", false);
        } else if (person.getPassword().length() < 8) {
            return new ReturnMessage(3, "Password is not 8 characters long", false);
        } else if (!checkIfUsernameIsUsed(person)) {
            return new ReturnMessage(2, "Username is already in use", false);
        }
        wholeRepository.createNewPerson(person);
        return wholeRepository.getPeople().get(wholeRepository.getPeople().size()-1);
    }

    public ArrayList getAllMyGroups(long id) {
        return (ArrayList<Group>) wholeRepository.getGroups()
                .stream()
                .filter(group -> wholeRepository.getPersonById(id).getGroupIds().contains(group.getId()))
                .collect(Collectors.toList());
    }

    public Object getPersonByUrl(String myUrl) {
        Optional<Person> myPerson = wholeRepository.getPeople()
                .stream()
                .filter(person -> myUrl.equals(person.getownUrl()))
                .findFirst();
        if (myPerson.isEmpty()) {
            return new ReturnMessage(1, "There was no such person found", false);
        }
        return myPerson.get();
    }
}
