package ch.priv.ah.springbootcode.architecture.controller;

import ch.priv.ah.springbootcode.architecture.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @class: GroupController
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ArrayList getAllGroups() {
        return groupService.getAllGroups();
    }
}
