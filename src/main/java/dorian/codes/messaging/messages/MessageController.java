package dorian.codes.messaging.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/messages")
    List<Message> all() {
        return repository.findAll();
    }


    @GetMapping("/user/{id}/received")
    List<Message> messagesReceived(@PathVariable("id") Long id) {
        return repository.findByReceiverId(id);
    }

    @GetMapping("/user/{id}/sent")
    List<Message> messagesSent(@PathVariable("id") Long id) {
        return repository.findBySenderId(id);
    }
}
