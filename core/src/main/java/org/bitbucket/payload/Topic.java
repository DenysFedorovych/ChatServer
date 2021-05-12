package org.bitbucket.payload;

public enum Topic{
    auth("auth"),
    messages("messages"),
    disconnect("disconnect");

    private String val;

    Topic(String val){
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public static Topic getTopic (String str) {
        for(Topic each : values()) {
            if(each.getVal().equals(str)) return each;
        }
        throw new IllegalArgumentException("Unhandled topic");
    }
}
