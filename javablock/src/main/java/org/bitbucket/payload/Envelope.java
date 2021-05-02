package org.bitbucket.payload;

public class Envelope {

    Topic topic;

    private String payload;

    public Topic getTopic() {
        return topic;
    }

    public String getPayload() {
        return payload;
    }
}
