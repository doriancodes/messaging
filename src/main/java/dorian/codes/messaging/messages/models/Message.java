package dorian.codes.messaging.messages.models;


import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "receiver_id")
    private Long receiverId;

    public Message() {
    }

    public Message(String content, Long senderId, Long receiverId) {
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

    public ApiMessage toApiMessage() {
        return new ApiMessage(this.content, this.senderId, this.receiverId);
    }
}
