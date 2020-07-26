package dorian.codes.messaging.users;

import dorian.codes.messaging.messages.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;

    UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/users")
    List<User> all(){
        return service.all();
    }




}
