package org.bitbucket.payload;

public class Envelope {

    private Topic topic;

    private String payload;

    public void setTopic(String s) {
        this.topic = Topic.getTopic(s);
    }

    public Topic getTopic() {
        return topic;
    }

    public String getPayload() {
        return payload;
    }
}
