package ch.priv.ah.springbootcode.architecture.controller;

import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
import ch.priv.ah.springbootcode.architecture.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public Object attemptLogIn(@RequestBody Person person) {
        return personService.checkForUser(person);
    }

    @PostMapping
    public ReturnMessage signUp(@RequestBody Person person) {
        return personService.createNewPerson(person);
    }

    @GetMapping(path = "/{id}/my-groups")
    public ArrayList getMyGroups(@PathVariable long id) {
        return personService.getAllMyGroups(id);
    }

    @GetMapping(path = "/{myUrl}")
    public Object getUserByUrl(@PathVariable String myUrl) {
        return personService.getPersonByUrl(myUrl);
    }
}
