package ch.priv.ah.springbootcode.architecture.controller;

import ch.priv.ah.springbootcode.architecture.model.Item;
import ch.priv.ah.springbootcode.architecture.otherServices.ReturnMessage;
import ch.priv.ah.springbootcode.architecture.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @class: ItemController
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ArrayList getAllPeople() {
        return itemService.getAllItems();
    }

    @DeleteMapping(path = "/{id}")
    public ReturnMessage deleteItemWithId(@PathVariable long id) {
        itemService.deleteItemWithId(id);
        return new ReturnMessage(0, "The item has successfully been deleted", true);
    }

    @PutMapping(path = "/{groupId}")
    public ReturnMessage createNewItem(@RequestBody Item newItem) {
        return itemService.createNewItem(newItem);
    }
}
