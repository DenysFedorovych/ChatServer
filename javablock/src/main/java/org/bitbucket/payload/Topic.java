package org.bitbucket.payload;

public enum Topic{
    auth("auth"),
    messages("messages"),
    connect("connect"),
    disconnect("disconnect");

    private String val;

    Topic(String val){
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
