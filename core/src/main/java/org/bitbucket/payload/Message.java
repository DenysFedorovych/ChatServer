package org.bitbucket.payload;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private String message;

    private String nickname;

    private String date;

    public Message(String message, String nickname, Date date) {
        this.message = message;
        this.nickname = nickname;
        this.date = getDateString(date);
    }

    private String getDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return format.format(date);
    }

    public String getMessage() {
        return message;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDate() {
        return date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
