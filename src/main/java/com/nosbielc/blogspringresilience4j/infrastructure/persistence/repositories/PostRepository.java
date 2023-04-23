package com.nosbielc.blogspringresilience4j.infrastructure.persistence.repositories;

import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post, Long>, CrudRepository<Post, Long>,
        JpaSpecificationExecutor<Post> {
}
