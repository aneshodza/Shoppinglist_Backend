package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
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

    public Object checkForUser(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPeople().get(i).getUsername().equals(person.getUsername()) &&
                    wholeRepository.getPeople().get(i).getPassword().equals(person.getPassword())) {
                return wholeRepository.getPeople().get(i);
            }
        }
    return new ReturnMessage(1, "There is no such user", false);
    }

    public boolean checkIfUsernameIsUsed(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPeople().get(i).getUsername().equals(person.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public ReturnMessage createNewPerson(Person person){
        if (checkIfUsernameIsUsed(person)) {
            return new ReturnMessage(2, "Username is already in use", false);
        } else if (person.getPassword().length() < 8) {
            return new ReturnMessage(3, "Password is not 8 characters long", false);
        } else if (person.getUsername().isBlank()) {
            return new ReturnMessage(4, "Username cannot be empty", false);
        }
        wholeRepository.createNewPerson(person);
        return new ReturnMessage(0, "The user has successfully been created", true);
    }

    public ArrayList getAllMyGroups(long id) {
        return (ArrayList<Group>) wholeRepository.getGroups()
                .stream()
                .filter(group -> wholeRepository.getPersonById(id).getGroupIds().contains(group.getId()))
                .collect(Collectors.toList());
    }
}
