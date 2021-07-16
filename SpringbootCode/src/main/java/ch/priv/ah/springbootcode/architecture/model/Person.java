package ch.priv.ah.springbootcode.architecture.model;

import java.util.ArrayList;

/**
 * @class: Person
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

public class Person {
    private static long newestId;
    private long id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private ArrayList<Long> groupIds;

    public Person(String first_name, String last_name, String password, String username) {
        this.id = newestId;
        newestId++;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        groupIds = new ArrayList<>();
    }

    public Person() {
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addGroup(long newGroupId) {
        groupIds.add(newGroupId);
    }

    public static long getNewestId() {
        return newestId;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Long> getGroupIds() {
        return groupIds;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", groupIds=" + groupIds +
                '}';
    }
}
