package org.bitbucket.config;

import org.apache.catalina.LifecycleException;
import org.bitbucket.handlers.WebSocketHandler;
import org.bitbucket.utils.WrapTomcat;

import javax.servlet.ServletException;

public class AppConfig {

    public static void startTomcat() {
        try {
            WrapTomcat t = ServerConfig.tomcat();
            t.start();
            t.websocketRegistry(new WebSocketHandler());
            t.getServer().await();
        } catch (ServletException|LifecycleException e) {
            System.out.printf("Enter:%s",e.getMessage());
        }
    }

}
