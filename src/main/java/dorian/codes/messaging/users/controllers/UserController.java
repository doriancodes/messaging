package dorian.codes.messaging.users.controllers;

import dorian.codes.messaging.users.models.UserNickname;
import dorian.codes.messaging.users.services.UserService;
import dorian.codes.messaging.validation.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.CREATED)
    UserNickname createUser(@RequestBody UserNickname userNickname) {
        try {
            return userService.createUser(userNickname);
        } catch (DataIntegrityViolationException e) {
            throw new ForbiddenException(e.getMessage());
        }
    }

}

