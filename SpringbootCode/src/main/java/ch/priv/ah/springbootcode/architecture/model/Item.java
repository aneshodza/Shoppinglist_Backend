package ch.priv.ah.springbootcode.architecture.model;

/**
 * @class: Item
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

public class Item {
    private static long newestId;
    private long id;
    private String itemName;
    private String message;
    private boolean alreadyBought;
    private long personId;
    private long groupId;

    public Item(String itemName, String message) {
        this.id = newestId;
        newestId++;
        this.itemName = itemName;
        this.message = message;
        this.alreadyBought = false;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public static long getNewestId() {
        return newestId;
    }

    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getMessage() {
        return message;
    }

    public boolean isAlreadyBought() {
        return alreadyBought;
    }

    public long getPersonId() {
        return personId;
    }

    public long getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", message='" + message + '\'' +
                ", alreadyBought=" + alreadyBought +
                ", personId=" + personId +
                ", groupId=" + groupId +
                '}';
    }
}
