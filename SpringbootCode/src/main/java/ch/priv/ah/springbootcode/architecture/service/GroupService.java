package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @class: GroupService
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@Service
public class GroupService {

    private final WholeRepository wholeRepository;

    @Autowired
    public GroupService(WholeRepository wholeRepository) {
        this.wholeRepository = wholeRepository;
    }

    public ArrayList getAllGroups() {
        return wholeRepository.getGroups();
    }

    public Group getGroupByUrl(String url) {
        return wholeRepository.getGroups()
                .stream()
                .filter(group -> group.getGroupUrl().equals(url))
                .findFirst()
                .get();
    }

    public ReturnMessage createNewGroup(Group newGroup, String personUrl) {
        newGroup.giveMeUrl();
        try {
            newGroup.addPersonToThisGroup(wholeRepository.getPersonByUrl(personUrl));
        } catch (Exception personNotFound) {
            return new ReturnMessage(1, "There was no such person found", false);
        }
        wholeRepository.getGroups().add(newGroup);
        return new ReturnMessage(0, "Group has successfully been created", true);
    }
}
