package org.bitbucket.config;

import org.bitbucket.handlers.UsersHandlers;

public class HandlerConfig {

    public static UsersHandlers userHandler() {
        return new UsersHandlers(ControllerConfig.userControllers());
    }
}
