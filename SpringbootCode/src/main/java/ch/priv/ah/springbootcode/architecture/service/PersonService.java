package ch.priv.ah.springbootcode.architecture.service;

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
}
