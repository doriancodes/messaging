package dorian.codes.messaging.admin;

import dorian.codes.messaging.messages.models.Message;
import dorian.codes.messaging.messages.repositories.MessageRepository;
import dorian.codes.messaging.users.models.User;
import dorian.codes.messaging.users.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private final UserRepository uRepository;

    private final MessageRepository msgRepository;


    public AdminController(UserRepository userRepository, MessageRepository msgRepository) {
        this.uRepository = userRepository;
        this.msgRepository = msgRepository;
    }

    @GetMapping("/admin/users")
    List<User> allUsers() {
        return uRepository.findAll();
    }

    @GetMapping("/admin/messages")
    List<Message> allMessages() {
        return msgRepository.findAll();
    }

}
