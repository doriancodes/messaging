package dorian.codes.messaging.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private MessageRepository repository;

    MessageController(MessageRepository repository){
        this.repository = repository;
    }

    @GetMapping("/messages")
    List<Message> all() {
        return repository.findAll();
    }
}
