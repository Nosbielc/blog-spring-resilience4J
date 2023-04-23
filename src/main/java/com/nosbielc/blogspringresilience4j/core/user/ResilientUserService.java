package com.nosbielc.blogspringresilience4j.core.user;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResilientUserService implements UserService {

    private final UserService userService;

    @CircuitBreaker(name = "userService", fallbackMethod = "fallback")
    @RateLimiter(name = "userService")
    @Override
    public User login(Long id) {
        return userService.login(id);
    }

    private User fallback(Throwable throwable){
        return User.builder().withAge(1000).withId(-1L).withEmail("naoecontrado@email.com").withFirstName("Sem nome").withLastName("Sem nome de famila").build();
    }
}
