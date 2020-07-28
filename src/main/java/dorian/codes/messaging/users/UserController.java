package dorian.codes.messaging.users;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/users/new")
    UserNickname newUser(@RequestBody UserNickname userNickname){

        User newUser = repository.save(new User(userNickname.getNickname()));

        return new UserNickname(newUser.getNickname());
    }

}

