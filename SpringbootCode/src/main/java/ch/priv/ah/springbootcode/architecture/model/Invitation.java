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
    private String recieverUrl;
    private String groupUrl;

    public Invitation(String senderUrl, String groupUrl) {
        this.id = newestId;
        newestId++;
        this.whenSent = LocalDateTime.now();
        this.isOpen = true;
        this.hasBeenAccepted = false;
        this.senderUrl = senderUrl;
        this.groupUrl = groupUrl;
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
        this.senderUrl = Invitation.this.senderUrl;
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

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", isOpen=" + isOpen +
                ", hasBeenAccepted=" + hasBeenAccepted +
                ", whenSent=" + whenSent +
                ", senderUrl=" + senderUrl +
                ", recieverUrl=" + recieverUrl +
                ", groupUrl=" + groupUrl +
                '}';
    }
}
