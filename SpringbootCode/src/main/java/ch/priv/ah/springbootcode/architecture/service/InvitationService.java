package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Invitation;
import ch.priv.ah.springbootcode.architecture.model.Person;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @class: InvitationService
 * @author: Anes Hodza
 * @version: 23.07.2021
 **/

@Service
public class InvitationService {

    private final WholeRepository wholeRepository;

    @Autowired
    public InvitationService(WholeRepository wholeRepository) {
        this.wholeRepository = wholeRepository;
    }

    public ArrayList<Invitation> getAllInvitations() {
        return wholeRepository.getInvitations();
    }

    public ReturnMessage getUserWithSearchedUrl(String searchedUrl, Invitation invitation) {
        Optional<Person> myPerson = wholeRepository.getPeople()
                .stream()
                .filter(person -> searchedUrl.equals(person.getownUrl()))
                .findFirst();

        if (myPerson.isEmpty()) {
            return new ReturnMessage(1, "There was no such person found", false);
        }
        
        Person temp = myPerson.get();
        Optional<Group> joinedGroup = wholeRepository.getGroups()
                .stream()
                .filter(group -> wholeRepository.getPersonById(temp.getId()).getGroupIds().contains(group.getId()))
                .findFirst();

        if (joinedGroup.isPresent()) {
            return new ReturnMessage(5, "The user is already in the group", false);
        }
        myPerson.get().addInvitation(invitation);
        wholeRepository.getInvitations().add(invitation);
        return new ReturnMessage(0, "The invitation has been added", true);
    }
}
