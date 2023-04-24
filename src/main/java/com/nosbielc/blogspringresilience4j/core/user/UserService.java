package com.nosbielc.blogspringresilience4j.core.user;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;

public interface UserService {

    User login(Long id);

}
