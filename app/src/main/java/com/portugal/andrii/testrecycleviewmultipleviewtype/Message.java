package com.portugal.andrii.testrecycleviewmultipleviewtype;

public class Message {
    public enum MessageType{
        MY_MESSAGE,
        YOUR_MESSAGE,
        RECLAM_MESSAGE;
    }
    private String context;
    private MessageType type;

    public Message(String context, MessageType type) {
        this.context = context;
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
