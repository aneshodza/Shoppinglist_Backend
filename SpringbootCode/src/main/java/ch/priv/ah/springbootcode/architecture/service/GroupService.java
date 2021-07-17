package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
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
        for (int i = 0; i < wholeRepository.getGroups().size(); i++) {
            if (url.equals(wholeRepository.getGroups().get(i).getGroupUrl())){
                return wholeRepository.getGroups().get(i);
            }
        }
        return null;
    }
}
