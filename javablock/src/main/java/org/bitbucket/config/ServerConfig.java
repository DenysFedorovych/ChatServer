package org.bitbucket.config;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.bitbucket.handlers.WebSocketHandler;

import javax.servlet.ServletException;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpointConfig;
import java.io.File;

public class ServerConfig {
    public static void tomcat() throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "5432";
        }

        tomcat.setPort(Integer.parseInt(webPort));
        Context ctx = tomcat.addWebapp("/", new File(".").getAbsolutePath());
        tomcat.addServlet("","UsersHandler",HandlerConfig.usersHandlers());
        ctx.addServletMappingDecoded("/","UsersHandler");

        tomcat.start();
        ServerContainer scon = (ServerContainer) ctx.getServletContext().getAttribute(ServerContainer.class.getName());
        try {
            scon.addEndpoint(ServerEndpointConfig.Builder.create(WebSocketHandler.class,"/echo")
                    .configurator(new ServerEndpointConfig.Configurator() {
                @Override
                public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
                    return (T) new WebSocketHandler();
                }
            }).build());
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }

    public static ServerEndpointConfig.Configurator sec = new ServerEndpointConfig.Configurator() {
        @Override
        public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
            return (T) new WebSocketHandler();
        }
    };
}
