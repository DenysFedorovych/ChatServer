package org.bitbucket.entity;

import org.bitbucket.payload.Message;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Room {

    private final String name;

    private final List<Message> history;

    private final List<User> members;

    private final List<Session> sessions;

    public Room(String name) {
        this.name = name;
        this.history = new LinkedList<>();
        this.members = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    public void addMember(User user) {
        this.members.add(user);
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

    public List<Session> getSessions() {
        return sessions;
    }
}
