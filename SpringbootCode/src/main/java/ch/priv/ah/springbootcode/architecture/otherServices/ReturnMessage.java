package ch.priv.ah.springbootcode.architecture.otherServices;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @class: ReturnMessage
 * @author: Anes Hodza
 * @version: 22.07.2021
 **/

@ResponseBody
public class ReturnMessage {

    private int returnCode;
    private String returnMessage;
    private boolean hasWorked;

    public ReturnMessage(int returnCode, String returnMessage, boolean hasWorked) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.hasWorked = hasWorked;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public boolean isHasWorked() {
        return hasWorked;
    }

    public void setHasWorked(boolean hasWorked) {
        this.hasWorked = hasWorked;
    }

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "returnCode=" + returnCode +
                ", returnMessage='" + returnMessage + '\'' +
                ", hasWorked=" + hasWorked +
                '}';
    }


}
