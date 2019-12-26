package com.syj.webflux.app.controller;

import com.syj.webflux.app.entity.User;
import com.syj.webflux.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Flux<User>> list() {
        log.debug("list : {}", "test");
        log.info("list : {}", "test");
        return ResponseEntity.ok(userService.getList());
    }

    @PostMapping("/insert")
    public ResponseEntity<Mono<User>> insert() {
        return ResponseEntity.ok(userService.insert());
    }

}
