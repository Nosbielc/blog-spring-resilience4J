package com.nosbielc.blogspringresilience4j.infrastructure.delivery;

import com.nosbielc.blogspringresilience4j.core.user.ResilientUserService;
import com.nosbielc.blogspringresilience4j.core.user.UserService;
import com.nosbielc.blogspringresilience4j.infrastructure.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/front")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(ResilientUserService resilientUserService) {
        this.userService = resilientUserService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> login(@PathVariable Long id){
        return ResponseEntity.ok(userService.login(id));
    }

}
