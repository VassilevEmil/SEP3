package via.group6.tier2.Model;

import java.io.Serializable;

public class Message implements Serializable {
    private String message;

    public Message(){}
    public Message(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
