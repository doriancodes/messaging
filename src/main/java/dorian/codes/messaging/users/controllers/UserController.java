package dorian.codes.messaging.users.controllers;

import dorian.codes.messaging.users.models.UserNickname;
import dorian.codes.messaging.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/new")
    UserNickname createUser(@RequestBody UserNickname userNickname) {

        return userService.createUser(userNickname);
    }

}

