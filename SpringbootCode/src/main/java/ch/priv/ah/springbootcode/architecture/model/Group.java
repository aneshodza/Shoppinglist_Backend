package ch.priv.ah.springbootcode.architecture.model;

import ch.priv.ah.springbootcode.architecture.otherServices.RandomString;

import java.util.ArrayList;

/**
 * @class: Group
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

public class Group {
    private static long newestId = 0;
    private static ArrayList<String> usedUrls = new ArrayList<>();
    private static final RandomString randomString = new RandomString();
    private long id;
    private String groupName;
    private String groupUrl;
    private ArrayList<Person> members;
    private ArrayList<Item> items;

    public Group(String groupName) {
        this.id = newestId;
        newestId++;
        boolean abort = false;
        String newUrl = "";
        while (!abort) {
            abort = true;
            newUrl = randomString.getAlphaNumericString(10);
            for (int i = 0; i < usedUrls.size(); i++) {
                if (newUrl.equals(usedUrls.get(i))) {
                    abort = false;
                }
            }
        }
        usedUrls.add(newUrl);
        this.groupUrl = newUrl;
        this.groupName = groupName;
        members = new ArrayList<>();
        items = new ArrayList<>();
    }

    public Group(String groupName, String groupUrl) {
        this.id = newestId;
        newestId++;
        usedUrls.add(groupUrl);
        this.groupUrl = groupUrl;
        this.groupName = groupName;
        members = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addPersonToThisGroup(Person person) {
        members.add(person);
        person.addGroup(this.id);
    }

    public void addItemToThisGroup(Item item) {
        items.add(item);
        item.setGroupId(this.id);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItemFromThisGroup(long id) {
        items.removeIf(item -> item.getId() == id);
    }

    public static long getNewestId() {
        return newestId;
    }

    public static ArrayList<String> getUsedUrls() {
        return usedUrls;
    }

    public static RandomString getRandomString() {
        return randomString;
    }

    public long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupUrl='" + groupUrl + '\'' +
                ", members=" + members +
                ", items=" + items +
                '}';
    }
}
