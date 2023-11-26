package com.hvacguardian.clientip.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import com.hvacguardian.clientip.model.ClientIp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientIpHandler {

    public Mono<ServerResponse> getClientIp(ServerRequest request) {
         String clientIp = request.remoteAddress()
                 .map(address -> address.getAddress().getHostAddress())
                 .orElse("Unknown");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(new ClientIp(clientIp)));
    }
}




