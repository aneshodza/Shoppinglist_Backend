package ch.priv.ah.springbootcode.architecture.model;

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
    private long senderId;
    private long recieverId;
    private long groupId;

    public Invitation(long senderId, long groupId) {
        this.id = newestId;
        newestId++;
        this.isOpen = true;
        this.hasBeenAccepted = false;
        this.senderId = senderId;
        this.groupId = groupId;
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

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(long recieverId) {
        this.recieverId = recieverId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", isOpen=" + isOpen +
                ", hasBeenAccepted=" + hasBeenAccepted +
                ", senderId=" + senderId +
                ", recieverId=" + recieverId +
                ", groupId=" + groupId +
                '}';
    }
}
