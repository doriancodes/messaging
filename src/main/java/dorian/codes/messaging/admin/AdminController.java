package dorian.codes.messaging.admin;

import dorian.codes.messaging.users.User;
import dorian.codes.messaging.users.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private final UserRepository uRepository;


    public AdminController(UserRepository userRepository){
        this.uRepository = userRepository;
    }

    @GetMapping("/admin/users")
    List<User> all() {
        return uRepository.findAll();
    }
}
