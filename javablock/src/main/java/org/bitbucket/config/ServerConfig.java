package org.bitbucket.config;

import jakarta.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class ServerConfig {

    public static Tomcat tomcat() throws ServletException {
        Tomcat tomcat = new Tomcat();
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.getInteger(webPort));
        Context ctx = tomcat.addWebapp("/", new File(".").getAbsolutePath());
        tomcat.addServlet("", "UserHandler", HandlerConfig.userHandler());
        ctx.addServletMappingDecoded("/", "UserHandler");
        return tomcat;
    }
}
