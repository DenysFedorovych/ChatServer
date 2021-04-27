package org.bitbucket;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.bitbucket.config.ServerConfig;

import javax.servlet.ServletException;

public class ChatServerRun {

    public static void main(String[] args) {
        Tomcat t = null;
        try {
            ServerConfig.tomcat();
//            t.start();
//            t.getServer().await();
        } catch (ServletException e) {
            System.out.printf("Enter:%s",e.getMessage());
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
