package org.bitbucket;

import org.bitbucket.config.AppConfig;

public class ChatServerRun {

    public static void main(String[] args) {
        AppConfig.startTomcat();
    }

}
