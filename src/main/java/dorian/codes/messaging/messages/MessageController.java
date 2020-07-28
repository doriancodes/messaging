package dorian.codes.messaging.messages;

import dorian.codes.messaging.messages.models.ApiMessage;
import dorian.codes.messaging.messages.models.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/messages/user/{id}/received")
    List<Message> messagesReceived(@PathVariable("id") Long id) {
        return repository.findByReceiverId(id);
    }

    @GetMapping("/messages/user/{receiverId}/received/from/{senderId}")
    List<Message> messagesReceived(@PathVariable("receiverId") Long receiverId, @PathVariable("senderId") Long senderId) {
        return repository.findByReceiverIdFilterSender(receiverId, senderId);
    }

    @GetMapping("/messages/user/{id}/sent")
    List<Message> messagesSent(@PathVariable("id") Long id) {
        return repository.findBySenderId(id);
    }

    @PostMapping("/messages/user/send")
    ApiMessage sendMessage(@RequestBody ApiMessage apiMessage) {
        Message newMessage = repository.save(new Message(apiMessage.getContent(), apiMessage.getSenderId(), apiMessage.getReceiverId()));
        return apiMessage;
    }
}

