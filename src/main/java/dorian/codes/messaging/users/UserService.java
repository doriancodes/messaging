package dorian.codes.messaging.users;

import dorian.codes.messaging.messages.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository uRepository;

    @Autowired
    private MessageRepository msgRepository;

    UserService(){}

    UserService(UserRepository uRepository, MessageRepository msgRepository){
        this.uRepository = uRepository;
        this.msgRepository = msgRepository;
    }

    List<User> all(){
        return uRepository.findAll();
    }
}
