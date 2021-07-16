package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Person checkForUser(Person person) {
        for (int i = 0; i < wholeRepository.getPeople().size(); i++) {
            if (wholeRepository.getPersonAtIndex(i).getUsername().equals(person.getUsername()) &&
                    wholeRepository.getPersonAtIndex(i).getPassword().equals(person.getPassword())) {
                return wholeRepository.getPersonAtIndex(i);
            }
        }
    return new Person("There is no such user", "");
    }
}
