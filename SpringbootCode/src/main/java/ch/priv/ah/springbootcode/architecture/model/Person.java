package ch.priv.ah.springbootcode.architecture.model;

import ch.priv.ah.springbootcode.architecture.otherServices.RandomString;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @class: Person
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

public class Person {
    private static long newestId;
    private long id;
    private static ArrayList<String> usedUrls = new ArrayList<>();
    private static final RandomString randomString = new RandomString();
    private String ownUrl;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private ArrayList<Long> groupIds;
    private ArrayList<Invitation> invitations;

    public Person(String first_name, String last_name, String password, String username) {
        this.id = newestId;
        newestId++;
        boolean abort = false;
        String newUrl = "";
        while (!abort) {
            abort = true;
            newUrl = randomString.getAlphaNumericString(5);
            for (int i = 0; i < usedUrls.size(); i++) {
                if (newUrl.equals(usedUrls.get(i))) {
                    abort = false;
                }
            }
        }
        usedUrls.add(newUrl);
        this.ownUrl = newUrl;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        groupIds = new ArrayList<>();
        invitations = new ArrayList<>();
    }

    public Person() {
    }

    public Person(long id, String username) {
        this.username = username;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addGroup(long newGroupId) {
        groupIds.add(newGroupId);
        Collections.sort(this.groupIds);
    }

    public void addInvitation(Invitation invitation) {
        invitations.add(invitation);
        invitation.setRecieverNumber(this.ownUrl);
    }

    public static long getNewestId() {
        return newestId;
    }

    public long getId() {
        return id;
    }

    public String getownUrl() {
        return ownUrl;
    }

    public void setownUrl(String ownUrl) {
        this.ownUrl = ownUrl;
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

    public ArrayList<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(ArrayList<Invitation> invitations) {
        this.invitations = invitations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", groupIds=" + groupIds + '\'' +
                ", invitations=" + invitations +
                '}';
    }
}
