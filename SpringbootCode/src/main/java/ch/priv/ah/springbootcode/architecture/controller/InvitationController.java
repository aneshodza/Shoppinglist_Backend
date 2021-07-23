package ch.priv.ah.springbootcode.architecture.controller;

import ch.priv.ah.springbootcode.architecture.model.Invitation;
import ch.priv.ah.springbootcode.architecture.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @class: InvitationController
 * @author: Anes Hodza
 * @version: 23.07.2021
 **/

@RestController
@RequestMapping(path = "/invitations")
public class InvitationController {

    private final InvitationService invitationService;

    @Autowired
    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @GetMapping
    public ArrayList<Invitation> getAllInvitations() {
        return invitationService.getAllInvitations();
    }
}
