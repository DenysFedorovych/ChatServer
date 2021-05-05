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

    public static Topic getTopic(String s) {
        for(Topic t: values()) {
            if(t.getVal().equals(s)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No topic");
    }
}
