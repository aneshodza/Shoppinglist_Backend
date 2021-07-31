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

    public ReturnMessage CreateNewInvitation(String searchedUrl, Invitation invitation) {
        Optional<Person> myPerson = wholeRepository.getPeople()
                .stream()
                .filter(person -> searchedUrl.equals(person.getownUrl()))
                .findFirst();
        if (myPerson.isEmpty()) {
            return new ReturnMessage(1, "There was no such person found", false);
        }

        Optional<Group> joinedGroups = wholeRepository.getGroups()
                .stream()
                .filter(group -> group.getGroupUrl().equals(searchedUrl))
                .findFirst();
        if (joinedGroups.isPresent()) {
            return new ReturnMessage(5, "The user is already in the group", false);
        }

        Optional<Invitation> existingInvitation = wholeRepository.getInvitations()
                .stream()
                .filter(i -> i.getGroupUrl().equals(invitation.getGroupUrl()))
                .filter(i -> i.getRecieverUrl().equals(searchedUrl))
                .filter(i -> i.getSenderUrl().equals(invitation.getSenderUrl()))
                .findFirst();
        if (existingInvitation.isPresent()) {
            return new ReturnMessage(6, "You invited this user into this group already", false);
        }

        invitation.setThisInvitation();

        invitation.setSenderUsername(
                wholeRepository.getPeople()
                    .stream()
                    .filter(p -> invitation.getSenderUrl().equals(p.getownUrl()))
                    .findFirst()
                    .get()
                    .getUsername()
        );
        invitation.setGroupName(
                wholeRepository.getGroups()
                        .stream()
                        .filter(g -> invitation.getGroupUrl().equals(g.getGroupUrl()))
                        .findFirst()
                        .get()
                        .getGroupName()
        );
        myPerson.get().addInvitation(invitation);
        wholeRepository.getInvitations().add(invitation);
        return new ReturnMessage(0, "The invitation has been added", true);
    }

    public ReturnMessage reactToInvitation(Invitation invitation) {

        for (int i = 0; i < wholeRepository.getInvitations().size(); i++) {
            if (wholeRepository.getInvitations().get(i).getId() == invitation.getId()) {
                if (!wholeRepository.getInvitations().get(i).isOpen()) {
                    return new ReturnMessage(9, "The invitation has already been awnsered", false);
                }
                wholeRepository.getInvitations().get(i).setOpen(false);
                wholeRepository.getInvitations().get(i).setHasBeenAccepted(invitation.isHasBeenAccepted());
                final int tempIndex = i;
                Optional<Person> searchedPerson = wholeRepository.getPeople()
                        .stream()
                        .filter(person -> person.getownUrl().equals(wholeRepository.getInvitations().get(tempIndex).getRecieverUrl()))
                        .findFirst();
                if (searchedPerson.isEmpty()) {
                    return new ReturnMessage(1, "There was no such person found", false);
                }
                if (invitation.isHasBeenAccepted()) {
                    Group newGroup = wholeRepository.getGroups()
                            .stream()
                            .filter(group -> group.getGroupUrl().equals(wholeRepository.getInvitations().get(tempIndex).getGroupUrl()))
                            .findFirst()
                            .get();
                    newGroup.addPersonToThisGroup(searchedPerson.get());
                    searchedPerson.get().addGroup(newGroup.getId());
                    return new ReturnMessage(0, "The invitation has successfully been reacted to", true);
                }
            }
        }
        return new ReturnMessage(8, "The invitation has not been found", false);
    }
}
