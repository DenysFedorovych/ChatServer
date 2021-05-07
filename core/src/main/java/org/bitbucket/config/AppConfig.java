package org.bitbucket.config;

import javax.servlet.ServletException;

public class AppConfig {

    public static void startTomcat() {
        try {
            ServerConfig.tomcat().run();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
