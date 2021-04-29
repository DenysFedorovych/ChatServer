package org.bitbucket.utils;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.websocket.server.Constants;
import org.bitbucket.handlers.WebSocketHandler;

import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpointConfig;

public class WrapTomcat extends Tomcat {

    private Context ctx;

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public void websocketRegistry(Object handler) {
        ServerContainer scon = (ServerContainer) ctx.getServletContext().getAttribute(Constants.SERVER_CONTAINER_SERVLET_CONTEXT_ATTRIBUTE);
        try {
            scon.addEndpoint(ServerEndpointConfig.Builder.create(WebSocketHandler.class,"/echo")
                    .configurator(new ServerEndpointConfig.Configurator() {
                        @Override
                        public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
                            return (T) handler;
                        }
                    }).build());
        } catch (DeploymentException e) {
            e.printStackTrace();
        }

    }
}
