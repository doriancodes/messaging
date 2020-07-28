package dorian.codes.messaging.messages.services;

import dorian.codes.messaging.messages.models.ApiMessage;

import java.util.List;

public interface MessageService {

    public List<ApiMessage> findBySenderId(Long senderId);

    public List<ApiMessage> findByReceiverId(Long receiverId);

    public List<ApiMessage> findByReceiverIdFilterSender(Long receiverId, Long senderId);

    public ApiMessage save(ApiMessage apiMessage);
}
