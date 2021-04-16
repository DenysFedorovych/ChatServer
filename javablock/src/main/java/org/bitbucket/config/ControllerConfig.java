package org.bitbucket.config;

import org.bitbucket.controllers.UserControllers;

public class ControllerConfig {

    public static UserControllers usersController(){
        return new UserControllers(DatabaseConfig.getUsersService());
    }

}
