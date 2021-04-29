package org.bitbucket.config;

import org.apache.catalina.Context;
import org.apache.tomcat.websocket.server.WsContextListener;
import org.bitbucket.utils.WrapTomcat;

import javax.servlet.ServletException;
import java.io.File;

public class ServerConfig {
    public static WrapTomcat tomcat() throws ServletException {
        WrapTomcat tomcat = new WrapTomcat();

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "5432";
        }
        tomcat.setPort(Integer.parseInt(webPort));
        Context ctx = tomcat.addWebapp("/", new File(".").getAbsolutePath());
        ctx.addApplicationListener(WsContextListener.class.getName());
        tomcat.setCtx(ctx);
        tomcat.addServlet("","UsersHandler",HandlerConfig.usersHandlers());
        ctx.addServletMappingDecoded("/","UsersHandler");
        return tomcat;
    }
}
