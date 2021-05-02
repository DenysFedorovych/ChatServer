package org.bitbucket.handlers;

import org.bitbucket.network.Broker;
import org.bitbucket.payload.Envelope;
import org.bitbucket.payload.Token;
import org.bitbucket.utils.JsonHelper;
import org.bitbucket.utils.TokenProvider;
import org.bitbucket.utils.WebsocketConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class WebsocketHandler {

    private final Logger logger = LoggerFactory.getLogger(WebsocketHandler.class);

    private final WebsocketConnectionPool websocketConnectionPool;

    private final Broker broker;

    public WebsocketHandler(WebsocketConnectionPool websocketConnectionPool, Broker broker) {
        this.websocketConnectionPool = websocketConnectionPool;
        this.broker = broker;
    }

    @OnMessage
    public void messages(Session session, String payload) {
        try {
            Envelope env = JsonHelper.fromFormat(payload, Envelope.class).orElseThrow();
            switch (env.getTopic()) {
                case auth:
                    Token result = TokenProvider.decode(env.getPayload());
                    Long id = result.getUserId();
                    this.websocketConnectionPool.addSession(id, session);
                    break;
                case messages:
                    this.broker.broadcast(this.websocketConnectionPool.getSessions(), env);
                    break;
                case disconnect:
                    //TODO
                    break;
                default:
            }
        } catch (Throwable e) {
            //TODO single sent about user
            logger.warn("Enter {}", e.getMessage());
        }
    }
}
