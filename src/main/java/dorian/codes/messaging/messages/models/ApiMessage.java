package dorian.codes.messaging.messages.models;

public class ApiMessage {
    private String content;
    private Long senderId;
    private Long receiverId;

    ApiMessage() {

    }

    public ApiMessage(String content, Long senderId, Long receiverId ) {
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
