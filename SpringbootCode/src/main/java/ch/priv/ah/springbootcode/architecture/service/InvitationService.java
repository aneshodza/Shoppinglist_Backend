package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Invitation;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
