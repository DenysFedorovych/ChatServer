package org.bitbucket.config;

import org.apache.catalina.Context;
import org.apache.catalina.User;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.bitbucket.controllers.UserControllers;
import org.bitbucket.handlers.UsersHandlers;

import javax.servlet.ServletException;
import java.io.File;

public class ServerConfig {
    public static Tomcat tomcat() throws ServletException {
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));
        Context ctx = tomcat.addWebapp("/", new File(".").getAbsolutePath());

        tomcat.addServlet("","UsersHandler",HandlerConfig.usersHandlers());
        ctx.addServletMappingDecoded("/","UsersHandler");
        return tomcat;
    }
}
