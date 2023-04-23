package com.nosbielc.blogspringresilience4j.core.user;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;
import com.nosbielc.blogspringresilience4j.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User login(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
