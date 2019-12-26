package com.syj.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class WebFluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> test() {
        return RouterFunctions.route(RequestPredicates.path("/hello/{name}"),
                request -> ServerResponse.ok().body(Mono.just("Hello" + request.pathVariable("name")), String.class)
        );
    }

}
