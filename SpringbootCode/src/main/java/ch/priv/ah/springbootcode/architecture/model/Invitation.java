package ch.priv.ah.springbootcode.architecture.model;

import java.time.LocalDateTime;

/**
 * @class: Invitation
 * @author: Anes Hodza
 * @version: 23.07.2021
 **/

public class Invitation {
    private static long newestId = 0;
    private long id;
    private boolean isOpen;
    private boolean hasBeenAccepted;
    private LocalDateTime whenSent;
    private String senderUrl;
    private String senderUsername;
    private String recieverUrl;
    private String groupUrl;
    private String groupName;

    public Invitation(String senderUrl, String groupUrl, String senderUsername, String groupName) {
        this.id = newestId;
        newestId++;
        this.whenSent = LocalDateTime.now();
        this.isOpen = true;
        this.hasBeenAccepted = false;
        this.senderUsername = senderUsername;
        this.senderUrl = senderUrl;
        this.groupUrl = groupUrl;
        this.groupName = groupName;
    }

    public void setThisInvitation() {
        this.id = newestId;
        newestId++;
        this.whenSent = LocalDateTime.now();
        this.isOpen = true;
        this.hasBeenAccepted = false;
    }

    public Invitation(long id, boolean hasBeenAccepted) {
        this.id = id;
        this.hasBeenAccepted = hasBeenAccepted;
    }

    public Invitation(String senderUrl, String groupUrl) {
        this.senderUrl = senderUrl;
        this.groupUrl = groupUrl;
    }

    public Invitation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isHasBeenAccepted() {
        return hasBeenAccepted;
    }

    public void setHasBeenAccepted(boolean hasBeenAccepted) {
        this.hasBeenAccepted = hasBeenAccepted;
    }

    public LocalDateTime getWhenSent() {
        return whenSent;
    }

    public void setWhenSent(LocalDateTime whenSent) {
        this.whenSent = whenSent;
    }

    public String getSenderUrl() {
        return senderUrl;
    }

    public void setSenderUrl(String senderUrl) {
        this.senderUrl = senderUrl;
    }

    public String getRecieverUrl() {
        return recieverUrl;
    }

    public void setRecieverUrl(String recieverUrl) {
        this.recieverUrl = recieverUrl;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public void setGroupUrl(String groupUrl) {
        this.groupUrl = groupUrl;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", isOpen=" + isOpen +
                ", hasBeenAccepted=" + hasBeenAccepted +
                ", whenSent=" + whenSent +
                ", senderUrl='" + senderUrl + '\'' +
                ", senderUsername='" + senderUsername + '\'' +
                ", recieverUrl='" + recieverUrl + '\'' +
                ", groupUrl='" + groupUrl + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
