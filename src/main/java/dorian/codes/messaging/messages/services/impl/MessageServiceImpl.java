package dorian.codes.messaging.messages.services.impl;

import dorian.codes.messaging.messages.models.ApiMessage;
import dorian.codes.messaging.messages.models.Message;
import dorian.codes.messaging.messages.repositories.MessageRepository;
import dorian.codes.messaging.messages.services.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public List<ApiMessage> findBySenderId(Long senderId) {
        return toApiMessagesList(messageRepository.findBySenderId(senderId));
    }

    @Override
    public List<ApiMessage> findByReceiverId(Long receiverId) {
        return toApiMessagesList(messageRepository.findByReceiverId(receiverId));
    }

    @Override
    public List<ApiMessage> findByReceiverIdFilterSender(Long receiverId, Long senderId) {
        return toApiMessagesList(messageRepository.findByReceiverIdFilterSender(receiverId, senderId));
    }

    @Override
    public ApiMessage save(ApiMessage apiMessage) {
       Message newMessage =  new Message(apiMessage.getContent(), apiMessage.getSenderId(), apiMessage.getReceiverId());
        return messageRepository.save(newMessage).toApiMessage();
    }

    private List<ApiMessage> toApiMessagesList(List<Message> messagesList) {
        List<ApiMessage> apiMessages = new ArrayList<>();

        for (Message m : messagesList) {
            apiMessages.add(m.toApiMessage());
        }

        return apiMessages;
    }
}
