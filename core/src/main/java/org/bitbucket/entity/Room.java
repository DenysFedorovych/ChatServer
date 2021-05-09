package org.bitbucket.entity;

import org.bitbucket.payload.Message;

import java.util.List;

public class Room {

    private final String name;

    private final List<Message> history;

    private final List<User> members;

    public Room(String name, List<Message> history, List<User> members) {
        this.name = name;
        this.history = history;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<Message> getHistory() {
        return history;
    }

    public List<User> getMembers() {
        return members;
    }
}
