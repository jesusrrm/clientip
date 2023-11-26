package com.hvacguardian.clientip.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hvacguardian.clientip.handler.ClientIpHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class ClientIpRouter {
    
    @Bean
    public RouterFunction<ServerResponse> route(ClientIpHandler clientIpHandler) {
      return RouterFunctions
        .route(GET("/client-ip").and(accept(MediaType.APPLICATION_JSON)), clientIpHandler::getClientIp);
    }
}
