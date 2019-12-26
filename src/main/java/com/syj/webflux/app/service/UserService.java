package com.syj.webflux.app.service;

import com.syj.webflux.app.entity.User;
import com.syj.webflux.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<User> getList() {
        return userRepository.findAll();
    }

    public Mono<User> insert() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("신영진");
        return userRepository.save(user);
    }
}
