package dorian.codes.messaging.messages;

import org.springframework.web.bind.annotation.*;

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
    Message sendMessage(@RequestBody ApiMessage apiMessage) {
        return repository.save(new Message(apiMessage.getContent(), apiMessage.getSenderId(), apiMessage.getReceiverId()));
    }
}

class ApiMessage {
    private String content;
    private Long senderId;
    private Long receiverId;

    ApiMessage() {

    }

    ApiMessage(Long senderId, Long receiverId, String content) {
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
