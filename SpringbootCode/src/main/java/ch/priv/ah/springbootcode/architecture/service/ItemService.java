package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @class: ItemService
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@Service
public class ItemService {

    private final WholeRepository wholeRepository;

    @Autowired
    public ItemService(WholeRepository wholeRepository) {
        this.wholeRepository = wholeRepository;
    }

    public ArrayList getAllItems() {
        return wholeRepository.getItems();
    }
}
