package org.bitbucket.config;

import org.bitbucket.handlers.UsersHandlers;
import org.bitbucket.handlers.WebsocketHandler;
import org.bitbucket.network.Broker;
import org.bitbucket.network.WebsocketConnectionPool;

public class HandlerConfig {
    public static UsersHandlers usersHandlers() {
        return new UsersHandlers(ControllerConfig.usersController());
    }

    public static WebsocketHandler websocketHandler() {
        return new WebsocketHandler(new WebsocketConnectionPool(), new Broker());
    }
}
