package org.bitbucket.config;

import org.bitbucket.controllers.UserControllers;

public class ControllerConfig {

    public static UserControllers userControllers() {
        return new UserControllers();
    }
}
