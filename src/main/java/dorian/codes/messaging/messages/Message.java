package dorian.codes.messaging.messages;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
    private @Id @GeneratedValue Long id;
    private String content;
    private Long senderId;
    private Long receiverId;

    public Message(){}

    public Message(String content, Long senderId, Long receiverId){
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSenderId() {
        return senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }
}
