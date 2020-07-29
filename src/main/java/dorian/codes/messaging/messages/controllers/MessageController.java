package dorian.codes.messaging.messages.controllers;

import dorian.codes.messaging.messages.models.ApiMessage;
import dorian.codes.messaging.messages.services.MessageService;
import dorian.codes.messaging.validation.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;


    @GetMapping("/messages/user/{id}/received")
    List<ApiMessage> messagesReceived(@PathVariable("id") Long id) {
        return messageService.findByReceiverId(id);
    }

    @GetMapping("/messages/user/{receiverId}/received/from/{senderId}")
    List<ApiMessage> messagesReceived(@PathVariable("receiverId") Long receiverId, @PathVariable("senderId") Long senderId) {
        return messageService.findByReceiverIdFilterSender(receiverId, senderId);
    }

    @GetMapping("/messages/user/{id}/sent")
    List<ApiMessage> messagesSent(@PathVariable("id") Long id) {
        return messageService.findBySenderId(id);
    }

    @PostMapping("/messages/user/send")
    @ResponseStatus(HttpStatus.CREATED)
    ApiMessage sendMessage(@RequestBody ApiMessage apiMessage) {
        if (apiMessage.getSenderId() == apiMessage.getReceiverId()){
            throw new ForbiddenException("A user can't send a message to themselves!");
        }
        return messageService.save(apiMessage);
    }
}

