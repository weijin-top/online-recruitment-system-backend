package com.weijin.recruitment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2025/3/22 10:52
 */
@Configuration
@EnableWebSocket
// @EnableWebSocketMessageBroker
public class WebsocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
