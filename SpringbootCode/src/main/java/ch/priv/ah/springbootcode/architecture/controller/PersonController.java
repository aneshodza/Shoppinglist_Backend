package ch.priv.ah.springbootcode.architecture.controller;

import ch.priv.ah.springbootcode.architecture.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @class: PersonController
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@RestController
@RequestMapping(path = "/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ArrayList getAllPeople() {
        return personService.getAllPeople();
    }
}
