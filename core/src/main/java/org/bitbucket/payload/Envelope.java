package org.bitbucket.payload;

import org.bitbucket.utils.TokenProvider;

import java.util.Objects;

public class Envelope {

    private Topic topic;

    private String token;

    private Message message;

    public Envelope(Topic topic, Token token, Message message) {
        this.topic = topic;
        this.token = TokenProvider.encode(token);
        this.message = message;
    }

    public void setTopic(String s) {
        this.topic = Topic.getTopic(s);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getToken() {
        return token;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Envelope envelope = (Envelope) o;
        return topic == envelope.topic &&
                Objects.equals(token, envelope.token) &&
                Objects.equals(message, envelope.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, token, message);
    }
}
