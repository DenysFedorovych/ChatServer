package org.bitbucket.network;

import org.bitbucket.payload.Envelope;
import org.bitbucket.utils.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

public class Broker {

    private static final Logger logger = LoggerFactory.getLogger(Broker.class);

    public void broadcast(List<Session> sessions, Envelope envelope) {
//        String message = JsonHelper.toFormat(envelope).orElseThrow();
        sessions.forEach(session -> {
            try {
                session.getBasicRemote().sendText(envelope.getPayload());
            } catch (IOException exception) {
                logger.warn("Enter : {}", exception.getMessage());
            }
        });

    }

    public void send(Session session, Envelope payload) {
        // TODO: 03.05.2021 make send method
    }

}
