package ch.priv.ah.springbootcode.architecture.controller;

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
    public boolean deleteItemWithId(@PathVariable long id) {
        itemService.deleteItemWithId(id);
        return true;
    }
}
