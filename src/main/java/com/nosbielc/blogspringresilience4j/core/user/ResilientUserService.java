package com.nosbielc.blogspringresilience4j.core.user;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResilientUserService implements UserService {

    private final UserService userService;

    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackCircuitBreaker")
    @Retry(name = "userService", fallbackMethod = "fallbackRetry")
    @Bulkhead(name = "userService")
    @RateLimiter(name = "userService")
    @Override
    public User login(Long id) {
        return userService.login(id);
    }

    private User fallbackCircuitBreaker(Throwable throwable){
        return User.builder().withAge(1000).withId(-1L).withEmail("default@email.com").withFirstName("CircuitBreaker").withLastName("Sem nome de famila").build();
    }

    private User fallbackRetry(Throwable throwable){
        return User.builder().withAge(1000).withId(-1L).withEmail("default@email.com").withFirstName("Retry").withLastName("Sem nome de famila").build();
    }
}
