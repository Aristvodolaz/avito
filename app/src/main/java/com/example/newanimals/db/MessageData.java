package com.example.newanimals.db;

public class MessageData {
    public String idMessage;
    public String senderId;
    public String text;
    public long date;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public MessageData(String idMessage, String senderId, String text, long date) {
        this.idMessage = idMessage;
        this.senderId = senderId;
        this.text = text;
        this.date = date;
    }
}
