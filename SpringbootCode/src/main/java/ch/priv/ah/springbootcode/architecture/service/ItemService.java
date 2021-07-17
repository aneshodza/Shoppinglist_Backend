package ch.priv.ah.springbootcode.architecture.service;

import ch.priv.ah.springbootcode.architecture.model.Group;
import ch.priv.ah.springbootcode.architecture.model.Item;
import ch.priv.ah.springbootcode.architecture.persistence.WholeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public void deleteItemWithId(long id){
        Optional<Item> whatItem = wholeRepository.getItems()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst();

        Optional<Group> whereToDelete = wholeRepository.getGroups()
                .stream()
                .filter(g -> whatItem.get().getGroupId() == g.getId())
                .findFirst();
        wholeRepository.getGroupById(whereToDelete.get().getId()).removeItemFromThisGroup(whatItem.get().getId());
        wholeRepository.removeItemById(id);
    }
}
