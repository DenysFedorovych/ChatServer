package org.bitbucket.handlers;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chat")
public class WebSocketHandler {

    @OnMessage
    public void messages(Session session, String payload) {
        System.out.println(payload);
        try {
            session.getBasicRemote().sendText(payload);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
