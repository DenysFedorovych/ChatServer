package org.bitbucket.config;

import org.bitbucket.handlers.UsersHandlers;

public class HandlerConfig {
    public static UsersHandlers usersHandlers(){
        return new UsersHandlers(ControllerConfig.usersController());
    }
}
