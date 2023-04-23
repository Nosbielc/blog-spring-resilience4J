package com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.projections;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "usersResume", types = { User.class })
public interface UsersResume {

    Long getId();

    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();

    String getEmail();
    Integer getAge();

}