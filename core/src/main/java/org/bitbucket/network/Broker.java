package org.bitbucket.network;

import org.bitbucket.payload.Message;
import org.bitbucket.utils.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

public class Broker {

    private static final Logger logger = LoggerFactory.getLogger(Broker.class);

    public void broadcast(List<Session> sessions, Message message) {
        String json = JsonHelper.toFormat(message).get();
        sessions.forEach(session -> {
            send(session, json);
        });
    }

    public void send(Session session, String str) {
        try {
            session.getBasicRemote().sendText(str);
        } catch (IOException exception) {
            logger.warn("Enter : {}", exception.getMessage());
        }
    }

}
