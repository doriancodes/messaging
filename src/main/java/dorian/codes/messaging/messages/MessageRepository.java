package dorian.codes.messaging.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.senderId = ?1")
    List<Message> findBySenderId(Long senderId);

    @Query("SELECT m FROM Message m WHERE m.receiverId = ?1")
    List<Message> findByReceiverId(Long receiverId);

    @Query("SELECT m FROM Message m WHERE m.receiverId = ?1 AND m.senderId = ?2")
    List<Message> findByReceiverIdFilterSender(Long receiverId, Long senderId);
}
